package engine.navigation

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import engine.compose.BaseWrapper

class MainMenu : Destination() {
    override var previousDestination: Destination? = null
    override var nextDestinations: List<Destination> = listOf(Game())

    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        BaseWrapper {
            Button(colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
            ), onClick = { destinationManager.nextDestination(nextDestinations.first()) }) {
                Text("Go to Game")
            }
        }
    }
}