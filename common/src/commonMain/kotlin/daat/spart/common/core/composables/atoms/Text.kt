package de.cicerohellmann.core.composables.atoms

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import de.cicerohellmann.SettingsSingleton

@Composable
fun AppText(text: String) {
    Text(
        text = text,
        color = SettingsSingleton.settings().textColor,
        fontWeight = FontWeight.W700
    )
}