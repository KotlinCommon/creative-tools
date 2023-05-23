import androidx.compose.runtime.Composable
import engine.DestinationManager
import engine.NavigationSample

object AndroidTime : Time {
    override fun now(): Long = System.nanoTime()
}

@Composable
fun MainView() {
    time = AndroidTime
    destinationManager = DestinationManager()
    NavigationSample()
}