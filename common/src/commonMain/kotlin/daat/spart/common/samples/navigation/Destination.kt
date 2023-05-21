package daat.spart.common.samples.navigation

import androidx.compose.runtime.Composable

abstract class Destination {
    abstract var previousDestination: Destination?
    abstract var nextDestinations: List<Destination>

    @Composable
    abstract fun UI()
}