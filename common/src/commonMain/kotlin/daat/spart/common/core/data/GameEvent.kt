package de.cicerohellmann.core.data

class GameEvent(
    val matrixPosXY: Double,
    val eventId: Int,
    val eventType: GameEventType,
    val result: () -> Unit
)