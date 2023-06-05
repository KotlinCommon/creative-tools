package nexus.home.feed

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import engine.compose.BaseWrapper
import engine.navigation.Destination
import engine.navigation.DestinationManager
import nexus.home.inviteUser.InviteUser
import nexus.home.profile.Profile
import nexus.home.userDetail.UserDetail

class Feed : Destination() {
    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        BaseWrapper {
            Text("Feed", color = Color.White)
            Row {
                Button(
                    onClick = { DestinationManager.goTo(Profile()) }
                ) {
                    Text("Profile")
                }
                Button(
                    onClick = { DestinationManager.goTo(UserDetail()) }
                ) {
                    Text("User detail")
                }
                Button(
                    onClick = { DestinationManager.goTo(InviteUser()) }
                ) {
                    Text("Invite")
                }
                Button(
                    onClick = { DestinationManager.previewsDestination() }
                ) {
                    Text("previous")
                }
            }
        }
    }
}