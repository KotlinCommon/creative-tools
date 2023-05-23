package engine

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import engine.BaseDimensions.Companion.buttonSize

@Composable
fun Controller(
    moveUp: () -> Unit,
    moveDown: () -> Unit,
    moveLeft: () -> Unit,
    moveRight: () -> Unit,
    quitGame: () -> Unit
) {
    Column {
        Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                AppButton(
                    config = appButton
                        .copy(onClick = { quitGame() }),
                    text = "Quit Game"
                )
            }
            Spacer(modifier = Modifier.width(buttonSize))
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                AppButton(
                    config = appButtonClickies
                        .copy(onClick = { moveLeft() }),
                    text = "<"
                )
            }
            Column {
                AppButton(
                    config = appButtonClickies
                        .copy(
                            onClick = {
                                moveUp()
                            }
                        ),
                    text = "^"
                )
                Spacer(modifier = Modifier.size(buttonSize))
                AppButton(
                    config = appButtonClickies
                        .copy(onClick = {
                            moveDown()
                        }),
                    text = "v"
                )
            }
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                AppButton(
                    config = appButtonClickies
                        .copy(onClick = { moveRight() }),
                    text = ">"
                )
            }
        }
    }
}
