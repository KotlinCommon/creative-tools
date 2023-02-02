package daat.spart.common.engine.tools

import androidx.compose.ui.unit.dp

class BaseDimensions  {
    companion object {
//        TODO("displayMetrics should be commented and tileSize should use from the preset values for Compose Preview")
        private const val testingWidth = 1440
        private const val testingDensity = 3.5
//        private val displayMetrics = Common.appContext.resources.displayMetrics
        internal val screenWidth = testingWidth.dp //displayMetrics.widthPixels
        internal const val boardSize = 9
        private const val tilePaddingLeftRight = 4
        val tilePaddingLeft = (tilePaddingLeftRight / 2).dp
        val tilePaddingRight = (tilePaddingLeftRight / 2).dp
        val tilePaddingTop = (tilePaddingLeftRight / 2).dp
        val tilePaddingBottom = (tilePaddingLeftRight / 2).dp
        val buttonSize = 48.dp
        val tileSize =
//            (((displayMetrics.widthPixels / displayMetrics.density) - ((boardSize + 1) * tilePaddingLeftRight)) / boardSize).dp
            (((testingWidth / testingDensity) - ((boardSize + 1) * tilePaddingLeftRight)) / boardSize)
        val canvasTile = (((testingWidth)) / boardSize)

    }
}