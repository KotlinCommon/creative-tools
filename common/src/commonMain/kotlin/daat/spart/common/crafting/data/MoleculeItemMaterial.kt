package de.cicerohellmann.crafting.data

class MoleculeItemMaterial(override val name: String, val formula: String = "", val chemicalEntities: List<Atom>) : ChemicalEntity {}