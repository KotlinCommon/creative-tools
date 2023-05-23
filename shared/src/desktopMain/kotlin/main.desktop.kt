/*
 * Copyright 2023-2023 Hell Bone Studio and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import engine.Time
import engine.navigation.DestinationManager
import engine.navigation.NavigationSample
import engine.navigation.destinationManager
import engine.navigation.time

object JvmTime : Time {
    override fun now(): Long = System.nanoTime()
}

@Composable
fun MainView() {
    time = JvmTime
    destinationManager = DestinationManager()
    NavigationSample()
}

@Preview
@Composable
fun GamePreview() {
    MainView()
}