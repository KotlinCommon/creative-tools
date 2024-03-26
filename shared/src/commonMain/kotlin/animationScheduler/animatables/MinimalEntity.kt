package animationScheduler.animatables

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import animationScheduler.`as`.AnimationConfiguration
import animationScheduler.`as`.AnimationConfiguration.Alpha
import animationScheduler.`as`.AnimationConfiguration.Translation
import animationScheduler.`as`.AnimationState
import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.Point2D

public open class MinimalEntity(
    public var position: Point2D = Point2D(0f, 0f),
    public var size: Size = Size(0f, 0f),
    public var color: Color = Color.Red,
    private var animationConfigurations: MutableList<AnimationConfiguration> = mutableListOf(),
) {
    public var currentVelocity: Point2D = Point2D(0f, 0f)
    private var lastSafePosition: Point2D = position

    public open fun simulate(delta: Float, collidables: List<CollidingObject>, entities: List<MinimalEntity>) {
        simulateAnimations(delta)
        simulateCollisions(collidables)
    }

    public open fun simulateAnimations(delta: Float) {
        animationConfigurations.forEach { animationConfiguration ->
            with(animationConfiguration) {
                currentTime += delta
                if (currentTime > delay && currentTime <= currentTime + duration) {
                    state = AnimationState.Playing
                }
                if (currentTime > duration + delay + 1.0) {
                    state = AnimationState.End
                }
                if (state == AnimationState.Playing) {
                    when (animationConfiguration) {
                        is Alpha -> updateAlpha(delta, animationConfiguration)
                        is Translation -> translate(delta, animationConfiguration)
                    }
                }
                if (state == AnimationState.End) {
                    animationConfigurations.remove(animationConfiguration)
                }
            }
        }
    }

    private fun updateAlpha(delta: Float, animationConfig: Alpha) {
        return with(animationConfig) {
            val changePerSecond = (targetAlpha - color.alpha) / duration
            // Calculate the actual change based on the deltaTime
//            val actualChange = 0.25f * delta
            val actualChange = changePerSecond * delta
            // Update the currentAlpha, ensuring not to overshoot the targetAlpha
            if (targetAlpha > color.alpha) {
                color = color.copy(
                    alpha = (color.alpha + actualChange.toFloat()).coerceIn(
                        0F,
                        targetAlpha.toFloat(),
                    ),
                )
            }
            // transparency only works with increasing values
        }
    }

    private fun translate(
        delta: Float,
        animationConfig: Translation,
    ) {
        val acceleration = calculateAcceleration(
            position,
            animationConfig.target,
            animationConfig.duration,
        )

        currentVelocity = Point2D(
            currentVelocity.x + acceleration.x * delta,
            currentVelocity.y + acceleration.y * delta,
        )
        position = position.copy(
            x = position.x + currentVelocity.x * delta,
            y = position.y + currentVelocity.y * delta,
        )
    }

    private fun calculateAcceleration(start: Point2D, end: Point2D, duration: Double): Point2D {
        // Calculate the distance to cover on both axes
        val distanceX = end.x - start.x
        val distanceY = end.y - start.y

        // Calculate the required acceleration
        val accelerationX = (2 * distanceX) / (duration * duration)
        val accelerationY = (2 * distanceY) / (duration * duration)

        return Point2D(accelerationX.toFloat(), accelerationY.toFloat())
    }

    private fun checkAndHandleCollisions(collidables: List<CollidingObject>) {
        // Assuming you have a way to access all collidable objects

        val potentialHitBox = Rect(
            left = position.x - size.width / 2,
            top = position.y - size.height / 2,
            right = position.x + size.width / 2,
            bottom = position.y + size.height / 2,
        )

        val collision = collidables.any { it !== this && it.hitBox.overlaps(potentialHitBox) }

        if (collision) {
            // Collision detected, adjust position and velocity
            // Example: Stop the object
            currentVelocity = Point2D(0f, 0f)
            // Further collision response can be implemented here
        }
    }

    public open fun render(drawScope: DrawScope) {
    }

    public open fun simulateCollisions(collidables: List<CollidingObject>) {
        val potentialHitBox = Rect(
            left = position.x - size.width / 2,
            top = position.y - size.height / 2,
            right = position.x + size.width / 2,
            bottom = position.y + size.height / 2,
        )

        val collision = collidables.any { it !== this && it.realRect.overlaps(potentialHitBox) }

        if (collision) {
            println("Is colliding")
            position = lastSafePosition
        } else {
            println("Isn't colliding")
            lastSafePosition = position
        }
    }
}
