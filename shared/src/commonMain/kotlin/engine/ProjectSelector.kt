package engine

import Time
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import flashLight.LightCone
import flashLight.TangentCone
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

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
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
    }
}