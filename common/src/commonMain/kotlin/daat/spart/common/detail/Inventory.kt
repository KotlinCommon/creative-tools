package de.cicerohellmann.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import de.cicerohellmann.core.composables.atoms.*
import de.cicerohellmann.crafting.data.AdvancedGameItem

@Composable
fun Inventory(inventory: List<AdvancedGameItem>, onClick: (AdvancedGameItem) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(80.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(inventory.size) { index ->
                ClickableItemWithHeader(
                    item = inventory[index],
                    config = appButtonItem,
                    onClick = onClick
                )
            }
        }
    )
}