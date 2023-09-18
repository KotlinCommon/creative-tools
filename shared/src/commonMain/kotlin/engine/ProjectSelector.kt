package engine

import Time
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode.Companion.Difference
import androidx.compose.ui.graphics.BlendMode.Companion.Exclusion
import androidx.compose.ui.graphics.BlendMode.Companion.Luminosity
import androidx.compose.ui.graphics.BlendMode.Companion.Overlay
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.input.pointer.pointerInput
import doom.drawRect
import flashLight.LightCone
import flashLight.TangentCone
import flashLight.toPoint2D
import kotlinx.coroutines.delay

//import mainSample.scenes.NavigationRouting
//import nexus.NavigationRoutingEntry

val selectedProject = Projects.CarLights

enum class Projects {
    MainSample,
    Nexus,
    CarLights,
    PokeQuery,
    DOOM;
}

@Composable
fun PlaySelectedProject(time: Time) {
    var mainBeamSwitch by remember { mutableStateOf(false) }
    var middleBeamSwitch by remember { mutableStateOf(false) }
    var outerBeamSwitch by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(300)
        mainBeamSwitch = true
    }
    val mainBeam = animateFloatAsState(
        targetValue = if (mainBeamSwitch) 0.6f else 0.0f,
        finishedListener = {
            middleBeamSwitch = true
        }
    )
    val middleBeam = animateFloatAsState(
        targetValue = if (middleBeamSwitch) 0.5f else 0.0f,
        finishedListener = {
            outerBeamSwitch = true
        }
    )
    val outerBeam = animateFloatAsState(
        targetValue = if (outerBeamSwitch) 0.4f else 0.0f,
    )

    val mousePosition = remember {
        mutableStateOf(
            Offset(
                0f,
                0f
            )
        )
    } // initialize with the appropriate mouse position

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray).pointerInput(Unit) {
                detectDragGestures { change, _ ->
                    mousePosition.value = change.position
                }
            }
    ) {

        val lightSourcePosition = Offset(x = size.width / 2, y = size.height - 220)

        drawPath(
            path =
            LightCone(
                startAngle = 53.0,
                endAngle = 127.0,
                lightSourcePosition = lightSourcePosition,
                size
            ),
            color = Color(red = 1f, green = 1f, blue = 1f, alpha = outerBeam.value), style = Fill
        )

        drawPath(
            path =
            LightCone(
                startAngle = 65.0,
                endAngle = 115.0,
                lightSourcePosition = lightSourcePosition,
                size
            ),
            color = Color(red = 1f, green = 1f, blue = 1f, alpha = middleBeam.value), style = Fill
        )

        drawPath(
            path =
            LightCone(
                startAngle = 77.0,
                endAngle = 103.0,
                lightSourcePosition = lightSourcePosition,
                size
            ),
            color = Color(red = 1f, green = 1f, blue = 1f, alpha = mainBeam.value), style = Fill
        )

        val rect1 = Rect(Offset(600f, 200f), Size(150f, 350f))
        drawPath(
            path =
            TangentCone(
                rectangle = rect1,
                lightCenterPoint = lightSourcePosition.toPoint2D(),
                lightConeRange = 53f..127f
            ).getPath(),
            color = Color.Black, style = Fill

        )

        val rect = Rect(Offset(mousePosition.value.x, mousePosition.value.y), Size(150f, 350f))
        drawPath(
            path =
            TangentCone(
                rectangle = rect,
                lightCenterPoint = lightSourcePosition.toPoint2D(),
                lightConeRange = 53f..127f
            ).getPath(),
            color = Color.Black, style = Fill
        )

        // Define the masking area
        clipRect(left = 50f, top = 50f, right = 200f, bottom = 200f) {
            // Everything drawn here is restricted (or masked) to the specified rectangle
            drawCircle(
                center = Offset(size.width / 2, size.height / 2),
                radius = 150f,
                color = Color.Red
            )
        }

        drawRect(color = Color.Blue, topLeft = rect1.topLeft, size = rect1.size, alpha = 1.0f)
        drawRect(color = Color.Blue, topLeft = rect.topLeft, size = rect.size, alpha = 1.0f)
    }
}