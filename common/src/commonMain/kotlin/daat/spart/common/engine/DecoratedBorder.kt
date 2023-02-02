package daat.spart.common.engine

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.times
import daat.spart.common.engine.tools.gu

private interface CustomDrawModifier : DrawModifier {
    override fun ContentDrawScope.draw()
}

/**
 * Applies a decoration to the component it is applied to. The decoration consists of corner and side images.
 *
 * @param sideImageId the resource ID of the image to be used for the sides of the decoration
 * @param cornerImageId the resource ID of the image to be used for the corners of the decoration
 * @param cornerTileSize the size of the corner images in pixels
 * @param sideTileSize the size of the side images in pixels
 * @return the modified component
 */
@Composable
fun Modifier.addDecoration(
//    sideImageId: Int = DecorationImages.sideImageId,
//    cornerImageId: Int = DecorationImages.cornerImageId,
    sideImageId: ImageBitmap,
    cornerImageId: ImageBitmap,
    cornerTileSize: Dp = gu(2.5F),
    sideTileSize: Dp = gu(2F)
) =
    then(object : CustomDrawModifier {

        val combinationOfCorners = cornerTileSize * 2

        override fun ContentDrawScope.draw() {
            drawContent()
            val width = drawContext.size.width.toInt()
            val height = drawContext.size.height.toInt()

            fun positionOperation(position: Int) =
                cornerTileSize + position * sideTileSize

            val spaceBetweenHorizontalCorners = width - combinationOfCorners.value.toInt()
            val spaceBetweenVerticalCorners = height - combinationOfCorners.value.toInt()
            val horizontalAmount = (spaceBetweenHorizontalCorners / sideTileSize.value.toInt()) + 1
            val verticalAmount = (spaceBetweenVerticalCorners / sideTileSize.value.toInt()) + 1

            val sides = listOf(
                Pair("poop", 0),
                Pair("poop", height - sideTileSize.value.toInt()),
                Pair(0, "poop"),
                Pair(width - sideTileSize.value.toInt(), "poop"),
            )

            drawSides(
                sideImage = sideImageId,
                horizontalAmount = horizontalAmount,
                verticalAmount = verticalAmount,
                sides = sides,
                sideTileSize = sideTileSize.value.toInt(),
                positionOperation = { pos ->
                    positionOperation(pos).value.toInt()
                })

            drawCorners(
                width = width,
                cornerTileSize = cornerTileSize.value.toInt(),
                height = height,
                cornerImage = cornerImageId
            )
        }


    })

/**
 * Applies a decoration to the line component it is applied to. The decoration consists of two corners and a side image.
 *
 * @param sideImageId the resource ID of the image to be used for the sides of the decoration
 * @param cornerImageId the resource ID of the image to be used for the corners of the decoration
 * @param cornerTileSize the size of the corner images in pixels
 * @param sideTileSize the size of the side images in pixels
 * @return the modified component
 */
@Composable
fun Modifier.addDividerDecoration(
//    sideImageId: Int = DecorationImages.sideImageId,
//    cornerImageId: Int = DecorationImages.cornerImageId,
    sideImageId: ImageBitmap,
    cornerImageId: ImageBitmap,
    orientation: Orientation,
    cornerTileSize: Dp = gu(5F),
    sideTileSize: Dp = gu(2F)
) =
    then(object : CustomDrawModifier {
        val combinationOfCorners = cornerTileSize * 2

        override fun ContentDrawScope.draw() {
            drawContent()
            val width = drawContext.size.width.toInt()
            val height = drawContext.size.height.toInt()

            fun positionOperation(position: Int) =
                cornerTileSize + position * sideTileSize

            val spaceBetweenHorizontalCorners = width - combinationOfCorners.value.toInt()
            val spaceBetweenVerticalCorners = height - combinationOfCorners.value.toInt()
            val horizontalAmount = (spaceBetweenHorizontalCorners / sideTileSize.value.toInt()) + 1
            val verticalAmount = (spaceBetweenVerticalCorners / sideTileSize.value.toInt()) + 1

            val sides = listOf(
                when (orientation) {
                    Orientation.Vertical -> Pair(0, "poop")
                    Orientation.Horizontal -> Pair("poop", 0)
                }
            )

            drawSides(
                sideImage = sideImageId,
                horizontalAmount = horizontalAmount,
                verticalAmount = verticalAmount,
                sides = sides,
                sideTileSize = sideTileSize.value.toInt(),
                positionOperation = { pos ->
                    positionOperation(pos).value.toInt()
                })

            drawCorners(
                width = width,
                cornerTileSize = cornerTileSize.value.toInt(),
                height = height,
                cornerImage = cornerImageId,
                corners = listOf(
                    Pair(0, 0),
                    Pair(
                        (width - cornerTileSize.value.toInt()),
                        (height - cornerTileSize.value.toInt())
                    )
                )
            )
        }


    })

private fun ContentDrawScope.drawSides(
    sideImage: ImageBitmap,
    sideTileSize: Int,
    horizontalAmount: Int,
    verticalAmount: Int,
    sides: List<Pair<Any, Any>>,
    positionOperation: (Int) -> (Int)
) {
    sides.forEach { newPosition ->
        when (newPosition.first) {
            is String -> {
                repeat(horizontalAmount) {
                    drawImage(
                        image = sideImage,
                        sideTileSize = sideTileSize,
                        x = positionOperation(it),
                        y = newPosition.second as Int
                    )
                }
            }
            else -> {
                repeat(verticalAmount) {
                    drawImage(
                        image = sideImage,
                        sideTileSize = sideTileSize,
                        x = newPosition.first as Int,
                        y = positionOperation(it)
                    )
                }
            }
        }
    }
}

private fun ContentDrawScope.drawImage(image: ImageBitmap, sideTileSize: Int, x: Int, y: Int) {
    val drawImageLambda: ContentDrawScope.() -> Unit =
        {
            drawImage(
                image = image,
                dstOffset = IntOffset(x, y),
                dstSize = IntSize(sideTileSize, sideTileSize)
            )
        }
    drawImageLambda.invoke(this)
}

private fun ContentDrawScope.drawCorners(
    width: Int,
    cornerTileSize: Int,
    height: Int,
    cornerImage: ImageBitmap,
    corners: List<Pair<Int, Int>> = listOf(
        Pair(0, 0),
        Pair((width - cornerTileSize), 0),
        Pair(0, (height - cornerTileSize)),
        Pair((width - cornerTileSize), (height - cornerTileSize))
    )
) {

    corners.forEach {
        drawImage(
            image = cornerImage,
            dstOffset = IntOffset(it.first, it.second),
            dstSize = IntSize(cornerTileSize, cornerTileSize)
        )
    }
}