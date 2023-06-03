package ballControl.scenes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ballControl.core.BallControl
import ballControl.core.gameRun
import engine.compose.BaseWrapper
import engine.navigation.Destination
import engine.navigation.DestinationManager
import mainSample.scenes.game.MovingBallSample

class Game : Destination() {
    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(0.9f).fillMaxWidth(0.7f).background(Color.DarkGray),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Game BOX
                Box(
                    modifier = Modifier.fillMaxHeight(0.9f).fillMaxWidth(0.9f).background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    gameRun()
                }
                // Menu BOX
                Box(
                    modifier = Modifier.fillMaxHeight(0.9f).fillMaxWidth(0.9f).background(Color.Blue),
                    contentAlignment = Alignment.Center
                ) {
                    Button(colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                    ), onClick = { DestinationManager.previewsDestination() }) {
                        Text("EXIT GAME")
                    }
                }
            }
        }
    }
}