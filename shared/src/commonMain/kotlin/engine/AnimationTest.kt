package engine

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.unit.dp
import flashLight.LightCone
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import studio.hell.bone.viking.MainRes
import studio.hell.bone.viking.images.MainResImages

@Composable
fun SequentialAnimations() {
    Column {
        var state by remember { mutableStateOf(BoxState.INITIAL) }

        LaunchedEffect(Unit) {
            state = BoxState.SMALL
        }
        // Animation specs
        val positionAnimation = animateDpAsState(
            targetValue = when (state) {
                BoxState.INITIAL -> 0.dp
                BoxState.SMALL -> 40.dp
                BoxState.LARGE -> 120.dp
                BoxState.MEDIUM -> 200.dp

            },
            animationSpec = tween(durationMillis = 1000, easing = LinearEasing),
            finishedListener = {
                // Once alpha animation is done, start size animation
                when (state) {
                    BoxState.SMALL -> state = BoxState.MEDIUM
                    BoxState.MEDIUM -> state = BoxState.LARGE
                    BoxState.LARGE -> {}
                    BoxState.INITIAL -> {}
                }
            }
        )
        Box(modifier = Modifier.size(positionAnimation.value).background(Color.Green)) {}
    }
}


enum class BoxState {
    INITIAL, SMALL, LARGE, MEDIUM
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TheaterAnimation() {
//
    var mainBeamSwitch by remember { mutableStateOf(false) }
    var middleBeamSwitch by remember { mutableStateOf(false) }
    var outerBeamSwitch by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(300)
        mainBeamSwitch = true
    }
    val mainBeam = animateFloatAsState(
        targetValue = if(mainBeamSwitch) 0.6f else 0.0f,
        finishedListener = {
            middleBeamSwitch = true
        }
    )
    val middleBeam = animateFloatAsState(
        targetValue = if(middleBeamSwitch) 0.5f else 0.0f,
        finishedListener = {
            outerBeamSwitch = true
        }
    )
    val outerBeam = animateFloatAsState(
        targetValue = if(outerBeamSwitch) 0.4f else 0.0f,
    )

    val animatedPadding = 0f

    var startingPoint1 = Pair(53.0 + animatedPadding, 127.0 + animatedPadding)
    var startingPoint2 = Pair(65.0 + animatedPadding, 115.0 + animatedPadding)
    var startingPoint3 = Pair(77.0 + animatedPadding, 103.0 + animatedPadding)

//    val imageResource = painterResource(MainRes)

//    val imageBitmap: ImageBitmap = ImageBitmap
    Box {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            drawPath(
                path =
                LightCone(
                    angle = startingPoint1,
                    lightSourcePosition = Offset(x = size.width / 2, y = size.height - 220),
                    size
                ),
                color = Color(red = 1f, green = 1f, blue = 1f, alpha = outerBeam.value), style = Fill
            )

            drawPath(
                path =
                LightCone(
                    angle = startingPoint2,
                    lightSourcePosition = Offset(x = size.width / 2, y = size.height - 220),
                    size
                ),
                color = Color(red = 1f, green = 1f, blue = 1f, alpha = middleBeam.value), style = Fill
            )

            drawPath(
                path =
                LightCone(
                    angle = startingPoint3,
                    lightSourcePosition = Offset(x = size.width / 2, y = size.height - 220),
                    size
                ),
                color = Color(red = 1f, green = 1f, blue = 1f, alpha = mainBeam.value), style = Fill
            )
            rotate(degrees = 180.0f, pivot = Offset(x = size.width / 2+25f, y = size.height - 195)){
                drawArc(Color.Black,
                    startAngle = 0.0f,
                    sweepAngle = 180.0f,
                    useCenter = true,
                    topLeft = Offset(x = size.width / 2, y = size.height - 220),
                    size = Size(100f, 100f),
                    alpha = 1.0f
                )
            }

//            drawImage(image = , topLeft =, alpha = 0.0f, style =, colorFilter = null, blendMode =)
        }
    }
}
