package daat.spart.common.samples.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

@Composable
fun NavigationModule(content: @Composable (Destination) -> Unit) {
    val destinationStack by destinationManager.destinationStack
    val currentDestination = destinationStack.last()
    content(currentDestination)
}