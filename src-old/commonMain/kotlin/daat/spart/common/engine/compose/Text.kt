package daat.spart.common.engine.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import daat.spart.common.engine.SettingsSingleton.settings

@Composable
fun AppText(text: String) {
    Text(
        text = text,
        color = settings().textColor,
        fontWeight = FontWeight.W700
    )
}