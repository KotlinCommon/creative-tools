import engine.DestinationManager

/*
 * Copyright 2023-2023 Hell Bone Studio and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

interface Time {
    fun now(): Long
}

lateinit var destinationManager: DestinationManager
lateinit var time: Time