package de.cicerohellmann.crafting.data

import de.cicerohellmann.crafting.data.sample.*
import de.cicerohellmann.types.*
import de.cicerohellmann.viking.R

class Player(
    override val name: String,
    override val presentation: Presentation,
    override val parts: MutableList<AdvancedGameItem>,
    override val materials: Map<LongRange, ChemicalEntity> = parts.flatMap { it.materials.entries }
        .associate { it.key to it.value },
    override val integrity: Percentage =  100.0.P,
    override val containing: MutableList<AdvancedGameItem> = parts.flatMap { it.dressing }.toMutableList(),
    override val dressing: MutableList<AdvancedGameItem> = parts.flatMap { it.containing }.toMutableList(),
    override val mass: Weight
) : AdvancedGameItem {}

val player = Player(
    name = "Player1",
    presentation = R.drawable.player_one.PrI,
    parts = mutableListOf(Head, Torso, LeftArm, LeftLeg, RightArm, RightLeg),
    mass = 90.Kg
)

//fun Player.equipItem(item: ItemAdvanced){
//    item.compatibleEquipmentSlot.filter {  }
//    parts.find { it.name == item.compatibleEquipmentSlot.find { it.name,  } }
//}
//
//fun Player.equipItem(item: ItemAdvanced) {
//    if (parts.any { item.compatibleEquipmentSlot.contains(it) }) {
//        // the item is compatible with at least one of the player's parts
//        // equip the item to the player
//        equippedItems.add(item)
//        println("Item ${item.name} has been equipped to ${name}")
//    } else {
//        // the item is not compatible with any of the player's parts
//        println("Item ${item.name} cannot be equipped to ${player.name}. This item is not compatible with any of the player's body parts.")
//    }
//}