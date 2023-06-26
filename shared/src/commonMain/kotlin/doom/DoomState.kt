package doom

import Time
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import engine.platformSleep
import engine.time
import kotlinx.coroutines.Runnable
import kotlin.random.Random

data class DoomState(var offset: Float)

@Composable
fun DoomCompose(state: DoomState) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(state)
    }
}

@Composable
fun DoomCompose(_time: Time) {
    time = _time
    val state = DoomState(300f + (Random.nextFloat() * 100))

    DoomCompose(state)
    println("Drawing")
    Canvas(modifier = Modifier.fillMaxSize()) {
        var lastLoopTime = time.now()
        val propagate: Runnable = object : Runnable {
            override fun run() {
                state.offset = 300f + (Random.nextFloat() * 100)
                platformSleep(50)
                println("test")
            }
        }
        propagate.run()
    }
}

private const val oneSecondInNano = 1_000_000_000.0
private const val fps = 60.0
private const val desiredMillisPerFrame = oneSecondInNano / fps

//fun sleep(millis: Long) {
//    synchronized(getCurrentThread().sleepLock) { getCurrentThread().sleepLock.wait(millis) }
//}

fun DrawScope.drawRect(offset: DoomState) {
    val offset = 100f + (Random.nextFloat() * 100)
    Offset(x = 0f + offset, y = 0f + offset)
    drawRect(
        color = Color.Red,
        topLeft = Offset(x = 0f + offset, y = 0f + offset),
        size = Size(size.width - offset, size.height - offset),
        style = androidx.compose.ui.graphics.drawscope.Fill
    )
}