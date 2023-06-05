package nexus.home

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import engine.navigation.Destination
import engine.navigation.DestinationManager
import engine.navigation.NavigationModule
import nexus.authentication.signin.SignIn
import nexus.home.feed.Feed
import nexus.home.inviteUser.InviteUser
import nexus.home.profile.Profile
import nexus.home.userDetail.UserDetail

@Composable
fun NavigationRoutingFeed() {
    MaterialTheme {
        NavigationModule { destination ->
            when (destination) {
                is Feed -> {
                    Feed().UI()
                }

                is InviteUser -> {
                    InviteUser().UI()
                }

                is Profile -> {
                    Profile().UI()
                }

                is UserDetail -> {
                    UserDetail().UI()
                }
            }
        }
    }
}