package daat.spart.common.engine.tools

import java.math.BigDecimal
import java.util.*

fun Any.idGenerator(): BigDecimal {
    val now = Date().time
    val firstPart = Random(this.hashCode() + now).nextLong(0, this.hashCode() + now).toString()
    val secondPart = (this.hashCode() + now).toString()
    return (firstPart + secondPart).toBigDecimal()
}