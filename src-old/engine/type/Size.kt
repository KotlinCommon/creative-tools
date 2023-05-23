package engine.type

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Size(
    val size: Int = 0,
    val height: Int = size,
    val heightF: Float = height.toFloat(),
    val heightDp: Dp = height.dp,
    val width: Int = size,
    val widthF: Float = width.toFloat(),
    val widthDp: Dp = width.dp
)

val Int.S get() = Size(this)