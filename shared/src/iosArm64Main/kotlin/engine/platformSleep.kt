package engine

import platform.posix.usleep

actual fun platformSleep(millis: Long) { usleep((millis * 1_000).toUInt()) }