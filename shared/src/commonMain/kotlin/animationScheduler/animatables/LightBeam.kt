package animationScheduler.animatables

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.clipPath
import animationScheduler.`as`.AnimationConfiguration
import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.Point2D

public class LightBeam(
    public val bounds: Rect,
    position: Point2D = Point2D(bounds.width / 2, bounds.height),
    color: Color = Color.White.copy(0f),
    private val beamWidth: Float,
    animationConfigurations: MutableList<AnimationConfiguration>,
) : MinimalEntity(position, Size(0f, 0f), color, animationConfigurations) {
    private val radiusLightBeam: Float = 1300f // Radius of the light beam's radial gradient, set to 1300f for a wide spread effect.
    private val viewHeight: Float = 0f
    private var mask: Path = Path()
    public fun setMask(newmask: Path) {
        mask = newmask
    }

    override fun render(drawScope: DrawScope) {
        val lightBeamPath = Path().apply {
            moveTo(position.x, position.y)
            lineTo(position.x - beamWidth / 2, viewHeight)
            lineTo(position.x + beamWidth / 2, viewHeight)
            close()
        }

        drawScope.clipPath(mask, ClipOp.Difference) {
            // Gradient without Diffusion
            drawPath(
                path = lightBeamPath,
                brush = Brush.radialGradient(
                    0.0f to color.copy(alpha = 0f),
                    0.1f to color.copy(alpha = 0f),
                    0.1f to color,
                    center = Offset(position.x, position.y),
                    radius = bounds.height * 1.2f,
                    tileMode = TileMode.Decal,
                ),
            )

// Gradient with Diffusion
//           drawPath(
//               path = lightBeamPath,
//               brush = Brush.radialGradient(
//                   0.0f to color.copy(alpha = 0f),
//                   0.1f to color.copy(alpha = 0f),
//                   0.2f to color,
//                   center = Offset(position.x, position.y),
//                   radius = bounds.width * 2,
//                   tileMode = TileMode.Decal
//               )
//           )
        }
    }
}
