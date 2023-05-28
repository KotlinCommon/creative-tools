package engine.navigation

import androidx.compose.runtime.Composable

abstract class Destination {

    @Composable
    abstract fun UI()
}