/*
 * Copyright 2023-2023 Hell Bone Studio and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication


enum class Configurations(val title: String,val windowState : WindowState){
    Viking("Viking", WindowState(size = DpSize(800.dp, 800.dp))),
    BallControl("Ball Control", WindowState(size = DpSize(800.dp, 800.dp))),
}

fun main() = singleWindowApplication(
    title = Configurations.BallControl.title,
    state = Configurations.BallControl.windowState
) {
    MainView()
}

