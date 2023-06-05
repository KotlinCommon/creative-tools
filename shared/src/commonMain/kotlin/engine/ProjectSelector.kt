package engine

import Time
import androidx.compose.runtime.Composable
import mainSample.scenes.NavigationRouting

val selectedProject = Projects.Nexus
enum class Projects{
    MainSample,
    Nexus
}

@Composable
fun PlaySelectedProject(time: Time){
    when(selectedProject){
        Projects.MainSample -> NavigationRouting(time)
        Projects.Nexus -> nexus.NavigationRoutingEntry()
    }
}