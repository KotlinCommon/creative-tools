package engine

import Time
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import destinationManager
import time

@Composable
fun NavigationSample(_time: Time) {
    destinationManager =  DestinationManager()
    time = _time
    MaterialTheme {
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
}