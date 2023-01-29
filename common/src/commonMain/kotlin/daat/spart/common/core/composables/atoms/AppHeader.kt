package de.cicerohellmann.core.composables.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import de.cicerohellmann.crafting.data.AdvancedGameItem
import de.cicerohellmann.crafting.data.sample.Items.Burger
import de.cicerohellmann.types.Presentation

@Preview
@Composable
fun HeaderPreview() {
    ClickableItemWithHeader(Burger, onClick = {})
}

@Composable
fun Header(text: Presentation, content: @Composable () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (text is Presentation.Text && text.name != null)
            AppText(text = text.name)
        content()
    }
}

@Composable
fun ClickableItemWithHeader(
    item: AdvancedGameItem,
    config: ClickableConfiguration = ClickableConfiguration(),
    onClick: (AdvancedGameItem) -> Unit
) {
    with(item) {
        Header(text = Presentation.Text(this.name)) {
            ClickableItem(item = this, config = config.copy(onClick = { onClick(item) }))
        }
    }
}

