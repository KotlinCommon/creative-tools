package de.cicerohellmann.types

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

fun integrityDecrease(currentMass: Double, maxMass: Double) = ruleOfThree(currentMass, maxMass)

fun ruleOfThree(currentValue: Double, maxValue: Double): Double {
    val exceededValue = currentValue - maxValue
    return exceededValue / maxValue.P.value
}

suspend fun coroutineWithScope(execute: () -> Unit) {
    with(CoroutineScope(coroutineContext)) { // spawns and uses parent scope!
        launch {
            execute()
        }
    }
}
