package daat.spart.common.engine.type

class Weight(val inGrams: Double) {

    operator fun plus(other: Percentage) = Percentage(inGrams + other.value)
    operator fun minus(other: Percentage) = Percentage(inGrams - other.value)
    operator fun times(other: Double) = Percentage(inGrams * other)
    operator fun div(other: Double) = Percentage(inGrams / other)
    override fun toString() = "${inGrams}g%"
    fun toInt() = inGrams.toInt()
}

val Int.G: Weight
    get() = Weight(this.toDouble())

val Weight.Int: Int
    get() = this.toInt()

val Int.Kg: Weight
    get() = Weight(this.toDouble() * 1000)

val Double.G: Weight
    get() = Weight(this)

val Double.Kg: Weight
    get() = Weight(this * 1000)
