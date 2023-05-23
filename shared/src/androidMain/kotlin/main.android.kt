import androidx.compose.runtime.Composable
import engine.Time
import engine.navigation.DestinationManager
import engine.navigation.NavigationSample
import engine.navigation.destinationManager
import engine.navigation.time

object AndroidTime : Time {
    override fun now(): Long = System.nanoTime()
}


@Composable
fun MainView() {
    time = AndroidTime
    destinationManager = DestinationManager()
    NavigationSample()
}