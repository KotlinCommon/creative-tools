package engine.navigation

import androidx.compose.runtime.Composable
import engine.Time

abstract class Destination {
    abstract var previousDestination: Destination?
    abstract var nextDestinations: List<Destination>

    @Composable
    abstract fun UI()
}