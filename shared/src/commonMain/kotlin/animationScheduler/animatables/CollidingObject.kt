package animationScheduler.animatables

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultBlendMode
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import animationScheduler.`as`.AnimationConfiguration
import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.Point2D

public open class CollidingObject(
    bounds: Rect,
    position: Point2D = Point2D(bounds.width / 2, bounds.height / 2),
    size: Size,
    color: Color = Color.Blue,
    animationConfigurations: MutableList<AnimationConfiguration> = mutableListOf(),
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

    public val realRect: Rect
        get() = Rect(
            left = position.x,
            top = position.y,
            right = position.x + size.width,
            bottom = position.y + size.height,
        )

    override fun render(drawScope: DrawScope) {
//        drawScope.drawImage(
//            image = image,
//            topLeft = Offset(getPosX(), getPosY())
//        )
        drawScope.drawRect(Color.Blue, realRect)
    }
}

public fun DrawScope.drawRect(
    color: Color,
    rect: Rect,
    alpha: Float = 1.0f,
    style: DrawStyle = Fill,
    colorFilter: ColorFilter? = null,
    blendMode: BlendMode = DefaultBlendMode,
) {
    // Extract the topLeft and size from the Rect object
    val topLeft = Offset(rect.left, rect.top)
    val size = Size(rect.width, rect.height)

    // Call the original drawRect function with these parameters
    drawRect(
        color = color,
        topLeft = topLeft,
        size = size,
        alpha = alpha,
        style = style,
        colorFilter = colorFilter,
        blendMode = blendMode,
    )
}
