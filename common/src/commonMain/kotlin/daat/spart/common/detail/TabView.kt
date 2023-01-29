package de.cicerohellmann.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.cicerohellmann.SettingsSingleton
import de.cicerohellmann.core.composables.atoms.*
import de.cicerohellmann.core.tooling.measurement.gu

@Composable
fun TabView(name: String, index: Int, onClick: (Int) -> Unit) {
    val tabSize = 7F
    Column {
        AppSpaceDecoration(size = (index.toFloat() + tabSize) * index, Orientation.Vertical)
        Box(
            modifier = Modifier
                .addDecoration()
                .size(gu(7F))
                .background(SettingsSingleton.settings().buttonColor)
                .clickable { onClick(index) },
            contentAlignment = Alignment.Center
        ) {
            AppText(text = name)
        }
    }
}
