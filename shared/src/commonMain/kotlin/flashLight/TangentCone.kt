package flashLight

import androidx.compose.ui.graphics.Path
import kotlin.math.atan2
import kotlin.math.min
import kotlin.math.max
import kotlin.math.abs

data class Angle(val radians: Double) : Comparable<Angle> {
    override fun compareTo(other: Angle): Int {
        // Compare radians of this Angle with other Angle
        return radians.compareTo(other.radians)
    }
}


data class Rect(val left: Float, val top: Float, val right: Float, val bottom: Float) {
    fun width() = right - left
    fun height() = bottom - top

    fun contains(x: Double, y: Double): Boolean {
        return x >= left && x <= right && y >= top && y <= bottom
    }
}

sealed class ObjectPosition {
    object LEFT : ObjectPosition()
    object MIDDLE : ObjectPosition()
    object RIGHT : ObjectPosition()

    companion object {
        fun determinePosition(objectRect: Rect, centerPoint: Point2D): ObjectPosition {
            val objectIsOnCenter = objectRect.right <= centerPoint.x + objectRect.width() && objectRect.left >= centerPoint.x - objectRect.width()

            return when {
                objectIsOnCenter -> MIDDLE
                objectRect.right > centerPoint.x + objectRect.width() -> RIGHT
                else -> LEFT
            }
        }
    }
}

data class Point2D(val x: Double, val y: Double)

data class TangentCone(
    private val centerPoint: Point2D,
    private val tangent1End: Point2D,
    private val tangent2End: Point2D,
    private val objectPosition: ObjectPosition,
    private val lightConeRange: ClosedRange<Angle>
) {
    fun getPath(): Path {
        val path = Path()
        path.moveTo(centerPoint.x.toFloat(), centerPoint.y.toFloat())
        path.lineTo(tangent2End.x.toFloat(), tangent2End.y.toFloat())

        if (tangentIsPartOfLightCone(tangent1End, centerPoint)) {
            path.lineTo(tangent1End.x.toFloat(), tangent1End.y.toFloat())
        } else {
            if (objectPosition == ObjectPosition.RIGHT) {
                path.lineTo(centerPoint.x.toFloat(), 0f)
                path.lineTo(centerPoint.x.toFloat(), centerPoint.y.toFloat())
            } else {
                path.lineTo(0f, 0f)
                path.lineTo(0f, centerPoint.y.toFloat())
            }
        }
        return path
    }

    private fun tangentIsPartOfLightCone(tangentPoint: Point2D, centerPoint: Point2D): Boolean {
        val tangentAngle = calculateTangentAngle(tangentPoint, centerPoint)
        return lightConeRange.contains(tangentAngle)
    }

    private fun calculateTangentAngle(tangentPoint: Point2D, centerPoint: Point2D): Angle {
        val tangentAngleRadians = atan2(centerPoint.y - tangentPoint.y, centerPoint.x - tangentPoint.x)
        return Angle(tangentAngleRadians)
    }
}
