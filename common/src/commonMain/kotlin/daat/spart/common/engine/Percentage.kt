package daat.spart.common.engine

class Percentage(val value: Double) {
    init {
        require(value in 0.0..100.0) { "Percentage value must be between 0.0 and 100.0" }
    }

    operator fun plus(other: Percentage): Percentage {
        return Percentage(value + other.value)
    }

    operator fun minus(other: Percentage): Percentage {
        return Percentage(value - other.value)
    }

    operator fun times(other: Double): Percentage {
        return Percentage(value * other)
    }

    operator fun div(other: Double): Percentage {
        return Percentage(value / other)
    }

    override fun toString(): String {
        return "${value}%"
    }
}

val Int.P: Percentage
    get() = Percentage(this.toDouble() / 100)

val Double.P: Percentage
    get() = Percentage(this / 100)
