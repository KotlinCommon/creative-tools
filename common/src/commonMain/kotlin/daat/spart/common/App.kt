package daat.spart.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import daat.spart.common.engine.EngineExample
import daat.spart.common.engine.SimulatedCompose
import daat.spart.common.engine.compose.Controller
import daat.spart.common.engine.type.Position

@Composable
fun App() {
    var position = Position(0, 0.0)
    Column {
        SimulatedCompose {
            Canvas(
                Modifier
                    .fillMaxSize(0.5F)
                    .background(Color.White)
            ) {
                drawCircle(
                    Color.Black,
                    radius = 20F,
                    center = Offset(position.x.toFloat(), position.y.toFloat()),
                    style = Stroke(width = 10F)
                )
            }
        }
        Controller(moveUp = { position = position.copy(y = position.y - 100) },
            moveDown = { position = position.copy(y = position.y + 100) },
            moveLeft = { position = position.copy(x = position.x - 100) },
            moveRight = { position = position.copy(x = position.x + 100) }) {
        }
    }
}
