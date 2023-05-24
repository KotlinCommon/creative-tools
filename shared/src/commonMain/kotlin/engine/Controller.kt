package engine

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
                Button(
                    onClick = { quitGame() },
                ) {
                    Text("Quit Game")
                }
            }
            Spacer(modifier = Modifier.width(46.dp))
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Button(
                    onClick = { moveLeft() },
                ) {
                    Text("<")
                }
            }
            Column {
                Button(
                    onClick = { moveUp() },
                ) {
                    Text("^")
                }

                Spacer(modifier = Modifier.size(46.dp))
                Button(
                    onClick = { moveDown() },
                ) {
                    Text("v")
                }
            }
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Button(
                    onClick = { moveRight() },
                ) {
                    Text(">")
                }
            }
        }
    }
}
