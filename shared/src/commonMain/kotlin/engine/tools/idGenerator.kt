package engine.tools

import org.jetbrains.skiko.currentNanoTime
import kotlin.random.Random

fun Any.idGenerator():  Double {
    val now = currentNanoTime()
    val firstPart = Random(this.hashCode() + now).nextLong().toString()
    val secondPart = (this.hashCode() + now).toString()
    return (firstPart + secondPart).toDouble()
}