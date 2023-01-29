package de.cicerohellmann.core.composables.theme


import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SystemUISetup() {
    val systemUiController = rememberSystemUiController().apply {
        isNavigationBarVisible = true
        isSystemBarsVisible = false
        isStatusBarVisible = false
    }

    val systemBarColor = MaterialTheme.colors.surface.copy(alpha = 0.0f)
    val transparentColor: (Color) -> Color = { original ->
        systemBarColor.compositeOver(original)
    }
    val useDarkIcons = MaterialTheme.colors.isLight

    SideEffect {

        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = true
        )

        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = true,
            transformColorForLightContent = transparentColor
        )

        systemUiController.setNavigationBarColor(
            color = Color.Transparent,
            darkIcons = true,
            navigationBarContrastEnforced = false,
            transformColorForLightContent = transparentColor
        )

        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = useDarkIcons)
    }
}