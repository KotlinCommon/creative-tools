package engine.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object DestinationManager {
    private lateinit var destinationStack: MutableState<MutableList<Destination>>

    fun setFirstDestination(destination: Destination) {
        destinationStack = mutableStateOf(mutableListOf(destination))
    }

    fun getDestinationStack(): MutableState<MutableList<Destination>> {
        return destinationStack
    }

    fun clearStack(){
        destinationStack.value.clear()
    }

    fun nextDestination(destination: Destination) {
        addDestination(destination)
    }

    fun previewsDestination(destination: Destination? = null) {
        removeLastDestination(destination)
    }

    // Adds a new destination to the list
    private fun addDestination(destination: Destination) {
        val currentList = destinationStack.value.toMutableList()
        currentList.add(destination)
        destinationStack.value = currentList
    }

    private fun removeLastDestination(destination: Destination? = null) {
        val currentList = destinationStack.value.toMutableList()
        if (destination != null) {
            val predicate = { targetDestination: Destination -> destination == targetDestination }
            currentList.removeLastMatching(predicate)
        } else {
            currentList.removeLast()
        }
        destinationStack.value = currentList
    }

    private fun <T> MutableList<T>.removeLastMatching(predicate: (T) -> Boolean): MutableList<T> {
        val index = findLastIndex(predicate)
        if (index != -1) {
            removeAt(index)
        }
        return this
    }

    private fun <T> List<T>.findLastIndex(predicate: (T) -> Boolean): Int {
        for (index in indices.reversed()) {
            if (predicate(this[index])) {
                return index
            }
        }
        return -1
    }
}