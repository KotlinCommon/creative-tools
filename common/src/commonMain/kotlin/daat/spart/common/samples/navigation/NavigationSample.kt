package daat.spart.common.samples.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

@Composable
fun NavigationSample(){
    val destinationStack by destinationManager.destinationStack
    val currentDestination = destinationStack.last()
    when (currentDestination) {
        is MainMenu -> {
            MainMenu().UI()
        }

        is Game -> {
            Game().UI()
        }
    }
}