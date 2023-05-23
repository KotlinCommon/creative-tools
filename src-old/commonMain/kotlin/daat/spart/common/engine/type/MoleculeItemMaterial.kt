package daat.spart.common.engine.type

class MoleculeItemMaterial(override val name: String, val formula: String = "", val chemicalEntities: List<Atom>) :
    ChemicalEntity