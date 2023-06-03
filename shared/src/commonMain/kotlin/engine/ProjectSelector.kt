package engine

import Time
import androidx.compose.runtime.Composable
import ballControl.navigationBallControl
import mainSample.scenes.NavigationRouting

val selectedProject = Projects.BallControl
enum class Projects{
    MainSample,
    BallControl
}

@Composable
fun PlaySelectedProject(time: Time){
    when(selectedProject){
        Projects.MainSample -> NavigationRouting(time)
        Projects.BallControl -> navigationBallControl(time)
    }
}