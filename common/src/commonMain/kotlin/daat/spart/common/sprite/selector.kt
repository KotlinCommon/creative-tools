package de.cicerohellmann.sprite

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke

fun DrawScope.selector(
    tileSize: Float,
    posX: Int,
    posY: Int
) {
    drawRect(
        color = Color.Red,
        size = Size(tileSize, tileSize),
        topLeft = Offset(
            (tileSize * posX), (tileSize * posY)
        ),
        style = Stroke(width = 1F)
    )
}
