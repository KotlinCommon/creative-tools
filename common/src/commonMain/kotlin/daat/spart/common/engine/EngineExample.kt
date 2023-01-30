package daat.spart.common.engine

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun EngineExample() {
    var position = Position(0, 0.0)
    SimulatedCompose {
        MaterialTheme {
            Surface(
            ) {
                Column {
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
                    Controller(moveUp = { position = position.copy(y = position.y - 100) },
                        moveDown = { position = position.copy(y = position.y + 100) },
                        moveLeft = { position = position.copy(x = position.x - 100) },
                        moveRight = { position = position.copy(x = position.x + 100) }) {

                    }
                }
            }
        }
    }
}