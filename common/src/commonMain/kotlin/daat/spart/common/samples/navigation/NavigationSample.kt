package daat.spart.common.samples.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

@Composable
fun NavigationSample() {
    NavigationModule{
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