package de.cicerohellmann.core.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import de.cicerohellmann.core.composables.theme.BaseDimensions.Companion.boardSize
import de.cicerohellmann.core.composables.theme.BaseDimensions.Companion.canvasTile
import de.cicerohellmann.core.composables.theme.BaseDimensions.Companion.tileSize
import de.cicerohellmann.viking.game.BoardProvider
import de.cicerohellmann.viking.game.BoardProvider.Companion.matrixSize
import de.cicerohellmann.core.data.Position
import de.cicerohellmann.core.data.GameEvent
import de.cicerohellmann.core.data.GameEventType
import de.cicerohellmann.core.data.MatrixType
import de.cicerohellmann.core.data.MatrixType.FLOOR
import de.cicerohellmann.core.data.MatrixType.SKY
import de.cicerohellmann.core.data.TileType
import de.cicerohellmann.core.composables.theme.VikingTheme

@Composable
fun Board(
    pos: Position,
    playerOffSetPos: Position,
    boardProvider: BoardProvider,
    gameEvent: (GameEvent) -> Unit
) {
    fun getMatrixPosition(xy: Double, type: MatrixType): Int {
        return if (xy < ((if (type == FLOOR) boardProvider.floor.size else boardProvider.sky.size) - 1)
            &&
            xy >= 0
        )
            (if (type == FLOOR) boardProvider.floor[xy.toInt()] else boardProvider.sky[xy.toInt()])
        else 999
    }

    fun getTile(x: Int, y: Int, type: MatrixType): Color {
        val xy = x + pos.x + (matrixSize * (y + pos.y))
        val xySky =
            x + pos.x + pos.x + playerOffSetPos.x + boardSize / 2 + (matrixSize * (y + pos.y + pos.y + playerOffSetPos.y + boardSize / 2))
        val playerXY =
            pos.x + playerOffSetPos.x + boardSize / 2 + (matrixSize * (pos.y + playerOffSetPos.y + boardSize / 2))

        if (playerXY == xy && getMatrixPosition(xy, FLOOR) == TileType.ENEMY.type) {
            gameEvent(GameEvent(matrixPosXY = xy, eventId = 0, eventType = GameEventType.COMBAT) {
                boardProvider.floor[xy.toInt()] = TileType.GRASS.type
            })
        }
        return when (type) {
            SKY -> {
                when {
                    getMatrixPosition(
                        xySky,
                        SKY
                    ) == TileType.CLEAR.type -> Color(0x00FFFFFF)
                    getMatrixPosition(
                        xySky,
                        SKY
                    ) == TileType.CLOUD.type -> Color(0xB3FFFFFF)
                    else -> Color(0x00FFFFFF)
                }
            }
            FLOOR -> {
                when {
                    playerXY == xy -> Color.Blue
                    getMatrixPosition(xy, FLOOR) == TileType.GRASS.type -> Color.Green
                    getMatrixPosition(xy, FLOOR) == TileType.STONES.type -> Color.Gray
                    getMatrixPosition(xy, FLOOR) == TileType.ENEMY.type -> Color.Red
                    else -> Color.Black
                }
            }
        }
    }
    Box(Modifier.height((tileSize * boardSize).dp)) {
        Canvas(
            modifier = Modifier
                .zIndex(1f)
        ) {
            repeat((boardSize * boardSize)) { i ->
                val posX = i % boardSize
                val posY = i / boardSize
                println("Floor $posX $posY")
                val darPosX = posX * canvasTile
                val darPosY = posY * canvasTile
                println("posX $posX")
                println("posY $posY")
                drawRect(
                    color = getTile(posX, posY, FLOOR),
                    topLeft = Offset(
                        x = darPosX.toFloat(),
                        y = darPosY.toFloat(),
                    ),
                    size = Size(canvasTile.toFloat(), canvasTile.toFloat()),
                )
            }

        }

        Canvas(
            modifier = Modifier
                .zIndex(1f)
        ) {
            repeat((boardSize * boardSize)) { i ->
                val posX = i % boardSize
                val posY = i / boardSize
                print("Sky $posX $posY")
                val darPosX = (posX * canvasTile) - 10
                val darPosY = (posY * canvasTile) - 10
                println("posX $posX")
                println("posY $posY")
                drawRect(
                    color = getTile(posX, posY, SKY),
                    topLeft = Offset(
                        x = darPosX.toFloat(),
                        y = darPosY.toFloat(),
                    ),
                    size = Size(canvasTile.toFloat(), canvasTile.toFloat()),
                )
            }

        }
    }
}

@Composable
@Preview
fun BoardPreview() {
    VikingTheme {
        Surface {
            val playerOffSetPos = Position(0, 0.0)
            val pos = Position(0, 0.0)
            Board(pos, playerOffSetPos, BoardProvider()) { }
        }
    }
}