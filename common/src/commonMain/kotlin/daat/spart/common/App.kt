package daat.spart.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import daat.spart.common.engine.SimulatedCompose
import daat.spart.common.engine.compose.Controller
import daat.spart.common.engine.type.Position

@Composable
fun App() {
    val movingObject = ObjectWithAcceleration()
    Column {


        SimulatedCompose(
            Modifier
                .fillMaxSize(0.5F)
                .background(Color.White)
        ) {


            movingObject.simulation(it)
            movingObject.render(this)


        }


        Controller(moveUp = { movingObject.move(y = -100.0) },
            moveDown = { movingObject.move(y = 100.0) },
            moveLeft = { movingObject.move(x = -100.0) },
            moveRight = { movingObject.move(x = 100.0) }) {
        }


    }
}

fun DrawScope.extracted(position: Position) {
    drawCircle(
        Color.Black,
        radius = 20F,
        center = Offset(position.x.toFloat(), position.y.toFloat()),
        style = Stroke(width = 10F)
    )
}

class ObjectWithAcceleration {
    var position = Position(0.0, 0.0)
    private var vx = 0.0
    private var vy = 0.0
    private var ax = 0.0
    private var ay = 0.0

    fun simulation(delta: Double) {
        println("vx $vx")
        println("vy $vy")
        println("ax $ax")
        println("ay $ay")
        println("position.x ${position.x}")
        println("position.y ${position.y}")
        // Update velocity based on acceleration
        vx += ax * delta
        vy += ay * delta

        // Update position based on velocity
        position.x += vx * delta
        position.y += vy * delta
//        position = position.copy(x = vx * delta, y = vy * delta)
    }

    fun move(x: Double = 0.0, y: Double = 0.0) {
        vx+=x/10
        vy+=y/10
//        position = position.copy(x = position.x + x, y = position.y + y)
    }

    fun render(content: DrawScope) {
        content.drawCircle(
            Color.Black,
            radius = 20F,
            center = Offset(position.x.toFloat(), position.y.toFloat()),
            style = Stroke(width = 10F)
        )
    }
}