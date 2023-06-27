package engine

import Time
import androidx.compose.runtime.Composable
import doom.DoomCompose
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
    when (selectedProject) {
//        Projects.MainSample -> NavigationRouting(time)
//        Projects.Nexus -> NavigationRoutingEntry()
        Projects.DOOM -> DoomCompose(time)
        Projects.PokeQuery -> DoomCompose(time)
        Projects.CarLights -> NavigationRoutingFlashLight(time)
        else -> {}
    }
}