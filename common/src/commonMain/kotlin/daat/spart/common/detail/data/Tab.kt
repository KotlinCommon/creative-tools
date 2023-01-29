package de.cicerohellmann.detail.data

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable

data class Tab(
    val sortingOrder: Int,
    val index: Int,
    val content: @Composable (BoxScope.() -> Unit)
)