package daat.spart.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import daat.spart.common.engine.SimulatedCompose
import daat.spart.common.engine.compose.Controller
import daat.spart.common.engine.type.Position

@Composable
fun App() {
    val bounds = Bounds(maxX = 200.0, maxY = 200.0)
    val movingObject = ObjectWithAcceleration(bounds = bounds)
    Column {


        SimulatedCompose(
            Modifier
                .size(bounds.maxX.dp, bounds.maxY.dp)
                .background(Color.White)
        ) {


            movingObject.simulation(it)
            movingObject.render(this)


        }


        Controller(moveUp = { movingObject.move(y = -100.0) },
            moveDown = { movingObject.move(y = 100.0) },
            moveLeft = { movingObject.move(x = -100.0) },
            moveRight = { movingObject.move(x = 100.0) },
            quitGame = { movingObject.stop() }
        )


    }
}

class ObjectWithAcceleration(
    private val bounds: Bounds,
    private val radius: Float = 20F
) {
    var position = Position(10.0 + radius, 10.0 + radius)
    private var vx = 0.0
    private var vy = 0.0

    fun simulation(delta: Double) {
        //bounce on collision
        detectCollision()

        // Update position based on velocity
        position.x += vx * delta
        position.y += vy * delta
    }

    fun move(x: Double = 0.0, y: Double = 0.0) {
        vx += x / 100
        vy += y / 100
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
    val maxY: Double = 0.0,

    )