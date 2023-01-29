package de.cicerohellmann.sprite

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.cicerohellmann.core.composables.atoms.AppButton
import de.cicerohellmann.core.composables.atoms.AppText
import de.cicerohellmann.core.composables.atoms.appButtonItem
import de.cicerohellmann.core.tooling.measurement.S
import de.cicerohellmann.core.tooling.measurement.gu

@Composable
fun SpriteEditingInterface(
    tileSize: Int,
    sprites: List<Bitmap>,
    index: Int,
    increaseTileSize: (Int) -> Unit,
    decreaseTileSize: (Int) -> Unit,
    zoomIn: (Float) -> Unit,
    zoomOut: (Float) -> Unit,
    increaseIndex: (Int) -> Unit,
    decreaseIndex: (Int) -> Unit
) {
    Row {
        AppButton(
            appButtonItem.copy(onClick = {
                zoomIn(0.5F)
            }, size = 5.S,
                content = { AppText(text = "in") }),
            text = "in"
        )
        Spacer(modifier = Modifier.size(gu()))
        AppButton(
            appButtonItem.copy(onClick = {
                zoomOut(-0.5f)
            }, size = 5.S),
            text = "out"
        )
        Spacer(modifier = Modifier.size(gu()))
        AppButton(
            appButtonItem.copy(
                onClick = {
                    if (sprites.lastIndex > index) increaseIndex(1)
                },
                size = 5.S
            ),
            text = "next"
        )
        Spacer(modifier = Modifier.size(gu()))
        AppButton(
            appButtonItem.copy(onClick = {
                if (index > 0) decreaseIndex(-1)
            }, size = 5.S),
            text = "prev"
        )
    }
    Spacer(modifier = Modifier.size(gu()))
    Row {
        AppButton(
            appButtonItem.copy(
                onClick = {
                    increaseTileSize(1)
                },
                size = 5.S
            ),
            text = "tile++"
        )
        Spacer(modifier = Modifier.size(gu()))
        AppButton(
            appButtonItem.copy(onClick = {
                if (tileSize > 0) decreaseTileSize(-1)
            }, size = 5.S),
            text = "tile--"
        )

        Spacer(modifier = Modifier.size(gu()))
        AppButton(
            appButtonItem.copy(
                onClick = {
                    increaseTileSize(10)
                },
                size = 5.S
            ),
            text = "tile+10"
        )
        Spacer(modifier = Modifier.size(gu()))
        AppButton(
            appButtonItem.copy(onClick = {
                if (tileSize > 0) decreaseTileSize(-10)
            }, size = 5.S),
            text = "tile-10"
        )
    }
}