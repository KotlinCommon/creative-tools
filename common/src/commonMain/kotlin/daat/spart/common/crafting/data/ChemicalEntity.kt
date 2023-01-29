package de.cicerohellmann.crafting.data

import de.cicerohellmann.types.Rng

interface ChemicalEntity {
    val name: String
}

val ChemicalEntity.L
    get() = mapOf(100L.Rng to this)