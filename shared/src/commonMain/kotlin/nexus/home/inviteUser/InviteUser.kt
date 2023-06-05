package nexus.home.inviteUser

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import engine.compose.BaseWrapper
import engine.navigation.Destination
import engine.navigation.DestinationManager

class InviteUser : Destination() {
    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        BaseWrapper {
            Text("Invite User", color = Color.White)
            Button(
                onClick = { DestinationManager.previewsDestination() }
            ) {
                Text("previous")
            }
        }
    }
}