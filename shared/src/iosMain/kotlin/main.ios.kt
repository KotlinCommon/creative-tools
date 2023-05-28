/*
 * Copyright 2023-2023 Hell Bone Studio and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

import androidx.compose.ui.window.ComposeUIViewController
import ballControl.scenes.navigationBallControl
import platform.UIKit.UIViewController
import mainSample.scenes.NavigationRouting

object IosTime : Time {
    override fun now(): Long = kotlin.system.getTimeNanos()
}

fun MainViewController() : UIViewController = ComposeUIViewController {
    PlaySelectedProject(IosTime)
}

