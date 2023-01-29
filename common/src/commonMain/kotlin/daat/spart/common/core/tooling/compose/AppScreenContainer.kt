package de.cicerohellmann.core.tooling.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.cicerohellmann.SettingsSingleton.settings
import de.cicerohellmann.core.composables.atoms.AppSpaceDecoration
import de.cicerohellmann.core.composables.atoms.addDecoration
import de.cicerohellmann.core.tooling.measurement.gu
import de.cicerohellmann.crafting.data.AdvancedGameItem
import de.cicerohellmann.crafting.data.sample.Items.Hammer

@Composable
@Preview
fun AppScreenContainerPreview() {
    MaterialTheme {
        AppScreenDimensions { size ->
            AppScreenContainer(
                height = size.height,
                mainView = {
                    Column(modifier = Modifier.height(size.heightDp)) {}
                },
                detailView = { height: Dp, advancedGameItem: AdvancedGameItem ->
                    Column(modifier = Modifier.height(height)) {}
                }, item = Hammer
            )
        }
    }
}

@Composable
fun AppScreenContainer(
    height: Int,
    item: AdvancedGameItem,
    mainView: @Composable ColumnScope.(Int) -> Unit,
    detailView: @Composable ColumnScope.(Dp, AdvancedGameItem) -> Unit
) = Column(
    modifier = Modifier
        .addDecoration()
        .fillMaxSize()
        .background(settings().backgroundColor)
        .padding(all = gu(2F))
) {
    mainView(height)
    AppSpaceDecoration(size = 1F)
    AppSpaceDecoration()
    AppSpaceDecoration(size = 1F)
    detailView(p2 = height.dp, p3 = item)
}