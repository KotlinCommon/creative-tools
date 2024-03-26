package technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent

import androidx.compose.ui.geometry.Offset

public data class Point2D(val x: Float, val y: Float) {
    public operator fun plus(other: Point2D): Point2D = Point2D(x + other.x, y + other.y)
}

public fun Point2D.toOffset(): Offset = Offset(x, y)

public fun Offset.toPoint2D(): Point2D = Point2D(x, y)
