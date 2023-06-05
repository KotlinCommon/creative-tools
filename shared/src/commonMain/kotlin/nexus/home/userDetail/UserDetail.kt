package nexus.home.userDetail

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import engine.compose.BaseWrapper
import engine.navigation.Destination
import engine.navigation.DestinationManager
import nexus.home.feed.Feed
import nexus.home.userDetail.createProtocol.CreateProtocol
import nexus.home.userDetail.protocolDetail.ProtocolDetail

class UserDetail : Destination() {
    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        BaseWrapper {
            Text("User Detail", color = Color.White)
            Button(
                onClick = { DestinationManager.goTo(CreateProtocol()) }
            ) {
                Text("Next")
            }
            Button(
                onClick = { DestinationManager.goTo(ProtocolDetail()) }
            ) {
                Text("Next")
            }
            Button(
                onClick = { DestinationManager.previewsDestination() }
            ) {
                Text("previous")
            }
        }
    }
}