package nexus.authentication.signup

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import engine.compose.BaseWrapper
import engine.navigation.Destination
import engine.navigation.DestinationManager
import nexus.home.feed.Feed

class SignUp : Destination() {
    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        BaseWrapper {
            Text("Sign Up", color = Color.White)
            Row {
                Button(
                    onClick = { DestinationManager.goTo(Feed()) }
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
}