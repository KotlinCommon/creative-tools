package de.cicerohellmann.core.composables.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.cicerohellmann.core.composables.atoms.AppButton
import de.cicerohellmann.core.composables.atoms.appButton
import de.cicerohellmann.core.composables.atoms.appButtonClickies
import de.cicerohellmann.core.composables.theme.BaseDimensions.Companion.buttonSize

@Preview
@Composable
fun PreviewController() {
    Controller(
        moveUp = {},
        moveDown = {},
        moveLeft = {},
        moveRight = {},
        quitGame = {}
    )
}

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
