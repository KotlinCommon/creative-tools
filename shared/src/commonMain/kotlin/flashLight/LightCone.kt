package flashLight

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun LightCone(
    startAngle: Double,
    endAngle: Double,
    lightSourcePosition: Offset,
    size: Size
): Path {

    val path = Path()
    path.moveTo(lightSourcePosition.x, lightSourcePosition.y)
    val adjustedStartAngle = startAngle + 180
    val adjustedEndAngle = endAngle + 180

    val startX = lightSourcePosition.x + size.height * cos(adjustedStartAngle * PI / 180)
    val startY = lightSourcePosition.y + size.height * sin(adjustedStartAngle * PI / 180)
    path.lineTo(startX.toFloat(), startY.toFloat())

    path.lineTo(x = 0f, y = 0f)
    path.lineTo(x = size.width, y = 0f)

    val finishX = lightSourcePosition.x + size.height * cos(adjustedEndAngle * PI / 180)
    val finishY = lightSourcePosition.y + size.height * sin(adjustedEndAngle * PI / 180)

    path.lineTo(finishX.toFloat(), finishY.toFloat())
    path.lineTo(lightSourcePosition.x, lightSourcePosition.y)
    return path
}