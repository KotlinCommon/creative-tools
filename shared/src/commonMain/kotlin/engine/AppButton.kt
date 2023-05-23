package engine

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.syntrofos.pro.R
import de.syntrofos.pro.R.drawable.ic_add
import de.syntrofos.pro.designsystem.atoms.AppSpacer
import de.syntrofos.pro.designsystem.atoms.wrappers.AppLazyColumn
import de.syntrofos.pro.designsystem.theme.AppTheme
import de.syntrofos.pro.designsystem.theme.gu

private val ButtonHeight = gu(6f)

@Composable
fun AppButtonText(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    colors: ButtonColor = AppButtonColor.Surface,
    textAlign: TextAlign = TextAlign.End,
    label: String
) {
    Text(
        text = label,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        color = colors.text,
        textAlign = textAlign,
        style = MaterialTheme.typography.button
    )
}

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    colors: ButtonColor = AppButtonColor.Primary,
    label: String,
    enabled: Boolean = true,
    content: @Composable () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(ButtonHeight),
        colors = ButtonDefaults.buttonColors(backgroundColor = colors.background),
        enabled = enabled,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            content.invoke()
            Text(
                text = label,
                color = colors.text,
                style = MaterialTheme.typography.button
            )
        }
    }
}

@Composable
fun AppButtonWithIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    colors: ButtonColor = AppButtonColor.Primary,
    icon: Int,
    enabled: Boolean = true,
    content: @Composable () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(ButtonHeight),
        colors = ButtonDefaults.buttonColors(backgroundColor = colors.background),
        enabled = enabled,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            content.invoke()
            AppImage(resourceId = icon)
        }
    }
}

@Composable
fun AppButtonWithIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    colors: ButtonColor = AppButtonColor.Primary,
    icon: Int,
    label: String,
    iconDescription: String? = null
) {
    AppButton(
        modifier = modifier,
        onClick = onClick,
        colors = colors,
        label = label
    ) {
        Icon(
            painter = painterResource(id = icon),
            tint = colors.icon,
            contentDescription = iconDescription
        )
        AppSpacer()
    }
}

data class ButtonColor(
    val background: Color,
    val icon: Color,
    val text: Color
)

object AppButtonColor {
    val Primary: ButtonColor
        @Composable
        @ReadOnlyComposable
        get() = ButtonColor(
            background = MaterialTheme.colors.primary,
            icon = MaterialTheme.colors.onPrimary,
            text = MaterialTheme.colors.onPrimary
        )

    val Secondary: ButtonColor
        @Composable
        @ReadOnlyComposable
        get() = ButtonColor(
            background = MaterialTheme.colors.secondary,
            icon = MaterialTheme.colors.onSecondary,
            text = MaterialTheme.colors.onSecondary
        )

    val Surface: ButtonColor
        @Composable
        @ReadOnlyComposable
        get() = ButtonColor(
            background = MaterialTheme.colors.surface,
            icon = MaterialTheme.colors.onSurface,
            text = MaterialTheme.colors.onSurface
        )
}


@Preview(heightDp = 2000)
@Composable
fun AppButtonPreview() {
    AppTheme {
        Surface(
            modifier = Modifier
                .size(400.dp)
        ) {
            AppButtonSample()
        }
    }
}

@Composable
fun AppButtonSample() {
    AppLazyColumn() {
        item {
            AppButton(
                label = stringResource(R.string.test_string)
            )
            AppSpacer()
            AppButtonWithIcon(
                icon = ic_add,
                label = stringResource(R.string.test_string)
            )
            AppSpacer()
            AppButtonWithIcon(
                icon = ic_add,
                label = stringResource(R.string.test_string),
                colors = AppButtonColor.Surface
            )
            AppSpacer()
            AppButton(
                label = stringResource(R.string.test_string),
                colors = AppButtonColor.Secondary
            )
            AppSpacer()
            AppButtonText(
                label = stringResource(R.string.test_string)
            )
            AppButtonWithIcon(icon = ic_add)
        }
    }
}