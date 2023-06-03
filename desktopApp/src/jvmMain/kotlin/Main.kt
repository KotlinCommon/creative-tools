/*
 * Copyright 2023-2023 Hell Bone Studio and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    val state = rememberWindowState(placement = WindowPlacement.Maximized)
    val gameTitle = "Ball Control"
    Window(onCloseRequest = ::exitApplication, state = state, resizable = false, title = gameTitle) {
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