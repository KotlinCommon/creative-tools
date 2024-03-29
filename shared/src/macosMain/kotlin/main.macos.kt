/*
 * Copyright 2023-2023 Hell Bone Studio and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

import androidx.compose.ui.window.Window
import engine.PlaySelectedProject
import platform.AppKit.NSApp
import platform.AppKit.NSApplication

object MacosTime : Time {
    override fun now(): Long = kotlin.system.getTimeNanos()
}

fun main() {
    NSApplication.sharedApplication()
    Window("Viking") {
        PlaySelectedProject(MacosTime)
    }
    NSApp?.run()
}
