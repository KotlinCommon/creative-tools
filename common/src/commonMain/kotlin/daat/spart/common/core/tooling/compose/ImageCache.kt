package de.cicerohellmann.core.tooling.compose

import android.content.Context
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource

object ImageCache {
    lateinit var sideImage: ImageBitmap
    lateinit var cornerImage: ImageBitmap
    fun initialize(context: Context) {
        sideImage = ImageBitmap.imageResource(
            res = context.resources,
            id = de.cicerohellmann.viking.R.drawable.side2
        )
        cornerImage = ImageBitmap.imageResource(
            res = context.resources,
            id = de.cicerohellmann.viking.R.drawable.corner2
        )
    }
}
