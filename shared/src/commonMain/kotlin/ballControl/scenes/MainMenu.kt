package ballControl.scenes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import engine.navigation.Destination
import engine.navigation.DestinationManager
import kotlin.math.max
import kotlin.math.min

class MainMenu : Destination() {
    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        val textSize = remember { mutableStateOf(30.sp) }

        val buttonsModifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.3f).padding(top = 20.dp)
            .onGloballyPositioned { layoutCoordinates ->
                val size = layoutCoordinates.size
                textSize.value = (max(size.width, size.height) / 15).sp
            }

        val spaceModifier = Spacer(modifier = Modifier.height(100.dp))

        Box(
            modifier = Modifier.fillMaxSize().background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(0.9f).fillMaxWidth(0.7f).background(Color.DarkGray),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.fillMaxHeight(0.15f).fillMaxWidth().background(Color.Transparent),
                    contentAlignment = Alignment.TopCenter
                ) {
                    // TITLE
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "BALL CONTROL",
                        fontSize = 30.sp
                    )
                }
                Column {
                    // BUTTONS
                    Button(
                        modifier = buttonsModifier,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                        ), onClick = { DestinationManager.nextDestination(Game()) }) {
                        createText("START", textSize)
                    }
                    Button(
                        modifier = buttonsModifier,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                        ), onClick = { DestinationManager.nextDestination(Credits()) }) {
                        createText("Credits", textSize)
                    }
                    //TODO: Create Exit if desktop .. For mobile nor make a sense
                    Button(
                        modifier = buttonsModifier,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Red,
                        ), onClick = { exitGame() }) {
                        createText("EXIT", textSize)
                    }
                }
            }
        }
    }
}

@Composable
fun createText(text: String, textSize: MutableState<TextUnit>) {
    Text(text, fontSize = textSize.value, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
}

fun exitGame() {
    println("Exit Game")
    //TODO: Create Exit if desktop
}