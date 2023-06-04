package engine.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlin.math.max

@Composable
fun ResponsiveText(text: String, modifier: Modifier, defaultTextSize: Int = 15) {
    val textSize = remember { mutableStateOf(30.sp) }

    modifier.onGloballyPositioned { layoutCoordinates ->
        val size = layoutCoordinates.size
        textSize.value = (max(size.width, size.height) / defaultTextSize).sp
    }

    Text(text, fontSize = textSize.value, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
}