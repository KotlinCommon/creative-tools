import androidx.compose.runtime.Composable
import engine.PlaySelectedProject

object AndroidTime : Time {
    override fun now(): Long = System.nanoTime()
}

@Composable
fun MainView() {
    PlaySelectedProject(AndroidTime)
}