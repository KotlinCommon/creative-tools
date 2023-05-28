package engine


import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import showFPS
import time

/**
 * Constants for time calculations.
 */
private const val oneSecondInNano = 1_000L
private const val fps = 80
private const val desiredMillisPerFrame = oneSecondInNano / fps

/**
 * Runs the provided block of code at a regular interval determined by the desired FPS.
 */
@OptIn(DelicateCoroutinesApi::class)
@Composable
fun Run(deltaBlock: (Double, Int) -> Unit) {
    val simulationScope = rememberCoroutineScope { GlobalScope.coroutineContext }

    LaunchedEffect(Unit) {
        simulationScope.launch {
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

    DisposableEffect(Unit) {
        onDispose {
            simulationScope.cancel()
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
    Run { delta, _ ->
        simulation(delta)
    }
}