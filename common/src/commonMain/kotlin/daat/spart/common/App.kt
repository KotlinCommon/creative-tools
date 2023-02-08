package daat.spart.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import daat.spart.common.engine.SimulatedCompose
import daat.spart.common.engine.compose.Controller
import daat.spart.common.engine.type.Position

@Composable
fun App() {
    var position = Position(0, 0.0)
    Column {
        SimulatedCompose(
            Modifier
                .fillMaxSize(0.5F)
                .background(Color.White)
        ) {
            extracted(position)
        }
        Controller(moveUp = { position = position.copy(y = position.y - 100) },
            moveDown = { position = position.copy(y = position.y + 100) },
            moveLeft = { position = position.copy(x = position.x - 100) },
            moveRight = { position = position.copy(x = position.x + 100) }) {
        }
    }
}
fun DrawScope.extracted(position: Position) {
    drawCircle(
        Color.Black,
        radius = 20F,
        center = Offset(position.x.toFloat(), position.y.toFloat()),
        style = Stroke(width = 10F)
    )
}
