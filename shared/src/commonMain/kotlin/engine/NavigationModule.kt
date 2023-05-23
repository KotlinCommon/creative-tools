package engine

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import destinationManager

@Composable
fun NavigationModule(content: @Composable (Destination) -> Unit) {
    val destinationStack by destinationManager.destinationStack
    val currentDestination = destinationStack.last()
    content(currentDestination)
}