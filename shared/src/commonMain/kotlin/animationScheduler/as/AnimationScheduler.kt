package animationScheduler.`as`

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.pointerInput
import animationScheduler.animatables.LightBeam
import animationScheduler.animatables.MinimalEntity
import animationScheduler.animatables.MovingCars
import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.Point2D
import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.TangentCone
import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.toPoint2D

@Composable
public fun GameView(boxScope: BoxWithConstraintsScope, movingObjects: List<MinimalEntity>) {
    var state by remember { mutableStateOf(0.0) }
    var rect by remember {
        mutableStateOf(
            Rect(
                offset = Offset(0f, 0f),
                size = Size(
                    boxScope.maxWidth.value,
                    boxScope.maxHeight.value,
                ),
            ),
        )
    }
    val interactiveEntities = movingObjects.filterIsInstance<MovingCars>()
    var currentlyDraggingObject by remember { mutableStateOf<MovingCars?>(null) }
    val cone = TangentCone(
        rectangle = rect,
        lightConeRange = 53f..127f,
        lightCenterPoint = Point2D(
            boxScope.constraints.maxWidth.toFloat() / 2,
            boxScope.constraints.maxHeight.toFloat(),
        ),
    )

    Column {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .pointerInput(Unit) {
                    dragThing(currentlyDraggingObject, interactiveEntities)
                },
        ) {
            movingObjects.forEach {
                it.render(this)
                if (it is MovingCars) {
                    rect = it.hitBox
                }

                if (it is LightBeam) {
                    it.setMask(cone.getPath())
                }
            }
        }
    }
    Simulation(movingObjects)
}

private suspend fun PointerInputScope.dragThing(
    currentlyDraggingObject: MovingCars?,
    interactiveEntities: List<MovingCars>,
) {
    var currentlyDraggingObject1 = currentlyDraggingObject
    detectDragGestures(
        onDragStart = { offset ->
            currentlyDraggingObject1 =
                interactiveEntities.firstOrNull { interactiveObject ->
                    interactiveObject.hitBox.contains(offset)
                }
        },
        onDrag = { _, dragAmount ->
            currentlyDraggingObject1?.let { draggingObject ->
                draggingObject.position = draggingObject.position + dragAmount.toPoint2D()
            }
        },
        onDragEnd = {
            currentlyDraggingObject1 = null
        },
    )
}
