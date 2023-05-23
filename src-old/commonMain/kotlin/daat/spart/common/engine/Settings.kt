package daat.spart.common.engine

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import daat.spart.common.engine.tools.runBlockingTest
import kotlinx.coroutines.flow.MutableStateFlow

data class Settings(
    val backgroundColor: Color = Color(0xFF90CAF9),
    val surfaceColor: Color = Color.Blue,
    val textColor: Color = Color.Black,
    val buttonColor: Color = Color.Blue,
    val buttonTextColor: Color = Color.White,
    val sidePaddingSize: Dp = 1.dp
) {}

object SettingsSingleton {
    private val _settings = MutableStateFlow(Settings())
    fun settings() = _settings.value

    init {
        updateSettings()
    }

    private fun updateSettings(settings: Settings = Settings()) {
        runBlockingTest {
            _settings.emit(settings)
        }
    }
}