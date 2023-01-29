package de.cicerohellmann.crafting.data.sample

import de.cicerohellmann.crafting.data.ItemMaterial
import de.cicerohellmann.crafting.data.L
import de.cicerohellmann.crafting.data.sample.Atoms.Calcium
import de.cicerohellmann.crafting.data.sample.Atoms.Carbon
import de.cicerohellmann.crafting.data.sample.Atoms.Chlorine
import de.cicerohellmann.crafting.data.sample.Atoms.Hydrogen
import de.cicerohellmann.crafting.data.sample.Atoms.Iron
import de.cicerohellmann.crafting.data.sample.Atoms.Magnesium
import de.cicerohellmann.crafting.data.sample.Atoms.Manganese
import de.cicerohellmann.crafting.data.sample.Atoms.Nitrogen
import de.cicerohellmann.crafting.data.sample.Atoms.Oxygen
import de.cicerohellmann.crafting.data.sample.Atoms.Phosphorus
import de.cicerohellmann.crafting.data.sample.Atoms.Potassium
import de.cicerohellmann.crafting.data.sample.Atoms.Silicon
import de.cicerohellmann.crafting.data.sample.Atoms.Sodium
import de.cicerohellmann.crafting.data.sample.Atoms.Sulfur
import de.cicerohellmann.types.L
import de.cicerohellmann.types.Rng

val Lignin
    get() = ItemMaterial(
        name = "Lignin",
        chemicalEntities = mapOf(
            60L..75L to Carbon.L,
            20L..25L to Oxygen.L,
            6L..8L to Hydrogen.L,
            0.2.L..0.75.L to Sulfur.L,
            0.2.L..0.75.L to Nitrogen.L,
            0.2.L..0.75.L to Chlorine.L,
        )
    )

val Hemicellulose
    get() = ItemMaterial(
        name = "Hemicellulose",
        chemicalEntities = mapOf(
            40L..50L to Carbon.L,
            40L..50L to Oxygen.L,
            6L..8L to Hydrogen.L,
        )
    )
val Cellulose
    get() = ItemMaterial(
        name = "Cellulose",
        chemicalEntities = mapOf(
            40L..50L to Carbon.L,
            40L..50L to Oxygen.L,
            6L..8L to Hydrogen.L,
        )
    )

val OakWood
    get() = ItemMaterial(
        name = "Oak Wood",
        chemicalEntities = mapOf(
            45L.Rng to Cellulose.L,
            20L.Rng to Lignin.L,
            30L.Rng to Hemicellulose.L
        )
    )

val Steel
    get() = ItemMaterial(
        name = "Steel",
        chemicalEntities = mapOf(
            97.7.L.Rng to Iron.L,
            0.5.L.Rng to Carbon.L,
            1.2.L.Rng to Manganese.L,
            0.1.L.Rng to Silicon.L,
            0.1.L.Rng to Phosphorus.L,
            0.04.L.Rng to Sulfur.L
        )
    )

val HumanBodyPart
    get() = ItemMaterial(
        name = "Human Body Part",
        chemicalEntities = mapOf(
            65..70L to Water.L,
            10..15L to Protein.L,
            10..15L to Lipid.L,
            2..4L to Minerals.L,
            1..2L to Carbohydrates.L,
            1..2L to NucleicAcids.L,
            1.0.L.Rng to Electrolytes.L,
        )
    )

val Leather = ItemMaterial(
    name = "Leather",
    chemicalEntities = mapOf(
        30..35L to Collagen.L,
        30..35L to Lipid.L,
        30..35L to Melanin.L,
        5..10L to Water.L,
        0..5L to Minerals.L,
        0..5L to Electrolytes.L
    )
)

val Melanin
    get() = ItemMaterial(
        name = "Melanin",
        chemicalEntities = mapOf(
            70L.Rng to Carbon.L,
            18L.Rng to Oxygen.L,
            10L.Rng to Hydrogen.L,
            1L.Rng to Nitrogen.L,
            1L.Rng to Sulfur.L
        )
    )

val Electrolytes
    get() = ItemMaterial(
        name = "Electrolytes",
        chemicalEntities = mapOf(
            1L..5L to Sodium.L,
            1L..5L to Potassium.L,
            1L..5L to Calcium.L,
            1L..5L to Phosphate.L,
            1L..5L to Magnesium.L,
        )
    )