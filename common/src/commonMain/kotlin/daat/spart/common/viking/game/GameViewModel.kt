package de.cicerohellmann.viking.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.cicerohellmann.core.tooling.coroutines.immutable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class GameViewModel : ViewModel() {
    private val _gameData = MutableStateFlow(GameData())
    val gameData = _gameData.immutable()
    fun onGameStateChanged(gameData: GameData) {
        viewModelScope.launch {
            _gameData.emit(gameData)
        }
    }
}