package daat.spart.common.engine

class MoleculeItemMaterial(override val name: String, val formula: String = "", val chemicalEntities: List<Atom>) : ChemicalEntity {}