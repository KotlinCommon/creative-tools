package engine.composeTools

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import engine.SettingsSingleton.settings
import engine.type.Size

/**
 * Provides a lambda with the size parameters
 *
 * @param content the resource contat that will make use of the `Size`
 */
@Composable
fun AppScreenDimensions(content: @Composable (Size) -> Unit) {

    content(
        Size(
//            TODO: Find equivalent of LocalConfiguration
//            height = ((LocalConfiguration.current.screenHeightDp.dp / 2) - settings().sidePaddingSize * 7).value.toInt(),
//            width = (LocalConfiguration.current.screenWidthDp.dp / 2).value.toInt()
            height = ((400.dp / 2) - settings().sidePaddingSize * 7).value.toInt(),
            width = (400.dp / 2).value.toInt()
        )
    )
}