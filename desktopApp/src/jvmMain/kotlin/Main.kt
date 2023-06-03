/*
 * Copyright 2023-2023 Hell Bone Studio and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import engine.movingObject.Position
import kotlinx.coroutines.delay
import java.awt.Toolkit

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {

    val screenSize = Toolkit.getDefaultToolkit().screenSize
    val state = rememberWindowState(
        placement = WindowPlacement.Floating,
        position = WindowPosition(Alignment.CenterStart),
        size = DpSize(screenSize.width.dp, screenSize.height.dp)
    )

    val gameTitle = "Ball Control"

    Window(
        onCloseRequest = ::exitApplication,
        state = state,
        resizable = false,
        alwaysOnTop = true,
        title = gameTitle
    ) {
        MainView()
    }
}

/*
 Column(modifier = Modifier.onKeyEvent {
     if (it.key == Key.A) {
         println("A is pressed")
         true
     } else {
         // let other handlers receive this event
         false
     }
 }) {
     Row(verticalAlignment = Alignment.CenterVertically) {
         Checkbox(
             state.placement == WindowPlacement.Fullscreen,
             {
                 state.placement = if (it) {
                     WindowPlacement.Fullscreen
                 } else {
                     WindowPlacement.Floating
                 }
             }
         )
         Text("isFullscreen")
     }
  */