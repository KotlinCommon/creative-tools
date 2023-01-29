package de.cicerohellmann.viking.combat

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
import androidx.compose.ui.tooling.preview.Preview
import de.cicerohellmann.core.composables.atoms.AppText
import de.cicerohellmann.core.data.Combat
import de.cicerohellmann.core.composables.theme.BaseDimensions.Companion.buttonSize
import de.cicerohellmann.core.composables.theme.VikingTheme

@Composable
fun Combat(combatContent: Combat) {
    Column(modifier = Modifier.background(Color.White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End
            ) {
                Box(
                    modifier = Modifier
                        .clip(shape = RectangleShape)
                        .background(Color.Red)
                        .fillMaxWidth()
                        .height(buttonSize)
                )
            }

            Box(
                modifier = Modifier
                    .clip(shape = RectangleShape)
                    .background(Color.Yellow)
                    .width(buttonSize)
                    .height(buttonSize)
                    .clickable {
                        println("up")
                        combatContent.backToGame()
//                        backToGame()
//                        continueGame()
                    }
            )

        }
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(shape = RectangleShape)
                    .background(Color.Yellow)
                    .size(buttonSize * 4)
                    .clickable {
                        println("up")
                        combatContent.continueGame()
//                        backToGame()
//                        continueGame()
                    }
            ) {
                AppText(text = combatContent.combatTitle)
            }

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End
            ) {
                Box(
                    modifier = Modifier
                        .clip(shape = RectangleShape)
                        .background(Color.Black)
                        .fillMaxWidth()
                        .height(buttonSize / 2),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Box(
                        modifier = Modifier
                            .clip(shape = RectangleShape)
                            .background(Color.Red)
                            .width(buttonSize)
                            .height(buttonSize / 2.8f)
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(shape = RectangleShape)
                        .background(Color.Green)
                        .width(buttonSize * 2)
                        .height(buttonSize)
                )
                Box(
                    modifier = Modifier
                        .clip(shape = RectangleShape)
                        .background(Color.Blue)
                        .width(buttonSize * 2)
                        .height(buttonSize)
                )
                Box(
                    modifier = Modifier
                        .clip(shape = RectangleShape)
                        .background(Color.Black)
                        .width(buttonSize * 2)
                        .height(buttonSize)
                )

            }

        }
    }
}


@Composable
@Preview
fun CombatPreview() {
    VikingTheme {
        Surface {
            Combat(combatContent = Combat(backToGame = {}, continueGame = {}))
        }
    }
}