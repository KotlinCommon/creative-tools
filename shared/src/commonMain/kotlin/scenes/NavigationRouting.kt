package scenes

import Time
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import engine.navigation.DestinationManager
import engine.navigation.NavigationModule
import engine.time
import scenes.game.Game
import scenes.mainMenu.MainMenu

@Composable
fun NavigationRouting(_time: Time) {
    time = _time
    DestinationManager.setFirstDestination(MainMenu())
    MaterialTheme {
        NavigationModule() { destination ->
            when (destination) {
                is MainMenu -> {
                    MainMenu().UI()
                }
                is Game -> {
                    Game().UI()
                }
            }
        }
    }
}