import androidx.compose.runtime.Composable
import scenes.NavigationRouting

object AndroidTime : Time {
    override fun now(): Long = System.nanoTime()
}

@Composable
fun MainView() {
    NavigationRouting(AndroidTime)
}