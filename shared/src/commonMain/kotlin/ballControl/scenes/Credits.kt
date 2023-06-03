package ballControl.scenes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import engine.navigation.Destination
import engine.navigation.DestinationManager
import kotlin.math.max

class Credits : Destination() {
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
                Text(
                    text = "HELLBONE STUDIO",
                    textAlign = TextAlign.Center
                )
                Button(colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                ), onClick = { DestinationManager.previewsDestination() }) {
                    Text("Go Back")
                }
            }
        }

    }
}