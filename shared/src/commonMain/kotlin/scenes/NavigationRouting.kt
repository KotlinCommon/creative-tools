package scenes

import Time
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import ballControl.scenes.MainMenu
import engine.navigation.NavigationModule
import engine.time

@Composable
fun NavigationRouting(_time: Time) {
    time = _time
    MaterialTheme {
        NavigationModule { destination ->
            when (destination) {
                is MainMenu -> {
                    MainMenu().UI()
                }


                /*
                is Game -> {
                    Game().UI()
                }
                 */
            }
        }
    }
}