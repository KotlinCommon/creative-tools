package flashLight

import Time
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.unit.*
import kotlin.math.roundToInt

@Composable
fun MovingBallSample() {
    val squarePosition = remember { mutableStateOf(Offset(x=50f, y=50f)) }
    val squareSize = Size(100f, 100f)
    val trianglePath = remember { mutableStateOf(Path()) }

    Box(modifier = Modifier
        .pointerInput(Unit) {
            detectDragGestures { change, dragAmount ->
                squarePosition.value += dragAmount
                change.consume()
            }
        }
        .size(300.dp)) {
        Canvas(modifier = Modifier.size(300.dp)) {
            drawRect(
                color = Color.Blue,
                topLeft = squarePosition.value,
                size = squareSize
            )
            trianglePath.value.apply {
                reset()
                moveTo(squarePosition.value.x, squarePosition.value.y + squareSize.height) // bottom left point of the square
                lineTo(squarePosition.value.x + squareSize.width, squarePosition.value.y + squareSize.height) // bottom right point of the square
                lineTo(200f, 200f) // some fixed point for the third point of the triangle
                close()
            }
            drawPath(
                color = Color.Red,
                path = trianglePath.value
            )
        }
    }

}

@Composable
fun NavigationRoutingFlashLight(_time: Time) {
    MovingBallSample()
}