package engine.type

sealed class Presentation {
    data class Image(val imageId: Int?) : Presentation()
    data class Text(val name: String?) : Presentation()
    data class Number(val number: kotlin.Number?) : Presentation()
}

val String.Pr: Presentation.Text
    get() = Presentation.Text(this)

val Int.PrI: Presentation.Image
    get() = Presentation.Image(this)

val Int.PrN: Presentation.Number
    get() = Presentation.Number(this)