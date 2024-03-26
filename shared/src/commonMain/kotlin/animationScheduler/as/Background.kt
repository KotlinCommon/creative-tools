package animationScheduler.`as`

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize

public fun DrawScope.background(bgImage: ImageBitmap) {
    drawImage(
        image = bgImage,
        srcOffset = IntOffset.Zero,
        srcSize = IntSize(bgImage.width, bgImage.height),
        dstOffset = IntOffset.Zero,
        dstSize = IntSize(size.width.toInt(), size.height.toInt()),
    )
}
