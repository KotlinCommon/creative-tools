package engine

import time
import kotlin.random.Random

fun Any.idGenerator():  Double {
    val now = time.now()
    val firstPart = Random(this.hashCode() + now).nextLong().toString()
    val secondPart = (this.hashCode() + now).toString()
    return (firstPart + secondPart).toDouble()
}