package daat.spart.common.engine

interface ChemicalEntity {
    val name: String
}

val ChemicalEntity.L
    get() = mapOf(100L.Rng to this)