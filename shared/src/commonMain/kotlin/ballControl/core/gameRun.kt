package ballControl.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import engine.RenderCompose
import engine.SimulateCompose
import engine.compose.Controller


@Composable
fun gameRun() {

    val ballControl: BallControl = BallControl()

    RenderCompose(
    ) {
        ballControl.render(this)
    }

    SimulateCompose {
        ballControl.update(it)
    }

    /*
    Controller(moveUp = { movingObject.move(y = -100.0) },
        moveDown = { movingObject.move(y = 1.0) },
        moveLeft = { movingObject.move(x = -1.0) },
        moveRight = { movingObject.move(x = 1.0) },
        quitGame = { movingObject.stop() }
    )
     */


}