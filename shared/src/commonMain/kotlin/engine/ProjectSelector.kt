package engine

import Time
import androidx.compose.runtime.Composable
import mainSample.scenes.NavigationRouting

val selectedProject = Projects.MainSample
enum class Projects{
    MainSample,
}

@Composable
fun PlaySelectedProject(time: Time){
    when(selectedProject){
        Projects.MainSample -> NavigationRouting(time)
    }
}