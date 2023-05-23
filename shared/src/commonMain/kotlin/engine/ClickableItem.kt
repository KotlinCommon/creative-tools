package engine


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import engine.SettingsSingleton.settings

val appButton = ClickableConfiguration(size = Size(width = 16, height = 8), color = Color.Blue)
val appButtonClickies = ClickableConfiguration(size = Size(size = 5), color = Color.Blue)
val appButtonItem = ClickableConfiguration(size = Size(size = 10), color = Color.Blue)

@Composable
fun Clickable(config: ClickableConfiguration) {
    Box(
        Modifier
//            .addDecoration()
            .height(gu(config.size.heightF))
            .width(gu(config.size.widthF))
            .background(color = settings().buttonColor),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(),
                    enabled = true,
                    role = Role.Button,
                    onClick = config.onClick
                ),
            content = {}
        )
        config.content()
    }
}


@Composable
fun ClickableItem(
    config: ClickableConfiguration = ClickableConfiguration(),
    item: AdvancedGameItem
) {
    Clickable(
        config = ClickableConfiguration(
            size = config.size,
            color = config.color,
            onClick = config.onClick,
            content = { RenderPresentation(item.presentation, item.name) }
        )
    )
}

@Composable
fun RenderPresentation(presentation: Presentation, itemName: String) {
    with(presentation) {
        when (this) {
            is Presentation.Image -> imageId?.let {
//                Image(
                    //TODO: Fix resource path so it works with both Android, JS and Desktop
//                    painter = painterResource(presentation),
//                    contentDescription = itemName
//                )
                print(itemName)
            }

            is Presentation.Text -> name?.let {
                AppText(text = it)
            }

            is Presentation.Number -> number?.let {
                AppText(text = it.toString())
            }
        }
    }
}

data class ClickableConfiguration(
    val size: Size = Size(10),
    val color: Color = settings().surfaceColor,
    var onClick: () -> Unit = {},
    var content: @Composable () -> Unit = {}
)


@Composable
fun AppButton(
    config: ClickableConfiguration = ClickableConfiguration(),
    text: String = "",
) {
    Box(
        Modifier
//            TODO: Fix addDecoration
//            .addDecoration()
            .height(gu(config.size.heightF))
            .width(gu(config.size.widthF))
            .background(color = settings().buttonColor),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
//                .onPointerEvent(
//                    eventType = PointerEventType.Press,
//                    onEvent = {
//                        thisCoroutine {
//                            config.onClick()
//                        }
//                    })
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(),
                    enabled = true,
                    role = Role.Button,
                    onClick = {
//                        thisCoroutine{
                        config.onClick()
//                        }
                    }
                ),
            content = {}
        )
        AppText(text = text)
    }
}