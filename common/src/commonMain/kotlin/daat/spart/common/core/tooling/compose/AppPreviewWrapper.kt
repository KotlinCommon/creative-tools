package de.cicerohellmann.core.tooling.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import de.cicerohellmann.core.tooling.measurement.Size

@Composable
fun AppPreviewWrapper(content: @Composable (Size) -> Unit) {
    MaterialTheme {
        Surface {
            AppScreenDimensions {
                Column {
                    content(it)
                }
            }
        }
    }
}