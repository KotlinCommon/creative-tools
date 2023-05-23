package engine.navigation

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import engine.compose.BaseWrapper
import engine.moving.MovingBallSample
import engine.navigation.Destination
import engine.navigation.destinationManager

class Game : Destination() {
    override var previousDestination: Destination? = null
    override var nextDestinations: List<Destination> = listOf()

    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        BaseWrapper {
            Button(colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
            ), onClick = { destinationManager.previewsDestination() }) {
                Text("Go Back")
            }
            MovingBallSample()
        }
    }
}