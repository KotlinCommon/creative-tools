package mainSample.scenes.mainMenu

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import engine.compose.BaseWrapper
import engine.navigation.Destination
import engine.navigation.DestinationManager
import mainSample.scenes.game.Game

class MainMenu :
    Destination() {

    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        BaseWrapper {
            Button(colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
            ), onClick = { DestinationManager.goTo(Game()) }) {
                Text("Go to Game")
            }
        }
    }
}