package nexus.authentication.signin

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import engine.compose.BaseWrapper
import engine.navigation.Destination
import engine.navigation.DestinationManager
import nexus.authentication.signup.SignUp


class SignIn : Destination() {
    @Composable
    override fun UI(
        //a state will come here most probably
    ) {
        BaseWrapper {
            Text("Sign In", color = Color.White)
            Row {
                Button(
                    onClick = { DestinationManager.clearAndGoTo(SignUp()) }
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