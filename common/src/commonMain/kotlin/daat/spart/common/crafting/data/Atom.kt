package de.cicerohellmann.crafting.data

data class Atom(
    override val name: String,
    val mass: Double,
    val protons: Int,
    val neutrons: Int,
    val electrons: Int,
    val electronegativity: Double
): ChemicalEntity {

    val atomicNumber: Int = protons
    val massNumber: Int = protons + neutrons

    /*
    *   Isotopes
    *   You could manually add or remove isotopes from the list as needed. For example, you might
    * want to add an isotope to the list if the player discovers a new isotope of an element in the game.
    *
    *   You could calculate the list of isotopes based on the properties of the atom. For example,
    * you could use the atomic number and mass number of the atom to determine the possible combinations
    * of protons and neutrons that could make up the isotopes of the element.
    *
    *   You could update the list of isotopes based on the results of chemical reactions involving the atom.
    * For example, if the atom undergoes a nuclear reaction, the number of protons and neutrons in the atom's
    * nucleus could change, resulting in a different set of isotopes.
    */
    val isotopes: List<Atom> = listOf()  // list of isotopes for the atom

    private fun bondingBehavior(otherAtom: Atom): BondType {
        val electronegativityDifference =
            kotlin.math.abs(this.electronegativity - otherAtom.electronegativity)
        return when {
            electronegativityDifference > 1.7 -> BondType.IONIC
            electronegativityDifference > 0.5 -> BondType.COVALENT
            else -> BondType.METALLIC
        }
    }

    fun react(otherAtom: Atom, conditions: ReactionConditions): List<Atom> {
        // determine the types of bonds that the de.cicerohellmann.crafting.models.getAtoms can form based on their electronegativities

        // apply the appropriate reaction rules based on the bond type and other factors (e.g., temperature, pressure, etc.)
        return when (this.bondingBehavior(otherAtom)) {
            BondType.IONIC -> reactIonic(otherAtom, conditions)
            BondType.COVALENT -> reactCovalent(otherAtom, conditions)
            BondType.METALLIC -> reactMetallic(otherAtom, conditions)
            else -> listOf(this, otherAtom)  // no reaction occurs
        }
    }

    private fun reactIonic(otherAtom: Atom, conditions: ReactionConditions): List<Atom> {
        // apply the appropriate reaction rules for ionic bonds based on the properties of the de.cicerohellmann.crafting.models.getAtoms and the reaction conditions
        return listOf()
    }

    private fun reactCovalent(otherAtom: Atom, conditions: ReactionConditions): List<Atom> {
        // apply the appropriate reaction rules for covalent bonds based on the properties of the de.cicerohellmann.crafting.models.getAtoms and the reaction conditions
        return listOf()
    }

    private fun reactMetallic(otherAtom: Atom, conditions: ReactionConditions): List<Atom> {
        // apply the appropriate reaction rules for metallic bonds based on the properties of the de.cicerohellmann.crafting.models.getAtoms and the reaction conditions
        return listOf()
    }
}

data class ReactionConditions(
    val temperature: Double,
    val pressure: Double,
    val catalyst: Atom?
)

enum class BondType {
    NONE, IONIC, COVALENT, METALLIC
}