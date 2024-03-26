package technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent

import androidx.compose.ui.geometry.Rect

public sealed class EntityPosition {
    public object LEFT : EntityPosition()
    public object MIDDLE : EntityPosition()
    public object RIGHT : EntityPosition()

    public companion object {
        public fun determinePosition(objectRect: Rect, centerPoint: Point2D): EntityPosition {
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
