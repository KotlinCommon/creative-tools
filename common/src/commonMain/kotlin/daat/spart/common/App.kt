package daat.spart.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import daat.spart.common.engine.*
import daat.spart.common.engine.compose.Controller
import daat.spart.common.engine.type.Position
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlin.time.times

@Composable
fun App() {
    val bounds = Bounds(maxX = 400.dp.value.toDouble(), maxY = 400.dp.value.toDouble())
    val movingObject = ObjectWithAcceleration(bounds = bounds)
    Column {
        SimulatedCompose(
            Modifier
                .size(bounds.maxX.dp, bounds.maxY.dp)
                .background(Color.White)
        ) {
            movingObject.render(this)
        }

        SimulatedCompose(
            Modifier
                .size(bounds.maxX.dp, bounds.maxY.dp)
                .background(Color.White)
        ) {
            movingObject.simulation(it)
        }

        Controller(moveUp = { movingObject.move(y = -1000.0) },
            moveDown = { movingObject.move(y = 1.0) },
            moveLeft = { movingObject.move(x = -1.0) },
            moveRight = { movingObject.move(x = 1.0) },
            quitGame = { movingObject.stop() }
        )


    }
}

class ObjectWithAcceleration(
    private val bounds: Bounds,
    private val radius: Float = 20F
) {
    var position = Position(10.0 + radius, 10.0 + radius)
    private var vx = 1.0
    private var vy = 1.0

    fun simulation(delta: Double) {
        //bounce on collision
        detectCollision()

        // Update position based on velocity

        println("${System.nanoTime()} vx $vx")
        println("$delta vy $vy")
        position.x += vx * delta
        position.y += vy * delta
    }

    fun move(x: Double = 0.0, y: Double = 0.0) {
        vx += x
        vy += y
    }

    fun stop() {
        vx = 0.0
        vy = 0.0
    }

    private fun detectCollision() {
        when {
            position.x + radius >= bounds.maxX -> vx *= -1.0
            position.x + radius <= bounds.x -> vx *= -1.0
            position.y + radius >= bounds.maxY -> vy *= -1.0
            position.y + radius <= bounds.y -> vy *= -1.0
        }
    }

    fun render(content: DrawScope) {
        content.drawCircle(
            Color.Black,
            radius = radius,
            center = Offset(position.x.toFloat(), position.y.toFloat()),
            style = Stroke(width = 10F)
        )
    }
}


data class Bounds(
    val x: Double = 0.0,
    val maxX: Double = 0.0,
    val y: Double = 0.0,
    val maxY: Double = 0.0
)