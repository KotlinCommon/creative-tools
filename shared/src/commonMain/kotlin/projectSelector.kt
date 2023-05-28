import androidx.compose.runtime.Composable
import ballControl.scenes.navigationBallControl
import mainSample.scenes.NavigationRouting

val selectedProject = Projects.MainSample
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