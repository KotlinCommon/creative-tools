package de.cicerohellmann.crafting

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.cicerohellmann.core.tooling.compose.AppScreenContainer
import de.cicerohellmann.core.tooling.compose.AppScreenDimensions
import de.cicerohellmann.crafting.data.AdvancedGameItem
import de.cicerohellmann.crafting.data.player
import de.cicerohellmann.crafting.data.sample.Items.Burger
import de.cicerohellmann.detail.DetailView


@Composable
@Preview(
    showSystemUi = false,
    showBackground = false,
)
private fun CraftingViewPreview() {
    MaterialTheme {
        CraftingView(
            item = Burger,
            inventory = player.dressing
        )
    }
}

@Composable
fun CraftingView(item: AdvancedGameItem, inventory: List<AdvancedGameItem>) {
    AppScreenDimensions { size ->
        var detailItem by remember { mutableStateOf(item) }
        AppScreenContainer(height = size.height, mainView = {
            CraftingInterface(size.height.dp, size.width.dp, detailItem,
                onItemClick = {
                    detailItem = it
                },
                onCraftClick = {
                })
        }, detailView = { height: Dp, advancedGameItem: AdvancedGameItem ->
            DetailView(height, advancedGameItem, inventory, onClick = {
                detailItem = it
            })
        }, item = detailItem)
    }
}
