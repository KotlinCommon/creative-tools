package de.cicerohellmann.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import de.cicerohellmann.SettingsSingleton
import de.cicerohellmann.core.tooling.compose.AppPreviewWrapper
import de.cicerohellmann.crafting.data.AdvancedGameItem
import de.cicerohellmann.crafting.data.sample.Items.Bread
import de.cicerohellmann.crafting.data.sample.Items.Burger
import de.cicerohellmann.crafting.data.sample.Items.Lettuce
import de.cicerohellmann.crafting.data.sample.Items.Tomato
import de.cicerohellmann.detail.data.Tab


@Composable
@Preview
private fun DetailViewPreview() {
    AppPreviewWrapper {
        DetailView(height = it.heightDp, Burger, listOf(Tomato, Lettuce, Bread)) {}
    }
}

@Composable
fun DetailView(
    height: Dp,
    advancedGameItem: AdvancedGameItem,
    inventory: List<AdvancedGameItem>,
    onClick: (AdvancedGameItem) -> Unit
) {
    var tabOrder by remember { mutableStateOf(listOf(0, 1)) }
    val tabs by remember { mutableStateOf(listOf(0, 1)) }
    val t = mutableListOf(
        Tab(sortingOrder = tabOrder[0], index = tabs[0], content = {
            DetailViewLayer(
                layerName = "Inf",
                layerIndex = tabs.indexOf(0),
                layerContent = { ItemInformation(advancedGameItem) },
                onClick = {
                    tabOrder = listOf(0, 1)
                }
            )
        }),
        Tab(sortingOrder = tabOrder[1], index = tabs[1], content = {
            DetailViewLayer(
                layerName = "Inv",
                layerIndex = tabs.indexOf(1),
                layerContent = { Inventory(inventory, onClick) },
                onClick = {
                    tabOrder = listOf(1, 0)
                }
            )
        })
    )

    Box(
        modifier = Modifier
            .background(SettingsSingleton.settings().backgroundColor)
            .fillMaxWidth()
            .height(height)
    ) {
        t.sortedByDescending { it.sortingOrder }.forEach {
            it.content(this)
        }
    }
}