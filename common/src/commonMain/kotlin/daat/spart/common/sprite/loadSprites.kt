package de.cicerohellmann.sprite

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

fun loadSprites(context: Context): List<Bitmap> {
    val assetManager = context.assets
    val files = assetManager.list("")
    val images = mutableListOf<Bitmap>()
    files?.forEach { fileName ->
        if (fileName.endsWith(".png")) {
            val inputStream = assetManager.open(fileName)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            images.add(bitmap)
        }
    }
    return images
}