package engine.movement

import engine.colision.detectCollision
import engine.movingObject.Bounds
import engine.movingObject.Position

fun simulateMovement(position: Position, vx: Double, vy: Double, delta: Double, bounds: Bounds, radius: Float): Position {
    val (newVx, newVy) = detectCollision(position, vx, vy, delta, bounds, radius)
    position.x += newVx * delta
    position.y += newVy * delta
    return position
}