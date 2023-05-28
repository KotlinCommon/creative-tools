import androidx.compose.runtime.Composable
import ballControl.scenes.navigationBallControl
import mainSample.scenes.NavigationRouting

object AndroidTime : Time {
    override fun now(): Long = System.nanoTime()
}

@Composable
fun MainView() {
    PlaySelectedProject(AndroidTime)
}