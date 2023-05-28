package engine

import Time
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


//This guy works better as a global variable
lateinit var time: Time

/**
 * Constants for time calculations.
 */
private const val oneSecondInNano = 1_000L
private const val fps = 80
const val desiredMillisPerFrame = oneSecondInNano / fps

/**
 * Runs the provided block of code at a regular interval determined by the desired FPS.
 */
@Composable
fun Run(deltaBlock: (Double, Int) -> Unit) {
    LaunchedEffect(Unit) {
        var lastLoopTime = time.now()
        while (true) {
            withFrameNanos { nanos ->
                val dt = (nanos - lastLoopTime).coerceAtLeast(0)
                lastLoopTime = nanos
                val fps = (if (dt > 0) 1_000_000_000.0 / dt else Double.MAX_VALUE).toInt()
                deltaBlock(dt.toDouble(), fps)
            }
            delay(desiredMillisPerFrame)
        }
    }
}


/**
 * Renders the provided content on a Canvas, updating it at a regular interval.
 */
@OptIn(ExperimentalTextApi::class)
@Composable
fun RenderCompose(modifier: Modifier = Modifier, content: DrawScope.(Double) -> Unit) {
    var state by remember { mutableStateOf(0.0) }
    var currentFPS = 0
    val fontFamily = LocalFontFamilyResolver.current
    val showFPS = true

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

/**
 * Runs the provided simulation at a regular interval.
 */
@Composable
fun SimulateCompose(simulation: (Double) -> Unit) {
    var state by remember { mutableStateOf(0.0) }

    Run { delta, _ ->
        state = delta
    }

    simulation(state)
}