package de.cicerohellmann.core.tooling.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.cicerohellmann.crafting.data.AdvancedGameItem
import de.cicerohellmann.crafting.data.sample.Items.Hammer

@Composable
@Preview
private fun TestBoxesWithSeparatorPreview() {
    AppPreviewWrapper {
        TestBoxesWithSeparator(height = it.heightDp)
    }
}

/**
 * Provides a testing template for testing screen size and distribution, it should be used with a
 * Box {
 *  WatheverYouAreImplementing();
 *  TestBoxesWithSeparator();
 * }
 *
 * @param height will be used to set this elements max hight
 */
@Composable
private fun TestBoxesWithSeparator(height: Dp) {
    Box {
        AppScreenContainer(
            height = 500,
            mainView = {
                Box(
                    modifier = Modifier
                        .size(height = height, width = 40.dp)
                        .background(Color.Red)
                )
            },
            detailView = { height: Dp, advancedGameItem: AdvancedGameItem ->
                Box(
                    modifier = Modifier
                        .size(height = height, width = 40.dp)
                        .background(Color.Green)
                )
            }, item = Hammer
        )

        Column {
            Box(
                modifier = Modifier
                    .size(height = height, width = 40.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .size(height = height, width = 40.dp)
                    .background(Color.Green)
            )
        }
    }
}