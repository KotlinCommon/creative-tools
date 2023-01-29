package de.cicerohellmann.crafting.data.sample

import de.cicerohellmann.crafting.data.ItemAdvanced
import de.cicerohellmann.crafting.data.L
import de.cicerohellmann.crafting.data.sample.Atoms.Carbon
import de.cicerohellmann.types.G
import de.cicerohellmann.types.Kg
import de.cicerohellmann.types.PrI
import de.cicerohellmann.types.Rng
import de.cicerohellmann.viking.R

object Items {
    val Bread
        get() = ItemAdvanced(name = "Bread", presentation = R.drawable.bread.PrI, materials = Carbon.L, mass = 500.G)
    val Tomato
        get() = ItemAdvanced(name = "Tomato", presentation = R.drawable.tomato.PrI, materials = Carbon.L, mass = 50.G)
    val Lettuce
        get() = ItemAdvanced(name = "Lettuce", presentation = R.drawable.letuce.PrI, materials = Carbon.L, mass = 25.G)
    val Burger
        get() = ItemAdvanced(name = "Burger", presentation = R.drawable.burger.PrI, parts = mutableListOf(Bread, Tomato, Lettuce), mass = 125.G)
    val Handle
        get() = ItemAdvanced(name = "Handle", materials = mapOf(35L.Rng to OakWood), mass = 20.G)
    val HammerHead
        get() = ItemAdvanced(name = "Head", materials = mapOf(55L.Rng to Steel), mass = 100.G)
    val Hammer
        get() = ItemAdvanced(name = "Hammer", parts = mutableListOf(Handle, HammerHead))
    val Backpack
        get() = ItemAdvanced(
            name = "Backpack",
            presentation = R.drawable.backpack.PrI,
            parts = mutableListOf(LeatherStrip, LeatherStrip, LeatherStrip, LeatherStrip, Hide, Hide),
            mass = 5.Kg
        )
    val LeatherStrip
        get() = ItemAdvanced(name = "Leather Strip", presentation = R.drawable.leather_strip.PrI, materials = Leather.L)
    val Hide
        get() = ItemAdvanced(name = "Leather", presentation = R.drawable.hide.PrI, materials = Leather.L)

}