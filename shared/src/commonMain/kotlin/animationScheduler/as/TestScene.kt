package animationScheduler.`as`

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ImageBitmap
import animationScheduler.animatables.CollidingObject
import animationScheduler.animatables.LightBeam
import animationScheduler.animatables.MovingCars
import animationScheduler.animatables.Road
import animationScheduler.animatables.SwingingHand
import animationScheduler.`as`.AnimationConfiguration.Alpha
import animationScheduler.`as`.AnimationConfiguration.Translation
import technology.cariad.cat.exteriorlightpluginaudi.internal.animationScheduler.`as`.tangent.Point2D

@Composable
public fun TestScene() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val boxConstraints = this
        val rect = Rect(
            offset = Offset(0f, 0f),
            size = Size(
                boxConstraints.constraints.maxWidth.toFloat(),
                boxConstraints.constraints.maxHeight.toFloat(),
            ),
        )
//        val handImage = getVectorDrawableAsImageBitmap(R.drawable.lux_hint_finger)
        val handImageSize: Size by lazy {
            Size(
                40f,
                40f,
            )
        }

//        val carImage = getVectorDrawableAsImageBitmap(R.drawable.image_lux_vehicle)

        val carImageSize: Size by lazy {
            Size(40f, 80f)
        }
//        val bgImage: ImageBitmap = getVectorDrawableAsImageBitmap(R.drawable.road)

        val gameObjects = listOf(
//            Road(bgImage),
            LightBeam(
                beamWidth = 700f,
                animationConfigurations = mutableListOf(
                    Alpha(
                        delay = 2.0,
                        targetAlpha = 0.8,
                        duration = 0.4,
                    ),
                ),
                bounds = rect,
            ),
            LightBeam(
                beamWidth = 1600f,
                animationConfigurations = mutableListOf(
                    Alpha(
                        delay = 2.4,
                        targetAlpha = 0.5,
                        duration = 0.4,
                    ),
                ),
                bounds = rect,
            ),
            LightBeam(
                beamWidth = 2500f,
                animationConfigurations = mutableListOf(
                    Alpha(
                        delay = 2.8,
                        targetAlpha = 0.3,
                        duration = 0.4,
                    ),
                ),
                bounds = rect,
            ),
            MovingCars(
                animationConfigurations = mutableListOf(
                    Translation(
                        duration = 4.0,
                        delay = 4.0,
                        target = Point2D(400f, 600f),
                        targetX = 400f,
                        targetY = 600f,
                    ),
                ),
                position = Point2D(400f, -200f),
                bounds = rect,
//                image = carImage,
                size = carImageSize,
            ),
            // Collision bounds
            CollidingObject(
                position = Point2D(
                    boxConstraints.constraints.maxWidth.toFloat() / 2 - 250f / 2,
                    boxConstraints.constraints.maxHeight.toFloat() - 600f,
                ),
                bounds = rect,
                size = Size(
                    width = 250f,
                    height = 600f,
                ),
            ),
            CollidingObject(
                position = Point2D(
                    0f,
                    boxConstraints.constraints.maxHeight.toFloat() - 300f,
                ),
                bounds = rect,
                size = Size(
                    width = boxConstraints.constraints.maxWidth.toFloat(),
                    height = 300f,
                ),
            ),
            CollidingObject(
                position = Point2D(
                    -1f,
                    0f,
                ),
                bounds = rect,
                size = Size(
                    width = 1f,
                    height = boxConstraints.constraints.maxHeight.toFloat(),
                ),
            ),
            CollidingObject(
                position = Point2D(
                    boxConstraints.constraints.maxWidth.toFloat(),
                    0f,
                ),
                bounds = rect,
                size = Size(
                    width = 1f,
                    height = boxConstraints.constraints.maxHeight.toFloat(),
                ),
            ),
            // Collision bounds
            SwingingHand(
                bounds = rect,
//                image = handImage,
                size = handImageSize,
            ),
        )
        val entities by remember {
            mutableStateOf(gameObjects)
        }

        GameView(
            boxConstraints,
            entities,
        )
    }
}

//@Composable
//public fun getVectorDrawableAsImageBitmap(vectorResId: Int): ImageBitmap {
//    val vectorDrawable = LocalContext.current.getDrawable(vectorResId)!!
//
//    // Use the intrinsic dimensions of the VectorDrawable
//    val bitmapWidth = vectorDrawable.intrinsicWidth
//    val bitmapHeight = vectorDrawable.intrinsicHeight
//
//    // Creating a bitmap with the correct dimensions
//    val bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888)
//    val canvas = Canvas(bitmap)
//    vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
//    vectorDrawable.draw(canvas)
//
//    return bitmap.asImageBitmap()
//}
