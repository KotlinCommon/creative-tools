import androidx.compose.runtime.Composable
import ballControl.scenes.navigationBallControl
import scenes.NavigationRouting

object AndroidTime : Time {
    override fun now(): Long = System.nanoTime()
}

@Composable
fun MainView() {
    when(selectedProject){
        Projects.MainSample -> NavigationRouting(AndroidTime)
        Projects.BallControl -> navigationBallControl(AndroidTime)
    }
}