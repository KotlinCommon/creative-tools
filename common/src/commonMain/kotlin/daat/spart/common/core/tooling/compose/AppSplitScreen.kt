package de.cicerohellmann.core.tooling.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import de.cicerohellmann.SettingsSingleton.settings
import de.cicerohellmann.core.tooling.measurement.Size

/**
 * Provides a lambda with the size parameters
 *
 * @param content the resource contat that will make use of the `Size`
 */
@Composable
fun AppScreenDimensions(content: @Composable (Size) -> Unit) {
    content(
        Size(
            height = ((LocalConfiguration.current.screenHeightDp.dp / 2) - settings().sidePaddingSize * 7).value.toInt(),
            width = (LocalConfiguration.current.screenWidthDp.dp / 2).value.toInt()
        )
    )
}