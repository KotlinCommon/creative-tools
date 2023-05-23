package engine.composeTools

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import engine.type.Size

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