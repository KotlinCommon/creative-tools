/*
 * Copyright 2023-2023 Hell Bone Studio and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

import androidx.compose.ui.window.Window
import engine.Time
import engine.navigation.DestinationManager
import engine.navigation.NavigationSample
import engine.navigation.destinationManager
import engine.navigation.time
import platform.AppKit.NSApp
import platform.AppKit.NSApplication

object MacosTime : Time {
    override fun now(): Long = kotlin.system.getTimeNanos()
}

fun main() {
    NSApplication.sharedApplication()
    Window("Falling Balls") {
        time = MacosTime
        destinationManager = DestinationManager()
        NavigationSample()
    }
    NSApp?.run()
}
