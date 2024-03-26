package animationScheduler.`as`

import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.Point2D

public sealed class AnimationConfiguration(
    public open var duration: Double = 0.0,
    public open var delay: Double = 0.0,
    public var currentTime: Double = 0.0,
    public var state: AnimationState = AnimationState.OnHold,
) {
    public data class Translation(
        override var duration: Double,
        override var delay: Double,
        var target: Point2D,
        val targetX: Float,
        val targetY: Float,
    ) : AnimationConfiguration()

    public data class Alpha(
        override var duration: Double,
        override var delay: Double,
        var alpha: Float = 0f,
        var targetAlpha: Double = 0.0,
    ) : AnimationConfiguration()
}
