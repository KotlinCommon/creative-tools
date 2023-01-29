package de.cicerohellmann.core.data

data class Combat(
    val backToGame: () -> Unit = {},
    val continueGame: () -> Unit = {},
    val combatTitle: String = "No Test"
)