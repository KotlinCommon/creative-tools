package engine.navigation

import androidx.compose.runtime.Composable

@Composable
fun NavigationModule(content: @Composable (Destination) -> Unit) {
    val destinationStack = DestinationManager.destinationStack
    val currentDestination = destinationStack.value.last()
    content(currentDestination)
}