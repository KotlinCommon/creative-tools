package de.cicerohellmann.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import de.cicerohellmann.core.composables.atoms.*
import de.cicerohellmann.crafting.data.AdvancedGameItem

@Composable
fun ItemInformation(advancedGameItem: AdvancedGameItem) {
    LazyColumn {
        item {
            AppText(text = advancedGameItem.name)
        }
        item {
            AppSpaceDecoration(size = 2F)
            RenderPresentation(advancedGameItem.presentation, advancedGameItem.name)
        }
        item {
            AppSpaceDecoration(size = 2F)
            AppText(text = "Components:")
            advancedGameItem.parts.forEach {
                AppText(text = it.name)
            }
        }
        item {
            advancedGameItem.materials.forEach {
                Row {
                    AppText(text = "${it.key}")
                    AppSpaceDecoration(size = 2F)
                    AppText(text = "${it.value}")
                }
            }
        }
    }
}