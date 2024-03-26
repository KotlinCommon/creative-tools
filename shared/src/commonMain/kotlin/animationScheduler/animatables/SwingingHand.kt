package animationScheduler.animatables

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.withTransform
import animationScheduler.`as`.AnimationConfiguration
import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.Point2D
import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.toOffset

public class SwingingHand(
    private val swingRange: Float = 80f,
    private val velocity: Float = 3f,
    bounds: Rect,
    position: Point2D = Point2D(bounds.width / 2, bounds.height / 2),
    size: Size,
    color: Color = Color.White.copy(0f),
    animationConfigurations: MutableList<AnimationConfiguration> = mutableListOf(),
//    private val image: ImageBitmap,
) : MinimalEntity(position, size, color, animationConfigurations) {
    private var handOffset by mutableStateOf(0f)
    private var swingingRight by mutableStateOf(true)

    public fun updatePosition(entities: List<MinimalEntity>) {
        val entity = entities.first { it is MovingCars || it is Plaques || it is Pedestrians }
        position = entity.position
    }

    override fun simulate(
        delta: Float,
        collidables: List<CollidingObject>,
        entities: List<MinimalEntity>,
    ) {
        super.simulate(delta, collidables, entities)
        updatePosition(entities = entities)
    }

    override fun render(drawScope: DrawScope) {
        drawScope.withTransform({
            if (swingingRight) {
                handOffset += velocity
                if (handOffset > swingRange) {
                    swingingRight = false
                }
            } else {
                handOffset -= velocity
                if (handOffset < -swingRange) {
                    swingingRight = true
                }
            }
        },) {
            drawScope.drawRect(Color.Black, position.toOffset(), size = Size(40f, 40f))
//            drawScope.drawImage
//                image = image,
//                topLeft = Offset(position.x + handOffset, position.y),
//            )
        }
    }
}
