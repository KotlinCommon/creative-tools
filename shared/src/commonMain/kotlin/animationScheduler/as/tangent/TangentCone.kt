package technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import animationScheduler.animatables.MinimalEntity
import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.EntityPosition.Companion.determinePosition
import kotlin.math.atan2

public class TangentCone(
    public val rectangle: Rect,
    public val lightCenterPoint: Point2D,
    public var lightConeRange: ClosedFloatingPointRange<Float>,
) : MinimalEntity(position = lightCenterPoint) {

    private var centerPoint: Point2D = lightCenterPoint
    private var tangent1End: Point2D
    private var tangent2End: Point2D
    private var entityPosition: EntityPosition =
        determinePosition(objectRect = rectangle, centerPoint = lightCenterPoint)

    init {

        val tangent1Point: Point2D
        val tangent2Point: Point2D

        when (entityPosition) {
            EntityPosition.LEFT -> {
                tangent1Point = Point2D(rectangle.bottomLeft.x, rectangle.bottomLeft.y)
                tangent2Point = Point2D(rectangle.topRight.x, rectangle.topRight.y)
            }

            EntityPosition.MIDDLE -> {
                tangent1Point = Point2D(rectangle.bottomLeft.x, rectangle.bottomLeft.y)
                tangent2Point = Point2D(rectangle.bottomRight.x, rectangle.bottomRight.y)
            }

            EntityPosition.RIGHT -> {
                tangent1Point = Point2D(rectangle.bottomRight.x, rectangle.bottomRight.y)
                tangent2Point = Point2D(rectangle.topLeft.x, rectangle.topLeft.y)
            }
        }

        tangent2End = calculateTangentEnd(tangentPoint = tangent2Point, centerPoint = centerPoint)
        tangent1End = calculateTangentEnd(tangentPoint = tangent1Point, centerPoint = centerPoint)
    }

    public fun getPath(): Path {
        val path = Path()
        path.moveTo(centerPoint.x, centerPoint.y)
        path.lineTo(tangent2End.x, tangent2End.y)

        if (!tangentIsPartOfLightCone(tangent1End, centerPoint)) {
            path.lineTo(tangent1End.x, tangent1End.y)
        } else {
            if (entityPosition == EntityPosition.RIGHT) {
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
        tangentEndYValue: Float = 0f,
    ): Point2D {
        val slope = (tangentPoint.y - centerPoint.y) / (tangentPoint.x - centerPoint.x)
        val tangent = slope * centerPoint.x

        val tangentEndXValue = (tangentEndYValue - (centerPoint.y - tangent)) / slope
        return Point2D(tangentEndXValue, tangentEndYValue)
    }
}
