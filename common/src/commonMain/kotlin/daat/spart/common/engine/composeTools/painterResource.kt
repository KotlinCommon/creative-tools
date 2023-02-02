package daat.spart.common.engine.composeTools

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import daat.spart.common.engine.type.Presentation

@Composable
expect fun painterResource(presentation: Presentation): Painter