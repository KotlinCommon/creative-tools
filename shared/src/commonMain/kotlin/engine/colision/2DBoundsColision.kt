package engine.colision

import engine.movingObject.Bounds
import engine.movingObject.Position
import kotlin.math.sqrt


fun detectCollision(position: Position, vx: Double, vy: Double, delta: Double, bounds: Bounds, radius: Float): Pair<Double, Double> {
    var newVx = vx
    var newVy = vy
    val speed = sqrt(newVx * newVx + newVy * newVy)
    val maxSpeed = radius / delta

    if (speed > maxSpeed) {
        val scale = maxSpeed / speed
        newVx *= scale
        newVy *= scale
    }

    when {
        position.x + radius > bounds.maxX -> {
            newVx *= -1.0
            position.x = bounds.maxX - radius
        }

        position.x - radius < bounds.x -> {
            newVx *= -1.0
            position.x = bounds.x + radius
        }

        position.y + radius > bounds.maxY -> {
            newVy *= -1.0
            position.y = bounds.maxY - radius
        }

        position.y - radius < bounds.y -> {
            newVy *= -1.0
            position.y = bounds.y + radius
        }
    }

    return Pair(newVx, newVy)
}