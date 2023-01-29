package de.cicerohellmann.crafting.data


//AKA substance
data class ItemMaterial(
    override val name: String = "",  // name of the material
    val density: Double = 0.0,  // mass per unit volume of the material
    val meltingPoint: Double = 0.0,  // temperature at which the material changes from a solid to a liquid
    val boilingPoint: Double = 0.0,  // temperature at which the material changes from a liquid to a gas
    val solubility: Double = 0.0,  // solubility of the material in a given solvent
    val solvent: String = "",  // solvent in which the material is soluble
    val absorbance: Double = 0.0,  // ability of the material to absorb a substance
    val capacity: Double = 0.0,  // ability of the material to hold a substance
    val flammability: Double = 0.0,  // likelihood of the material to catch fire and burn
    val flashPoint: Double = 0.0,  // minimum temperature at which the material will catch fire
    val heatOfCombustion: Double = 0.0,  // heat released when the material burns
    val conductivity: Double = 0.0,  // ability of the material to conduct electricity
    val malleability: Double = 0.0,  // ability of the material to be deformed or shaped by hammering or rolling
    val ductility: Double = 0.0,  // ability of the material to be drawn into wire or to be molded
    val tensileStrength: Double = 0.0,  // resistance of the material to being pulled or stretched
    val compressiveStrength: Double = 0.0,  // resistance of the material to being pressed or squeezed
    val shearStrength: Double = 0.0,  // resistance of the material to being cut or split
    val hardness: Double = 0.0,  // resistance of the material to being scratched or indented
    val toughness: Double = 0.0,  // ability of the material to absorb energy and deform without breaking
    val elasticity: Double = 0.0,  // ability of the material to return to its original shape after being deformed
    val molecularWeight: Double = 0.0,  // weight of a molecule of the material
    // chemical formula of the molecules of the material
    val molecularFormula: String = "",
    // list of elements that make up the material
    val elements: List<Atom> = emptyList(),
    // list of molecules that make up the material
    val chemicalEntities: Map<LongRange, Map<LongRange, ChemicalEntity>> = emptyMap(),
    val chemicalEntity: Map<LongRange, ItemMaterial> = emptyMap(),
    // arrangement of de.cicerohellmann.crafting.models.getAtoms or molecules in the material's crystal lattice
    val crystalStructure: String = "",
    // appearance or feel of the surface of the material
    val texture: String = "",
    // color of the material
    val color: String = "",
    // ability of the material to transmit light or allow objects to be seen through it
    val transparency: Double = 0.0,
    // ability of the material to bend light as it passes through it
    val refractiveIndex: Double = 0.0,
    // degree to which the material spreads light of different wavelengths into a spectrum
    val dispersion: Double = 0.0,
    // shine or gloss of the material's surface
    val luster: String = "",
    // tendency of the material to break along certain planes or directions
    val cleavage: String = "",
    // type of surface left on a broken piece of the material
    val fracture: String = "",
    // color of the material in powdered form
    val streak: String = "",
    // smell of the material
    val odour: String = "",
    // taste of the material
    val taste: String = "",
    // tendency of the material to participate in chemical reactions
    val reactivity: String = "",
    // ability of the material to resist change or decomposition
    val stability: String = "",
    // list of potential hazards associated with the material, such as toxicity, flammability, etc.
    val hazards: List<String> = emptyList(),
    // list of common uses for the material
    val uses: List<String> = emptyList(),
    // brief history or background information about the material
    val history: String = "",
    // list of sources or locations where the material can be obtained
    val sources: List<String> = emptyList(),
    // description of the process or steps involved in obtaining or refining the material
    val processing: String = "",
    // any additional properties or characteristics of the material that are not covered by the other properties
    val additionalProperties: Map<String, Any> = emptyMap()
):ChemicalEntity {


    var temperature: Double = 0.0
    var pressure: Double = 0.0
    var state: StateOfSubstance = StateOfSubstance.SOLID

    enum class StateOfSubstance {
        GASEOUS,
        LIQUID,
        SOLID,
        PLASMA,
        BEC,//Bose-Einstein Condensate
        Superfluid;

        companion object {
            fun findEnum(value: String): StateOfSubstance {
                values().forEach { stateOfMatter ->
                    if (stateOfMatter.name.contains(value)) {
                        return stateOfMatter
                    }
                }
                throw Exception("No state of matter found with value: $value")
            }
        }
    }

    fun updateProperties() {
        // update the temperature, pressure, and state properties based on the substance's composition
        // and the current temperature and pressure
        if (temperature < 0.0) {
            state = StateOfSubstance.SOLID
        } else if (temperature > 100.0) {
            state = StateOfSubstance.GASEOUS
        } else {
            state = StateOfSubstance.LIQUID
        }

        for (i in 1..9 step 2) {
            print(i) // Print 13579
        }
    }

}