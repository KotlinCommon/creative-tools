package ballControl

import Time
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import ballControl.scenes.Credits
import ballControl.scenes.Game
import ballControl.scenes.GameOver
import ballControl.scenes.MainMenu
import engine.navigation.DestinationManager
import engine.navigation.NavigationModule
import engine.time

@Composable
fun navigationBallControl(_time: Time) {
    time = _time
    DestinationManager.setFirstDestination(MainMenu())
    MaterialTheme {
        NavigationModule { destination ->
            when (destination) {
                is MainMenu -> {
                    MainMenu().UI()
                }

                is Credits -> {
                    Credits().UI()
                }

                is Game -> {
                    Game().UI()
                }

                is GameOver -> {
                    GameOver().UI()
                }
            }
        }
    }
}