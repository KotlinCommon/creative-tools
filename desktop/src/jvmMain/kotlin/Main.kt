import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import daat.spart.common.App


@ExperimentalComposeUiApi
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
