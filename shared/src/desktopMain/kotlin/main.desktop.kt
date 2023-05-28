/*
 * Copyright 2023-2023 Hell Bone Studio and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import ballControl.scenes.navigationBallControl
import scenes.NavigationRouting

object JvmTime : Time {
    override fun now(): Long = System.nanoTime()
}

@Composable
fun MainView() {
    when(selectedProject){
        Projects.BallControl -> NavigationRouting(JvmTime)
        Projects.MainSample -> navigationBallControl(JvmTime)
    }
}

@Preview
@Composable
fun GamePreview() {
    MainView()
}