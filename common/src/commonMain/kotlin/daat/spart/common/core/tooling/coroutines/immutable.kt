package de.cicerohellmann.core.tooling.coroutines

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

fun <T> MutableStateFlow<T>.immutable(): StateFlow<T> = this