package engine.navigation

import androidx.compose.runtime.Composable
import engine.Time
import engine.navigation.Game
import engine.navigation.MainMenu
import engine.navigation.NavigationModule

@Composable
fun NavigationSample() {
    NavigationModule {
        when (it) {
            is MainMenu -> {
                MainMenu().UI()
            }

            is Game -> {
                Game().UI()
            }
        }
    }
}