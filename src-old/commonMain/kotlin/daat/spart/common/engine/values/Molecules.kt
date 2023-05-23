package daat.spart.common.engine.values

import daat.spart.common.engine.values.Atoms.Carbon
import daat.spart.common.engine.values.Atoms.Hydrogen
import daat.spart.common.engine.values.Atoms.Nitrogen
import daat.spart.common.engine.values.Atoms.Oxygen
import daat.spart.common.engine.values.Atoms.Phosphorus
import daat.spart.common.engine.values.Atoms.Sulfur
import daat.spart.common.engine.type.MoleculeItemMaterial

val Collagen = MoleculeItemMaterial("Collagen", "C258H400N72O78S6", listOf(Carbon, Hydrogen, Nitrogen, Oxygen, Sulfur))
val Elastin = MoleculeItemMaterial("Elastin", "C267H442N52O67S6", listOf(Carbon, Hydrogen, Nitrogen, Oxygen, Sulfur))
val Lipid = MoleculeItemMaterial("Lipid", "CxHyOx", listOf(Carbon, Hydrogen,Oxygen))
val Carbohydrates = MoleculeItemMaterial("Carbohydrates", "Cx(H2O)y", listOf(Carbon, Hydrogen, Oxygen))
val NucleicAcids = MoleculeItemMaterial("Nucleic acids", "CxHxNxOxPx", listOf(Carbon, Hydrogen, Oxygen, Nitrogen, Phosphorus))
val Phosphate = MoleculeItemMaterial("Phosphate", "PO4", listOf(Phosphorus, Oxygen))
val Water = MoleculeItemMaterial("Water", "H2O", listOf(Hydrogen, Oxygen))
val Protein = MoleculeItemMaterial("Protein", "CxHyNzOx", listOf(Carbon, Hydrogen, Nitrogen, Oxygen))
