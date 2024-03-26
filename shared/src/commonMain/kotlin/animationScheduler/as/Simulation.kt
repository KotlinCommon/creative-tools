package animationScheduler.`as`

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import animationScheduler.animatables.CollidingObject
import animationScheduler.animatables.MinimalEntity
import engine._time
import kotlin.math.max

private fun timeNow() = _time.now() / 1_000_000_000.0
private const val fps = 120.0
private const val secondsPerFrame = 1.0 / fps

@Composable
public fun Simulation(
    movingObjects: List<MinimalEntity>,
) {
    var lastUpdateTime = timeNow()
    var elapsedSeconds by remember { mutableStateOf(0.0) }

    LaunchedEffect(Unit) {
        while (true) {
            val currentTime = timeNow()
            val deltaTime = currentTime - lastUpdateTime
            lastUpdateTime = currentTime
            elapsedSeconds += deltaTime
            movingObjects.forEach {
                it.simulate(
                    deltaTime.toFloat(),
                    movingObjects.filterIsInstance<CollidingObject>(),
                    movingObjects,
                )
            }
            val frameTime = timeNow() - currentTime
            val waitTime = secondsPerFrame - frameTime
            delay(max((waitTime * 1_000).toLong(), 0L)) // Convert seconds to milliseconds for delay
        }
    }
    Column {
        Text(text = "Game View")
        Text(text = "Elapsed time: $elapsedSeconds seconds")
    }
}
