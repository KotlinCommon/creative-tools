package de.cicerohellmann.viking.stateSelection

import androidx.compose.runtime.*
import de.cicerohellmann.viking.combat.Combat
import de.cicerohellmann.core.data.GameEventType
import de.cicerohellmann.core.data.Combat
import de.cicerohellmann.core.data.SceneState.*
import de.cicerohellmann.crafting.CraftingView
import de.cicerohellmann.crafting.data.player
import de.cicerohellmann.crafting.data.sample.Items
import de.cicerohellmann.viking.game.GameView


@Composable
fun SceneManagement() {
    var combatContent by remember { mutableStateOf(Combat()) }
    var sceneState by remember { mutableStateOf(value = GAME_SELECTION) }

    when (sceneState) {
        CRAFTING -> CraftingView(item = Items.Burger, player.dressing)
        GAME_SELECTION -> GameSelection(
            newGame = { sceneState = GAME_PLAY },
            continueGame = { sceneState = GAME_PLAY }
        )
        GAME_PLAY -> {
            GameView(
                quitGame = { sceneState = GAME_SELECTION },
                gameEvent = {
                    when (it.eventType) {
                        GameEventType.COMBAT -> {
                            combatContent = Combat(
                                backToGame = {
                                    sceneState = GAME_PLAY
                                    it.result()
                                }, continueGame = {
                                    sceneState = GAME_PLAY
                                    it.result()
                                }, combatTitle = "Test"
                            )
                            sceneState = COMBAT
                        }
                    }
                },
            )
        }
        COMBAT -> {
            Combat(combatContent)
        }
        SETTINGS -> GameView(
            quitGame = { sceneState = GAME_SELECTION },
            gameEvent = { sceneState = COMBAT }
        )
        GAME_OVER -> GameView(
            quitGame = { sceneState = GAME_SELECTION },
            gameEvent = { sceneState = GAME_OVER }
        )
    }
}

