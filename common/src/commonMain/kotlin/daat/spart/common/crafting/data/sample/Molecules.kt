package de.cicerohellmann.crafting.data.sample

import de.cicerohellmann.crafting.data.MoleculeItemMaterial
import de.cicerohellmann.crafting.data.sample.Atoms.Carbon
import de.cicerohellmann.crafting.data.sample.Atoms.Hydrogen
import de.cicerohellmann.crafting.data.sample.Atoms.Nitrogen
import de.cicerohellmann.crafting.data.sample.Atoms.Oxygen
import de.cicerohellmann.crafting.data.sample.Atoms.Phosphorus
import de.cicerohellmann.crafting.data.sample.Atoms.Sulfur

val Collagen = MoleculeItemMaterial("Collagen", "C258H400N72O78S6", listOf(Carbon, Hydrogen, Nitrogen, Oxygen, Sulfur))
val Elastin = MoleculeItemMaterial("Elastin", "C267H442N52O67S6", listOf(Carbon, Hydrogen, Nitrogen, Oxygen, Sulfur))
val Lipid = MoleculeItemMaterial("Lipid", "CxHyOx", listOf(Carbon, Hydrogen,Oxygen))
val Carbohydrates = MoleculeItemMaterial("Carbohydrates", "Cx(H2O)y", listOf(Carbon, Hydrogen, Oxygen))
val NucleicAcids = MoleculeItemMaterial("Nucleic acids", "CxHxNxOxPx", listOf(Carbon, Hydrogen, Oxygen, Nitrogen, Phosphorus))
val Phosphate = MoleculeItemMaterial("Phosphate", "PO4", listOf(Phosphorus, Oxygen))
val Water = MoleculeItemMaterial("Water", "H2O", listOf(Hydrogen, Oxygen))
val Protein = MoleculeItemMaterial("Protein", "CxHyNzOx", listOf(Carbon, Hydrogen, Nitrogen, Oxygen))
