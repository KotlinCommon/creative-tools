package de.cicerohellmann.viking.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import de.cicerohellmann.core.composables.theme.BaseDimensions.Companion.boardSize
import de.cicerohellmann.viking.game.BoardProvider.Companion.matrixSize
import de.cicerohellmann.core.data.Position
import de.cicerohellmann.core.composables.Board
import de.cicerohellmann.core.composables.molecules.Controller
import de.cicerohellmann.core.data.GameEvent
import de.cicerohellmann.core.composables.theme.VikingTheme

@Composable
fun Game(
    quitGame: () -> Unit,
    gameEvent: (GameEvent) -> Unit,
    game: GameData
) {
    var posY by rememberSaveable { mutableStateOf(value = game.posY) }
    var posX by rememberSaveable { mutableStateOf(value = game.posX) }
    var playerOffSetY by rememberSaveable { mutableStateOf(value = game.playerOffSetY) }
    var playerOffSetX by rememberSaveable { mutableStateOf(value = game.playerOffSetX) }

    fun updateOffSetY(y: Int) {
        game.playerOffSetY += y
        playerOffSetY = game.playerOffSetY
    }

    fun updateY(y: Int) {
        game.posY += y
        posY = game.posY
    }

    fun updateOffSetX(x: Int) {
        game.playerOffSetX += x
        playerOffSetX = game.playerOffSetX
    }

    fun updateX(x: Int) {
        game.posX += x
        posX = game.posX
    }
    Column(Modifier.background(Color.White)) {
        Board(
            Position(posX, posY),
            Position(playerOffSetX, playerOffSetY),
            game.boardProvider,
            gameEvent
        )
        Column {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Controller(moveUp = {
                    if (posY > 0 && playerOffSetY == 0.0) {
                        updateY(-1)
//                    moveY = -1
                    } else if (playerOffSetY > -1 * (boardSize / 2)) {
                        updateOffSetY(-1)
                    }
                }, moveDown = {
                    if (posY < matrixSize && playerOffSetY == 0.0) {
                        updateY(+1)
//                    moveY = 1
                    } else if (playerOffSetY < boardSize / 2) {
                        updateOffSetY(+1)
                    }
                }, moveLeft = {
                    if (posX > 0 && playerOffSetX == 0) {
                        updateX(-1)
//                    moveX = -1
                    } else if (playerOffSetX > -1 * (boardSize / 2)) updateOffSetX(-1)
                }, moveRight = {
                    if (posX < matrixSize && playerOffSetX == 0) {
                        updateX(+1)
//                    moveX = 1
                    } else if (playerOffSetX < boardSize / 2) updateOffSetX(+1)
                },
                    quitGame = {
                        quitGame()
                    }
                )
            }
        }
    }
}

@Composable
@Preview
fun GamePreview() {
    VikingTheme {
        Surface {
            Game(quitGame = {}, gameEvent = {},
                game = GameData()
            )
        }
    }
}