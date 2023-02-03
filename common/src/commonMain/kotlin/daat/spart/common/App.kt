package daat.spart.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import daat.spart.common.engine.compose.Controller

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val platformName = getPlatformName()

    Column {
        Controller(
            moveUp = {},
            moveDown = {},
            moveLeft = {},
            moveRight = {},
            quitGame = {}
        )
        Button(onClick = {
            text = "Hello, $platformName"
        }) {
            Text(text)
        }
    }
}
