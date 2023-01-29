package de.cicerohellmann.viking.game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import de.cicerohellmann.core.data.GameEvent

@Composable
fun GameView(
    gameViewModel: GameViewModel = viewModel(),
    quitGame: () -> Unit,
    gameEvent: (GameEvent) -> Unit
) {
    val game by gameViewModel.gameData.collectAsState()
    Game(quitGame = quitGame, gameEvent = gameEvent, game)
}