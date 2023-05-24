package engine.type

import engine.type.Atom
import engine.type.ChemicalEntity

class MoleculeItemMaterial(override val name: String, val formula: String = "", val chemicalEntities: List<Atom>) :
    ChemicalEntity