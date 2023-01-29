package de.cicerohellmann.core.data

import androidx.compose.ui.graphics.Color
import de.cicerohellmann.crafting.data.AdvancedGameItem
import de.cicerohellmann.crafting.data.MoleculeItemMaterial
import de.cicerohellmann.crafting.data.sample.Water
import de.cicerohellmann.types.Percentage
import de.cicerohellmann.types.PrI
import de.cicerohellmann.types.Presentation
import de.cicerohellmann.types.Weight
import de.cicerohellmann.viking.R
import java.lang.StrictMath.round
import java.math.BigDecimal
import java.util.*
import kotlin.random.Random

fun Any.idGenerator(): BigDecimal {
    val now = Date().time
    val firstPart = Random(this.hashCode() + now).nextLong(
        from = 0,
        until = this.hashCode() + now
    ).toString()
    val secondPart = (this.hashCode() + now).toString()
    return (firstPart + secondPart).toBigDecimal()
}

open class ATile(
    override val name: String,
    override val presentation: Presentation,
    override val parts: MutableList<AdvancedGameItem>,
    override val integrity: Percentage,
    override val mass: Weight,
    override val connections: MutableList<AdvancedGameItem>
) : AdvancedGameItem

//Also know as elements
data class Material(
    val name: String,
    val color: Color,
    val density: Int,//from 0 (gas) to 100 (solid) used to decide color from multiple materials
)

class Terrain(
    override val name: String,
    override val presentation: Presentation,
    override val parts: MutableList<AdvancedGameItem>,
    override val integrity: Percentage,
    override val mass: Weight,
    override val connections: MutableList<AdvancedGameItem>
) : AdvancedGameItem

class LandMass(
    override val name: String,
    override val presentation: Presentation,
    override val parts: MutableList<AdvancedGameItem>,
    override val integrity: Percentage,
    override val mass: Weight,
    override val connections: MutableList<AdvancedGameItem>,
    override val containing: MutableList<AdvancedGameItem>
) : AdvancedGameItem {
//    val t = Terrain(
//        name = "Dirt floor",
//        presentation = R.drawable.dirt_floor.PrI,
//        parts = mutableListOf(),
//        integrity = Percentage(value = 0.0),
//        mass = Weight(inGrams = 0.0),
//    )
//    Land should be populated with Terrains which are also GameItems

    private fun initTiles(): List<AdvancedGameItem> {
        val mutableListOfTiles = mutableListOf<AdvancedGameItem>()
        mutableListOfTiles.addAll(parts)
        return mutableListOfTiles.toList()
    }

    private fun randomAmountOfMaterials(listOfMaterials: List<MoleculeItemMaterial> = listOf(Water)): MutableSet<MoleculeItemMaterial> {
        val numberOfMaterials =
            Random(id.toLong()).nextInt(listOfMaterials.lastIndex)
        val setOfMaterials: MutableSet<MoleculeItemMaterial> = mutableSetOf()
        while (setOfMaterials.size != numberOfMaterials) {
            setOfMaterials.add(listOfMaterials[Random(id.toLong()).nextInt(numberOfMaterials)])
        }
        return setOfMaterials

    }

    val tiles: List<AdvancedGameItem> by lazy {
        initTiles()
    }
}

//class Planet(
//    override val name: String,
//    override val presentation: Presentation,
//    override val parts: MutableList<AdvancedGameItem>,
//    override val integrity: Percentage,
//    override val mass: Weight,
//    override val containing: MutableList<MutableList<MutableList<AdvancedGameItem>>>
//) : AdvancedGameItem {
//    val levels: List<AdvancedGameItem> by lazy {
//        initLevels()
//    }
//
//    init {
//        initTileConnections(levels)
//    }
//
//    private fun initLevels(): MutableList<LandMass> {
//        //The bigger the radios the more land it can accommodate, up and down
//        val listOfLevels = mutableListOf<LandMass>()
//        val middle = round(radius / 2)
//        repeat(radius.toInt()) { position ->
//            when {
//                position < middle -> {
////                    initAboveGround
//                    listOfLevels.add(
//                        position,
//                        initLand()
//                    )
//                }
//                position == middle -> {
////                    initSurface
//                    listOfLevels.add(
//                        position,
//                        initLand()
//                    )
//                }
//                position > middle -> {
////                    initUnderGround
//                    listOfLevels.add(
//                        position,
//                        initLand()
//                    )
//                }
//            }
//        }
//
//        return listOfLevels
//    }
//
//    private fun initLand(): LandMass {
//        return LandMass(
//            name = "",
//            presentation =,
//            parts =,
//            integrity = Percentage(value = 0.0),
//            mass = Weight(inGrams = 0.0),
//            connections =
//        )
//    }
//
//    private fun initTileConnections(listOfLevels: List<AdvancedGameItem>) {
//        listOfLevels.forEachIndexed { matrixIndex, matrixTerrainLand ->
//            matrixTerrainLand.parts.forEachIndexed { tileIndex, _ ->
//                val localListOfConnections = mutableListOf<AdvancedGameItem>()
//                val width = (matrixTerrainLand.parts.size * 2)
//                val x =
//                    tileIndex % width    // % is the "modulo operator", the remainder of i / width;
//                val y = tileIndex / width    // where "/" is an integer division
//                try {
//                    localListOfConnections.add(
//                        matrixTerrainLand.tiles[x - 1 + width * y]
//                    )
//                } catch (e: IndexOutOfBoundsException) {
//                    //then there is nothing to connect to
//                    //it would be interesting to initialize new areas here
//                }
//                try {
//                    localListOfConnections.add(
//                        matrixTerrainLand.tiles[x + 1 + width * y]
//                    )
//                } catch (e: IndexOutOfBoundsException) {
//                    //then there is nothing to connect to
//                }
//                try {
//                    localListOfConnections.add(
//                        matrixTerrainLand.tiles[x + width * y - 1]
//                    )
//                } catch (e: IndexOutOfBoundsException) {
//                    //then there is nothing to connect to
//                }
//                try {
//                    localListOfConnections.add(
//                        matrixTerrainLand.tiles[x + width * y + 1]
//                    )
//                } catch (e: IndexOutOfBoundsException) {
//                    //then there is nothing to connect to
//                }
//                try {
//                    localListOfConnections.add(
//                        listOfLevels[matrixIndex + 1].tiles[x + width * y]
//                    )
//                } catch (e: IndexOutOfBoundsException) {
//                    //then there is nothing to connect to
//                }
//                try {
//                    localListOfConnections.add(
//                        listOfLevels[matrixIndex - 1].tiles[x + width * y]
//                    )
//                } catch (e: IndexOutOfBoundsException) {
//                    //then there is nothing to connect to
//                }
////                x - 1 + width * y//-x
////                x + 1 + width * y//+x
////                x + width * y - 1//-y
////                x + width * y + 1//+y
////                upperArray[x + width * y]//-z
////                lowerArray[x + width * y]//+z
//
//            }
//        }
//    }
//}

interface IEntity {
    //not alive this would be an alive entity
    //
}

class Entity(
    val matrixId: Int, //
)

//class CreatingALandTest() {
//    init {
//        Planet(
//            materials = listOf(Soil, Water, Air),
//            radius = 3f
//        )
//    }
//}