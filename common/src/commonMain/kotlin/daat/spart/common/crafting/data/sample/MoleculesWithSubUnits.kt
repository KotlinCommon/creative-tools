package de.cicerohellmann.crafting.data.sample

import de.cicerohellmann.crafting.data.MoleculeItemMaterial
import de.cicerohellmann.crafting.data.sample.Atoms.Calcium
import de.cicerohellmann.crafting.data.sample.Atoms.Phosphorus

val Minerals = MoleculeItemMaterial(
    "Minerals",
    "CaP(PO4)3",
    mutableListOf(Calcium, Phosphorus) + Phosphate.chemicalEntities
)