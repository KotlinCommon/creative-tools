package de.cicerohellmann.viking.game

import de.cicerohellmann.core.data.TileType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class BoardProvider {
    val floor = MutableList(matrix) {
        when (Random.nextInt(0, 9)) {
            0 -> TileType.GRASS.type
            8,9 -> TileType.STONES.type
            5 -> TileType.ENEMY.type
            else -> 0
        }
    }

    val sky = List(matrix *2) {
        when (Random.nextInt(0, 9)) {
            0,1 -> TileType.CLOUD.type
            2,3,4,5,6,7,8,9 -> TileType.CLEAR.type
            else -> 0
        }
    }

    //Method is cool for testing
    fun printMatrix(x: Int, y: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val xy = x + (matrixSize * y)
            var str = ""
            for (i in floor.indices) {
                str = str.plus(
                    if (i == xy) {
                        "_"
                    } else {
                        floor[i]
                    }
                ).plus(" ")

                if (i % matrixSize == 0) {
                    println(str)
                    str = ""
                }

            }
        }
    }
    companion object {
        internal const val matrixSize = 12
        private const val matrix = (matrixSize * matrixSize) * 12
    }
}