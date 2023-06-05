package nexus.home.userDetail.protocolDetail

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import engine.compose.BaseWrapper
import engine.navigation.Destination
import engine.navigation.DestinationManager

class ProtocolDetail : Destination() {
    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        BaseWrapper {
            Text("Protocol Detail", color = Color.White)
            Button(
                onClick = { DestinationManager.previewsDestination() }
            ) {
                Text("previous")
            }
        }
    }
}