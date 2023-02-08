package daat.spart.common.engine

/**
 * This code is a simulation engine for a game written in Kotlin using the Compose UI framework.
 * The engine's main logic is contained within the simulation() function,
 * which runs in a coroutine launched in the GlobalScope.
 */

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow


@OptIn(DelicateCoroutinesApi::class)
val simulation = GlobalScope.launch {
    simulation()
}


/**
 * `mutableDelta` is a MutableStateFlow that stores the elapsed time in seconds since the last update of the game state.
 * It is used to keep track of the current state of the game and is updated in each iteration of the while loop in the `simulation()` function.
 **/
val mutableDelta = MutableStateFlow(0.0)

/**
 * The `simulation()` function is the main logic for the game simulation engine.
 * It sets a target FPS, and uses a while loop to continuously update the game state.
 * The elapsed time since the last update is calculated, and if it's greater than the optimal time to reach the target FPS,
 * the game state is updated and the new delta value is emitted to the `mutableDelta` MutableStateFlow.
 **/
// The simulation() function launches a coroutine using launch and runs the main logic for the game simulation engine.
// It takes in two optional parameters, dispatcher (defaults to Dispatchers.IO) and fps (defaults to 60).
private suspend fun simulation(
    dispatcher: CoroutineDispatcher = Dispatchers.IO, fps: Int = 60
) {
    val oneSecondInANanoSecond = 1000000000
    // lastLoopTime keeps track of the last time the game state was updated, initially set to the current time in nanoseconds.
    var lastLoopTime = System.nanoTime()
    // optimalTime is the optimal time between updates, calculated as one second divided by the fps value.
    val optimalTime = (oneSecondInANanoSecond / fps).toLong()
    // lastFpsTime is used to calculate the current FPS, initially set to 0.
    var lastFpsTime: Long = 0
    // gameTime is used to determine the amount of time to wait before updating the game state again.
    var gameTime: Long

    // The `coroutineScope` function creates a coroutine scope and runs the code block provided within this scope.
    coroutineScope {
        // The `launch` function starts a new coroutine within the current scope.
        // The coroutine runs the code block provided and uses the specified `dispatcher` (defaults to `Dispatchers.IO`).
        launch(dispatcher) {
            // The while loop continuously updates the game state.
            while (true) {
                // `now` is the current time in nanoseconds.
                val now = System.nanoTime()
                // `updateLength` is the elapsed time in nanoseconds since the last update of the game state.
                val updateLength = now - lastLoopTime

                // If the elapsed time is less than the `optimalTime`, the loop continues to the next iteration.
                if (updateLength < optimalTime) {
                    continue
                }

                // `lastLoopTime` is updated to the current time.
                lastLoopTime = now
                // `delta` is the elapsed time in seconds since the last update.
                val delta = updateLength / optimalTime.toDouble()

                // `lastFpsTime` is updated with the elapsed time.
                lastFpsTime += updateLength
                // If the elapsed time is greater than or equal to one second, the value of `lastFpsTime` is reset to 0.
                if (lastFpsTime >= oneSecondInANanoSecond) {
                    lastFpsTime = 0
                }

                // The new delta value is emitted to the `mutableDelta` MutableStateFlow.
                mutableDelta.emit(delta)
                // `gameTime` is calculated as the time remaining to wait before updating the game state again.
                gameTime = (lastLoopTime - System.nanoTime() + optimalTime) / oneSecondInANanoSecond
                // The value of `delta` is printed.
                println(delta)
                // The coroutine waits for the calculated `gameTime` before moving on to the next iteration.
                delay((gameTime))
            }
        }
    }
}

@Composable
fun SimulatedCompose(modifier: Modifier = Modifier, content: DrawScope.(Double) -> Unit) {
    val deltaState by remember { mutableStateOf(mutableDelta) }
    val state = deltaState.collectAsState().value
    Canvas(modifier) {
        content(state)
    }
}