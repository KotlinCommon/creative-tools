package engine

actual fun platformSleep(millis: Long) = Thread.sleep(millis)