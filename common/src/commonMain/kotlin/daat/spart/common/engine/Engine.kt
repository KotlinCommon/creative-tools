package daat.spart.common.engine

import androidx.compose.runtime.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(DelicateCoroutinesApi::class)
val simulation = GlobalScope.launch {
    simulation()
}

val mutableDelta = MutableStateFlow(0.0)
private suspend fun simulation(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    fps: Int = 60
) {
    var lastLoopTime = System.nanoTime()
    val TARGET_FPS = fps
    val OPTIMAL_TIME = (1000000000 / TARGET_FPS).toLong()
    var lastFpsTime: Long = 0
    var gameTime: Long
    coroutineScope {
        launch(dispatcher) {
            while (true) {
                val now = System.nanoTime()
                val updateLength = now - lastLoopTime
                if (updateLength < OPTIMAL_TIME) {
                    continue
                }
                lastLoopTime = now
                val delta = updateLength / OPTIMAL_TIME.toDouble()

                lastFpsTime += updateLength
                if (lastFpsTime >= 1000000000) {
                    lastFpsTime = 0
                }

                mutableDelta.emit(delta)
                gameTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000
                println(delta)
                delay((gameTime))
            }
        }
    }
}

@Composable
fun SimulatedCompose(content: @Composable (Double) -> Unit) {
    val test by remember { mutableStateOf(mutableDelta) }
    content(test.collectAsState().value)
}