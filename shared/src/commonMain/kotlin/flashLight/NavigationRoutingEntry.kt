package flashLight

import Time
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun MovingBallSample() {
    val squarePosition = remember { mutableStateOf(Offset(x = 50f, y = 50f)) }
    val squareSize = Size(100f, 100f)
    val trianglePath = remember { mutableStateOf(Path()) }
    var touchPosition by remember { mutableStateOf(Offset.Zero) }
    var dragPosition by remember { mutableStateOf(Offset.Zero) }



    Box(modifier = Modifier
        .pointerInput(Unit) {
            detectDragGestures { change, dragAmount ->
                squarePosition.value += dragAmount
                change.consume()
            }
        }
        .size(300.dp)) {
        Column {
            Text(touchPosition.toString())
            Text(dragPosition.toString())
        }
        Canvas(modifier = Modifier.size(300.dp)
            .pointerInput(Unit) {
                detectTapGestures(onPress = { offset ->
                    touchPosition = offset
                    touchInsideRectangle = rectangleArea.value.contains(offset)
                    tryAwaitRelease()
                })
            }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    dragPosition = change.position
                }
            }) {
//            drawRect(
//                color = Color.Blue,
//                topLeft = squarePosition.value,
//                size = squareSize
//            )
//            trianglePath.value.apply {
//                reset()
//                moveTo(
//                    squarePosition.value.x,
//                    squarePosition.value.y + squareSize.height
//                ) // bottom left point of the square
//                lineTo(
//                    squarePosition.value.x + squareSize.width,
//                    squarePosition.value.y + squareSize.height
//                ) // bottom right point of the square
//                lineTo(200f, 200f) // some fixed point for the third point of the triangle
//                close()
//            }
//            drawPath(
//                color = Color.Red,
//                path = trianglePath.value
//            )
        }
    }

}

@Composable
fun NavigationRoutingFlashLight(_time: Time) {
    MovingBallSample()
}