package daat.spart.common.samples.navigation

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import daat.spart.common.engine.compose.BaseWrapper
import daat.spart.common.samples.moving.MovingBallSample

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