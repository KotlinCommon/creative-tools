package nexus

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import engine.navigation.Destination
import engine.navigation.DestinationManager
import engine.navigation.NavigationModule
import nexus.authentication.signin.SignIn
import nexus.authentication.signup.SignUp
import nexus.home.NavigationRoutingFeed
import nexus.home.feed.Feed

object UserSettings {
    val isSessionActive = false
}

class GetFirstDestination {
    operator fun invoke(): Destination =
        when (UserSettings.isSessionActive) {
            true -> Feed()
            false -> SignIn()
        }
}

@Composable
fun NavigationRoutingEntry() {
    Box {
        Column {
            Text("Destination not included")
            Button(
                onClick = { DestinationManager.previewsDestination() }
            ) {
                Text("previous")
            }
        }

        DestinationManager.setFirstDestination(GetFirstDestination()())
        MaterialTheme {
            NavigationModule { destination ->
                when (destination) {
                    is SignIn -> {
                        SignIn().UI()
                    }
                    is SignUp -> {
                        SignUp().UI()
                    }

                    is Feed -> {
                        NavigationRoutingFeed()
                    }
                }
            }
        }
    }
}