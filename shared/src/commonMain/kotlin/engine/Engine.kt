package engine

import Time
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import kotlinx.coroutines.delay


//This guy works better as a global variable
lateinit var time: Time

/**
 * Constants for time calculations.
 */
private const val oneSecondInNano = 1_000_000_000L
private const val fps = 60
const val desiredMillisPerFrame = oneSecondInNano / fps

/**
 * Runs the provided block of code at a regular interval determined by the desired FPS.
 */
@Composable
fun Run(deltaBlock: (Double) -> Unit) {
    LaunchedEffect(Unit) {
        var lastLoopTime = time.now()

        while (true) {
            withFrameNanos { nanos ->
                val dt = (nanos - lastLoopTime).coerceAtLeast(0)
                lastLoopTime = nanos
                deltaBlock(dt.toDouble())
            }

            delay(desiredMillisPerFrame)
        }
    }
}

/**
 * Renders the provided content on a Canvas, updating it at a regular interval.
 */
@Composable
fun RenderCompose(modifier: Modifier = Modifier, content: DrawScope.(Double) -> Unit) {
    var state by remember { mutableStateOf(0.0) }

    Run { state = it }

    Canvas(modifier) {
        content(state)
    }
}

/**
 * Runs the provided simulation at a regular interval.
 */
@Composable
fun SimulateCompose(simulation: (Double) -> Unit) {
    var state by remember { mutableStateOf(0.0) }

    Run { state = it }

    simulation(state)
}