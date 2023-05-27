/*
 * Copyright 2023-2023 Hell Bone Studio and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import java.awt.Toolkit


enum class Configurations(val title: String, val windowState: WindowState) {
    Viking("Viking", WindowState(size = DpSize(800.dp, 800.dp))),
    BallControl("Ball Control", fullscreenWindowMode()),
}

fun main() = singleWindowApplication(
    title = Configurations.BallControl.title,
    state = Configurations.BallControl.windowState,
    resizable = false,
    undecorated = false
    ) {
    MainView()
}

fun fullscreenWindowMode(): WindowState {
    val screenSize = Toolkit.getDefaultToolkit().screenSize
    val screenHeight = screenSize.height.toDouble()
    val screenWidth = screenSize.width.toDouble()
    return WindowState(
        position = WindowPosition.Aligned(Alignment.Center),
        size = DpSize(screenWidth.dp, screenHeight.dp),
    )
}