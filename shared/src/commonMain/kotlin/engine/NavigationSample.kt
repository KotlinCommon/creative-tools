package engine

import androidx.compose.runtime.Composable

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