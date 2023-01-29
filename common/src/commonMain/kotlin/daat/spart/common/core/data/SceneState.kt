package de.cicerohellmann.core.data

enum class SceneState(val scene: Int) {
    GAME_SELECTION(0),
    GAME_PLAY(1),
    SETTINGS(2),
    GAME_OVER(3),
    COMBAT(4),
    CRAFTING(5);
}