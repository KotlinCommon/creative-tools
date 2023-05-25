package ballControl.scenes

import androidx.compose.runtime.Composable
import engine.navigation.NavigationModule

@Composable
fun ballControlRoute() {
        NavigationModule { destination ->
            when (destination) {
                is MainMenu -> {
                    MainMenu().UI()
                }
            }
        }
}