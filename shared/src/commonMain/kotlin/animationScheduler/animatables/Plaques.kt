package animationScheduler.animatables

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import animationScheduler.animatables.MinimalEntity
import animationScheduler.`as`.AnimationConfiguration
import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.Point2D

public open class Plaques(
    bounds: Rect,
    position: Point2D = Point2D(bounds.width / 2, bounds.height / 2),
    size: Size,
    color: Color = Color.Blue,
    animationConfigurations: MutableList<AnimationConfiguration>,
    private val image: ImageBitmap,
) : MinimalEntity(position, size, color, animationConfigurations) {

    public fun getPosY(): Float = position.y - size.height / 2
    public fun getPosX(): Float = position.x - size.width / 2
    public val hitBox: Rect
        get() = Rect(
            left = getPosX(),
            top = getPosY(),
            right = position.x + size.width / 2,
            bottom = position.y + size.height / 2,
        )

    override fun render(drawScope: DrawScope) {
        drawScope.drawImage(
            image = image,
            topLeft = Offset(getPosX(), getPosY()),
        )
    }
}
