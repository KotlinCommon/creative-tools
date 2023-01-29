package de.cicerohellmann.viking.stateSelection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.cicerohellmann.core.composables.atoms.AppText
import de.cicerohellmann.core.composables.theme.BaseDimensions
import de.cicerohellmann.core.composables.theme.VikingTheme

@Composable
fun GameSelection(newGame: () -> Unit, continueGame: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.fillMaxWidth(0.6f),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .clip(shape = RectangleShape)
                    .background(Color.Yellow)
                    .height(BaseDimensions.buttonSize)
                    .fillMaxWidth()
                    .clickable {
                        println("up")
                        newGame()
                    }
            ){
                AppText(text = "New Game")
            }
            Spacer(Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .clip(shape = RectangleShape)
                    .background(Color.Green)
                    .fillMaxWidth()
                    .height(BaseDimensions.buttonSize)
                    .clickable {
                        println("down")
                        continueGame()
                    }
            ){
                AppText(text = "Continue")
            }
        }
    }
}

@Composable
@Preview
fun GameSelectionPreview() {
    VikingTheme {
        Surface {
            GameSelection(newGame = {}, continueGame = {})
        }
    }
}