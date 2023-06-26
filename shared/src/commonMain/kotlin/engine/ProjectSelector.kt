package engine

import Time
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import doom.DoomCompose
import flashLight.NavigationRoutingFlashLight
import kotlinx.coroutines.Runnable
import mainSample.scenes.NavigationRouting
import nexus.NavigationRoutingEntry
import kotlin.random.Random

val selectedProject = Projects.MainSample

enum class Projects {
    MainSample,
    Nexus,
    CarLights,
    PokeQuery,
    DOOM;
}

@Composable
fun PlaySelectedProject(time: Time) {
    when (selectedProject) {
        Projects.MainSample -> NavigationRouting(time)
        Projects.Nexus -> NavigationRoutingEntry()
        Projects.DOOM -> DoomCompose(time)
        Projects.PokeQuery -> DoomCompose(time)
        Projects.CarLights -> NavigationRoutingFlashLight(time)
    }
}