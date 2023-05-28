/*
 * Copyright 2023-2023 Hell Bone Studio and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

import androidx.compose.runtime.Composable
import engine.PlaySelectedProject

object JsTime : Time {
    override fun now(): Long = kotlinx.browser.window.performance.now().toLong()
}

@Composable
fun MainView() {
    PlaySelectedProject(JsTime)
}
