package de.cicerohellmann.crafting

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import de.cicerohellmann.SettingsSingleton.settings
import de.cicerohellmann.core.composables.atoms.*
import de.cicerohellmann.core.tooling.compose.AppPreviewWrapper
import de.cicerohellmann.core.tooling.measurement.gu
import de.cicerohellmann.crafting.data.AdvancedGameItem
import de.cicerohellmann.crafting.data.sample.Items.Burger
import de.cicerohellmann.crafting.data.sample.Items.Hammer

@Composable
fun CraftingInterface(
    height: Dp,
    width: Dp,
    item: AdvancedGameItem,
    onItemClick: (AdvancedGameItem) -> Unit,
    onCraftClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(color = settings().backgroundColor)
            .fillMaxWidth()
            .height(height),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CraftedItemInterface(
            width = width, item = item, onItemClick = onItemClick,
            onCraftClick = onCraftClick
        )
        AppSpaceDecoration(orientation = Orientation.Vertical)
        CraftedIngredientsInterface(
            width = width,
            objectsToBeMadeOf = item.parts, onItemClick = onItemClick
        )
    }
}


@Composable
private fun CraftedIngredientsInterface(
    width: Dp,
    objectsToBeMadeOf: List<AdvancedGameItem>,
    onItemClick: (AdvancedGameItem) -> Unit
) {
    LazyColumn(
        modifier = Modifier.width(width),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(gu(4F)))
        }
        items(objectsToBeMadeOf) { item ->
            ClickableItemWithHeader(
                item = item,
                config = appButtonItem,
                onClick = onItemClick
            )
            Spacer(modifier = Modifier.height(gu()))
        }
    }
}

@Composable
private fun CraftedItemInterface(
    width: Dp,
    item: AdvancedGameItem,
    onItemClick: (AdvancedGameItem) -> Unit,
    onCraftClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = settings().backgroundColor)
            .width(width), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(gu(4F)))
        ClickableItemWithHeader(item = item, config = appButtonItem, onClick = onItemClick)
        Spacer(modifier = Modifier.weight(1F))
        AppButton(config = appButton.copy(onClick = onCraftClick), "Craft")
        Spacer(modifier = Modifier.height(gu(4F)))
    }
}

@Composable
@Preview
private fun CraftedIngredientsInterfacePreview() {
    AppPreviewWrapper {
        CraftingInterface(height = it.heightDp, width = it.widthDp, item = Burger, {}) {

        }
    }
}

@Composable
@Preview(
    heightDp = 400
)
private fun CraftedItemInterfacePreview() {
    AppPreviewWrapper {
        CraftedItemInterface(width = it.widthDp, item = Hammer, onItemClick = {}, {})
    }
}

@Composable
@Preview
private fun CraftedIngredientsInterfaceViewPreview() {
    AppPreviewWrapper {
        CraftedIngredientsInterface(
            width = it.widthDp,
            objectsToBeMadeOf = Hammer.parts,
            onItemClick = {})
    }
}
