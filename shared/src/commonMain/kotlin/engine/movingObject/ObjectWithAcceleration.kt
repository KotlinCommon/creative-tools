package engine.movingObject

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import engine.movement.simulateMovement
import kotlin.math.sqrt

class ObjectWithAcceleration(
    private val bounds: Bounds,
    private val radius: Float = 10F
) {
    var position = Position(10.0 + radius, 10.0 + radius)
    private var vx = 0.1
    private var vy = 0.1

    fun simulation(delta: Double) {
        //bounce on collision
        detectCollision(delta)

        // Update position based on velocity

        simulateMovement(
            position = position,
            vx = vx,
            vy = vy,
            delta = delta,
            bounds = bounds,
            radius = radius
        )
    }

    fun move(x: Double = 0.0, y: Double = 0.0) {
        vx += x
        vy += y
    }

    fun stop() {
        vx = 0.0
        vy = 0.0
    }

    private fun detectCollision(delta: Double) {
        val speed = sqrt(vx * vx + vy * vy)
        val maxSpeed = radius / delta // deltaTime is the time elapsed since the last update

        // If the speed is above the maximum, scale the velocity vector down to the maximum speed
        if (speed > maxSpeed) {
            val scale = maxSpeed / speed
            vx *= scale
            vy *= scale
        }

        // Your original collision detection code
        when {
            position.x + radius > bounds.maxX -> {
                vx *= -1.0
                position.x = bounds.maxX - radius
            }

            position.x - radius < bounds.x -> {
                vx *= -1.0
                position.x = bounds.x + radius
            }

            position.y + radius > bounds.maxY -> {
                vy *= -1.0
                position.y = bounds.maxY - radius
            }

            position.y - radius < bounds.y -> {
                vy *= -1.0
                position.y = bounds.y + radius
            }
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
