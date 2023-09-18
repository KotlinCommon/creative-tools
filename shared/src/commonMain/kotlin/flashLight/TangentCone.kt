package flashLight

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import flashLight.ObjectPosition.Companion.determinePosition
import kotlin.math.atan2

data class Angle(val radians: Float) : Comparable<Angle> {
    override fun compareTo(other: Angle): Int {
        // Compare radians of this Angle with other Angle
        return radians.compareTo(other.radians)
    }
}


//data class Rect(val left: Float, val top: Float, val right: Float, val bottom: Float) {
//    fun width() = right - left
//    fun height() = bottom - top
//
//    fun contains(x: Double, y: Double): Boolean {
//        return x >= left && x <= right && y >= top && y <= bottom
//    }
//}

sealed class ObjectPosition {
    object LEFT : ObjectPosition()
    object MIDDLE : ObjectPosition()
    object RIGHT : ObjectPosition()

    companion object {
        fun determinePosition(objectRect: Rect, centerPoint: Point2D): ObjectPosition {
            val objectIsOnCenter =
                objectRect.right <= centerPoint.x + objectRect.width && objectRect.left >= centerPoint.x - objectRect.width

            return when {
                objectIsOnCenter -> MIDDLE
                objectRect.right > centerPoint.x + objectRect.width -> RIGHT
                else -> LEFT
            }
        }
    }
}

data class Point2D(val x: Float, val y: Float)

fun Point2D.toOffset() = Offset(x, y)
fun Offset.toPoint2D() = Point2D(x, y)

class TangentCone(
    val rectangle: Rect,
    val lightCenterPoint: Point2D,
    var lightConeRange: ClosedFloatingPointRange<Float>
) {

    private var centerPoint: Point2D = lightCenterPoint
    private var tangent1End: Point2D
    private var tangent2End: Point2D
    private var objectPosition: ObjectPosition =
        determinePosition(objectRect = rectangle, centerPoint = lightCenterPoint)

    init {

        val tangent1Point: Point2D
        val tangent2Point: Point2D

        when (objectPosition) {
            ObjectPosition.LEFT -> {
                tangent1Point = Point2D(rectangle.left, rectangle.right)
                tangent2Point = Point2D(rectangle.right, rectangle.top)
            }

            ObjectPosition.MIDDLE -> {
                tangent1Point = Point2D(rectangle.left, rectangle.bottom)
                tangent2Point = Point2D(rectangle.right, rectangle.bottom)
            }

            ObjectPosition.RIGHT -> {
                tangent1Point = Point2D(rectangle.right, rectangle.bottom)
                tangent2Point = Point2D(rectangle.left, rectangle.top)
            }
        }

        tangent1End = calculateTangentEnd(tangentPoint = tangent1Point, centerPoint = centerPoint)
        tangent2End = calculateTangentEnd(tangentPoint = tangent2Point, centerPoint = centerPoint)
    }

    fun getPath(): Path {
        val path = Path()
        path.moveTo(centerPoint.x, centerPoint.y)
        path.lineTo(tangent2End.x, tangent2End.y)

        if (tangentIsPartOfLightCone(tangent1End, centerPoint)) {
            path.lineTo(tangent1End.x, tangent1End.y)
        } else {
            if (objectPosition == ObjectPosition.RIGHT) {
                path.lineTo(centerPoint.x, 0f)
                path.lineTo(centerPoint.x, centerPoint.y)
            } else {
                path.lineTo(0f, 0f)
                path.lineTo(0f, centerPoint.y)
            }
        }
        return path
    }

    private fun tangentIsPartOfLightCone(tangentPoint: Point2D, centerPoint: Point2D): Boolean {
        val tangentAngle = calculateTangentAngle(tangentPoint, centerPoint)
        return lightConeRange.contains(tangentAngle)
    }

    private fun calculateTangentAngle(tangentPoint: Point2D, centerPoint: Point2D): Float {
        return atan2(centerPoint.y - tangentPoint.y, centerPoint.x - tangentPoint.x)
    }

    private fun calculateTangentEnd(
        tangentPoint: Point2D,
        centerPoint: Point2D,
        tangentEndYValue: Float = 0f
    ): Point2D {
        val slope = (tangentPoint.y - centerPoint.y) / (tangentPoint.x - centerPoint.x)
        val tangent = slope * centerPoint.x

        val tangentEndXValue = (tangentEndYValue - (centerPoint.y - tangent)) / slope
        return Point2D(tangentEndXValue, tangentEndYValue)
    }

}
