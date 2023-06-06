package engine

import kotlinx.browser.window

actual fun platformSleep(millis: Long) { window.setTimeout({}, millis.toInt()) }