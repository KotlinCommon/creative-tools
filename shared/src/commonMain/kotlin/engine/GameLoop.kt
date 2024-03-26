package engine


import androidx.compose.foundation.Canvas
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlinx.coroutines.delay
import kotlin.math.max

/**
 * Constants for time calculations.
 */
private const val oneSecondInNano = 1_000_000_000.0
private const val fps = 60.0
const val desiredMillisPerFrame = oneSecondInNano / fps

expect fun platformSleep(millis: Long)

/**
 * Runs the provided block of code at a regular interval determined by the desired FPS.
 */
@Composable
fun Run(deltaBlock: (Double, Int) -> Unit) {
    LaunchedEffect(Unit) {
        var lastLoopTime = _time.now()

        while (true) {
            withFrameNanos { it }  // This waits for the next frame.
            val now = _time.now()
            val updateLength = now - lastLoopTime

            if (updateLength >= desiredMillisPerFrame) {
                lastLoopTime = now
                val delta = updateLength / desiredMillisPerFrame
                val fps = if (delta > 0) {
                    100.0/delta
                }else{
                    0
                }
                deltaBlock(delta, fps.toInt())

                val waitTime = (lastLoopTime - _time.now() + desiredMillisPerFrame) / oneSecondInNano
                delay(max(waitTime.toUInt(), 0u).toLong())
            }
        }
    }
}

/**
 * Renders the provided content on a Canvas, updating it at a regular interval.
 */
@Composable
fun RenderCompose(modifier: Modifier = Modifier, content: DrawScope.(Double) -> Unit) {
    var state by remember { mutableStateOf(0.0) }
    var currentFPS = 0
    val fontFamily = LocalFontFamilyResolver.current

    Run { delta, fps ->
        state = delta
        currentFPS = fps
    }

    Canvas(modifier) {
        if (showFPS) {
            drawFPS(fontFamily, currentFPS)
        }
        content(state)
    }
}

/**
 * Runs the provided simulation at a regular interval.
 */
@Composable
fun SimulateCompose(simulation: (Double) -> Unit) {
    Run { delta, _ ->
        simulation(delta)
    }
}

@OptIn(ExperimentalTextApi::class)
private fun DrawScope.drawFPS(fontFamily: FontFamily.Resolver, currentFPS: Int) {
    this.drawRect(color = Red, size = Size(height = 35f, width = 240f))
    this.drawText(
        style = TextStyle.Default.copy(color = Green),
        textMeasurer = TextMeasurer(
            fallbackFontFamilyResolver = fontFamily,
            fallbackDensity = Density(1f),
            fallbackLayoutDirection = LayoutDirection.Ltr,
        ),
        size = Size(height = 35f, width = 240f),
        text = AnnotatedString("Current FPS: $currentFPS"),
    )
}
