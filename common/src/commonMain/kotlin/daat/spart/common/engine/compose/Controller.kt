package daat.spart.common.engine.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import daat.spart.common.engine.AppButton
import daat.spart.common.engine.appButton
import daat.spart.common.engine.appButtonClickies
import daat.spart.common.engine.tools.BaseDimensions.Companion.buttonSize

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
