package de.cicerohellmann.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import de.cicerohellmann.SettingsSingleton
import de.cicerohellmann.core.composables.atoms.*
import de.cicerohellmann.core.tooling.measurement.gu

@Composable
fun DetailViewLayer(
    layerName: String,
    layerIndex: Int,
    onClick: (Int) -> Unit,
    layerContent: @Composable () -> Unit
) {
    Row {
        TabView(layerName, layerIndex, onClick)
        Row(
            modifier = Modifier
                .addDecoration()
                .fillMaxSize()
                .background(SettingsSingleton.settings().backgroundColor)
                .padding(all = gu(2F))
        ) {
            layerContent()
        }
    }
}