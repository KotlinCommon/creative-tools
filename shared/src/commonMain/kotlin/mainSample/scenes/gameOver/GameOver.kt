package mainSample.scenes.gameOver

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import engine.compose.BaseWrapper
import engine.navigation.Destination
import engine.navigation.DestinationManager
import engine.navigation.DestinationManager.clearStack
import mainSample.scenes.game.Game
import mainSample.scenes.mainMenu.MainMenu

class GameOver(val score: Int) : Destination() {
    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        BaseWrapper {
            Text("Your score was $score")
            Button(colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
            ), onClick = {
                clearStack()
                DestinationManager.clearAndGoTo(MainMenu())
            }) {
                Text("To menu")
            }

            Button(colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
            ), onClick = { DestinationManager.popAndGoTo(Game()) }) {
                Text("Restart")
            }
        }
    }
}