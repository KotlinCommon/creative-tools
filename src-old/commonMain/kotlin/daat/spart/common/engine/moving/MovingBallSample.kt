package daat.spart.common.engine.moving

import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import daat.spart.common.engine.RenderCompose
import daat.spart.common.engine.SimulateCompose
import daat.spart.common.engine.compose.Controller
import daat.spart.common.samples.moving.Bounds
import daat.spart.common.samples.moving.ObjectWithAcceleration

@Composable
fun MovingBallSample() {
    val bounds = Bounds(maxX = 400.dp.value.toDouble(), maxY = 400.dp.value.toDouble())
    val movingObject = ObjectWithAcceleration(bounds = bounds)
    Column {
        Box(modifier = Modifier.onSizeChanged {

        }){

        }
        RenderCompose(
            Modifier
                .size(bounds.maxX.dp, bounds.maxY.dp)
                .background(Color.White).hoverable()
        ) {
            movingObject.render(this)
        }

        SimulateCompose {
            movingObject.simulation(it)
        }

        Controller(moveUp = { movingObject.move(y = -100.0) },
            moveDown = { movingObject.move(y = 1.0) },
            moveLeft = { movingObject.move(x = -1.0) },
            moveRight = { movingObject.move(x = 1.0) },
            quitGame = { movingObject.stop() }
        )
    }
}