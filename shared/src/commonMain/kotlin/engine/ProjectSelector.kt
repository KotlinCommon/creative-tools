package engine

import Time
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import doom.DoomCompose
import flashLight.LightCone
import flashLight.NavigationRoutingFlashLight

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
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        drawPath(
            path =
            LightCone(
                startAngle = 53.0,
                endAngle = 127.0,
                lightSourcePosition = Offset(x = size.width / 2, y = size.height - 220),
                size
            ),
            color = Color(red = 1f, green = 1f, blue = 1f, alpha = 0.4f), style = Fill
        )

        drawPath(
            path =
            LightCone(
                startAngle = 65.0,
                endAngle = 115.0,
                lightSourcePosition = Offset(x = size.width / 2, y = size.height - 220),
                size
            ),
            color = Color(red = 1f, green = 1f, blue = 1f, alpha = 0.5f), style = Fill
        )

        drawPath(
            path =
            LightCone(
                startAngle = 77.0,
                endAngle = 103.0,
                lightSourcePosition = Offset(x = size.width / 2, y = size.height - 220),
                size
            ),
            color = Color(red = 1f, green = 1f, blue = 1f, alpha = 0.6f), style = Fill
        )
    }
}