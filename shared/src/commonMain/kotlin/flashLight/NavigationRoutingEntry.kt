package flashLight

import Time
import androidx.compose.runtime.Composable

@Composable
fun MovingBallSample() {
    draw(segments(2000.0, 2000.0))
}

@Composable
fun NavigationRoutingFlashLight(_time: Time) {
    MovingBallSample()
}