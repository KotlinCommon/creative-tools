package de.cicerohellmann.sprite

import android.content.Context
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import de.cicerohellmann.core.composables.atoms.AppText
import de.cicerohellmann.core.composables.molecules.Controller
import de.cicerohellmann.core.composables.theme.VikingTheme
import de.cicerohellmann.engine.SimulatedCompose
import de.cicerohellmann.engine.simulation

@Composable
fun DrawSprite(context: Context) {
    val sprites = loadSprites(context)
    simulation.start()
    var index = 0
    var tileSize = 96
    fun selectedSprite() = sprites[index]
    var zoomFactor = 0.5f
    fun tileSize() = tileSize * zoomFactor
    var posX = 0
    var posY = 0
    fun image() = selectedSprite().asImageBitmap()
    val height = selectedSprite().height
    fun maxHeight() = (height / tileSize())
    val width = selectedSprite().width
    fun maxWidth() = (width / tileSize())

    SimulatedCompose {
        val srcOffset = IntOffset(
            0, 0
        ) // top-left offset of the source image
        val srcSize = IntSize(768, 1248) // dimensions of the source image
        val dstOffset = IntOffset(0, 0) // top-left offset of the destination
        fun dstSize() = IntSize(
            (srcSize.width * zoomFactor).toInt(), (srcSize.height * zoomFactor).toInt()
        )


        fun DrawScope.sprites() = drawImage(
            image = image(),
            srcOffset = srcOffset,
            srcSize = srcSize,
            dstOffset = dstOffset,
            dstSize = dstSize()
        )
        VikingTheme {
            Surface(
                modifier = Modifier
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(1f)
                ) {
                    AppText(text = posX.toString())
                    AppText(text = maxWidth().toString())
                    AppText(text = posY.toString())
                    AppText(text = maxHeight().toString())
                    Canvas(
                        Modifier
                            .fillMaxSize(0.6f)
                            .background(Color.Black)
                    ) {
                        sprites()
                        selector(tileSize.toFloat(), posX, posY)
                    }
                    Controller(
                        moveUp = {
                            posY -= 1
                        },
                        moveDown = {
                            posY += 1
                        },
                        moveLeft = { posX -= 1 },
                        moveRight = { posX += 1 },
                        quitGame = {}
                    )

                    SpriteEditingInterface(
                        tileSize = tileSize,
                        sprites = sprites,
                        index = index,
                        increaseTileSize = {
                            tileSize += it
                        },
                        decreaseTileSize = {
                            tileSize -= it
                        },
                        zoomIn = {
                            zoomFactor += it
                        },
                        zoomOut = {
                            zoomFactor -= it
                        },
                        increaseIndex = {
                            index += it
                        },
                        decreaseIndex = {
                            index -= it
                        })
                }
            }
        }
    }
}