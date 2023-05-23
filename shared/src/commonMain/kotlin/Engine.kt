//import androidx.compose.foundation.Canvas
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.drawscope.DrawScope
//import kotlinx.coroutines.delay
//import kotlin.math.max
//
///**
// * Constants for time calculations.
// */
//private const val ONE_SECOND_IN_NANO = 1_000_000_000L
//private const val FPS = 60
//
///**
// * Runs the provided block of code at a regular interval determined by the desired FPS.
// */
//@Composable
//fun Run(deltaBlock: (Double) -> Unit) {
//    LaunchedEffect(Unit) {
//        var lastLoopTime = System.nanoTime()
//        val optimalTime = ONE_SECOND_IN_NANO / FPS
//
//        while (true) {
//            withFrameNanos { it }  // This waits for the next frame.
//            var now = System.nanoTime()
//            val updateLength = now - lastLoopTime
//
//            if (updateLength >= optimalTime) {
//                lastLoopTime = now
//                val delta = updateLength / optimalTime.toDouble()
//                deltaBlock(delta)
//
//                val waitTime = (lastLoopTime - System.nanoTime() + optimalTime) / ONE_SECOND_IN_NANO
//                delay(max(waitTime, 0L))
//            }
//        }
//    }
//}
//
///**
// * Renders the provided content on a Canvas, updating it at a regular interval.
// */
//@Composable
//fun RenderCompose(modifier: Modifier = Modifier, content: DrawScope.(Double) -> Unit) {
//    var state by remember { mutableStateOf(0.0) }
//
//    Run { state = it }
//
//    Canvas(modifier) {
//        content(state)
//    }
//}
//
///**
// * Runs the provided simulation at a regular interval.
// */
//@Composable
//fun SimulateCompose(simulation: (Double) -> Unit) {
//    var state by remember { mutableStateOf(0.0) }
//
//    Run { state = it }
//
//    simulation(state)
//}