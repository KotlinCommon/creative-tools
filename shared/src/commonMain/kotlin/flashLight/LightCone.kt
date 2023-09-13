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

/*
private extension Double {
    enum OutsideLightCone {
        static let startAngle: CGFloat = 53
        static let endAngle: CGFloat = 127
        static let opacity: CGFloat = 0.4
    }

    enum MiddleLightCone {
        static let startAngle: CGFloat = 65
        static let endAngle: CGFloat = 115
        static let opacity: CGFloat = 0.5
    }

    enum CenterLightCone {
        static let startAngle: CGFloat = 77
        static let endAngle: CGFloat = 103
        static let opacity: CGFloat = 0.6
    }
}*/