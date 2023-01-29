package de.cicerohellmann.core.composables.atoms

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.cicerohellmann.core.tooling.compose.AppPreviewWrapper
import de.cicerohellmann.core.tooling.measurement.gu

@Composable
@Preview
private fun AppSpacerPreview() {
    AppPreviewWrapper {
        AppSpaceDecoration()
        AppSpaceDecoration(orientation = Orientation.Vertical)
    }
}

@Composable
fun AppSpaceDecoration(orientation: Orientation = Orientation.Horizontal) {
    val modifier = when (orientation) {
        Orientation.Vertical -> Modifier
            .fillMaxHeight(0.8f)
            .width((7.5).dp)
        Orientation.Horizontal -> Modifier
            .fillMaxWidth()
            .height((7.5).dp)
    }
    Spacer(
        modifier = modifier.addDividerDecoration(
            cornerTileSize = gu(2.5F), sideTileSize = gu(2.5F), orientation = orientation
        )
    )
}

@Composable
fun AppSpaceDecoration(size: Float, orientation: Orientation = Orientation.Vertical) {
    val modifier =
        if (orientation == Orientation.Vertical)
            Modifier.height(gu(size))
        else Modifier.width(gu(size))
    Spacer(modifier = modifier)
}

