package engine

import Time
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
import flashLight.LightCone

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
//    SequentialAnimations()
    TheaterAnimation()

}