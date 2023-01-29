package de.cicerohellmann.viking.game

data class GameData(
    var posX: Int = 0,
    var posY: Double = 0.0,
    var playerOffSetX: Int = 0,
    var playerOffSetY: Double = 0.0,
    var boardProvider: BoardProvider = BoardProvider()
)