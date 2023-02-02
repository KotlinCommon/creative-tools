package daat.spart.common.engine

import daat.spart.common.engine.type.Atom

object Atoms{

    private val String.getAtom
        get() =
            atoms.find {
                it.name.contains(this)
            }

    val atoms: List<Atom> by lazy {
        listOf(
            Atom(name = "Hydrogen", mass = 1.008, protons = 1, neutrons = 0, electrons = 1, electronegativity = 2.2),
            Atom(name = "Helium", mass = 4.003, protons = 2, neutrons = 2, electrons = 2, electronegativity = -1.0),
            Atom(name = "Lithium", mass = 6.941, protons = 3, neutrons = 4, electrons = 3, electronegativity = 0.98),
            Atom(name = "Beryllium", mass = 9.012, protons = 4, neutrons = 5, electrons = 4, electronegativity = 1.57),
            Atom(name = "Boron", mass = 10.81, protons = 5, neutrons = 6, electrons = 5, electronegativity = 2.04),
            Atom(name = "Carbon", mass = 12.01, protons = 6, neutrons = 6, electrons = 6, electronegativity = 2.55),
            Atom(name = "Nitrogen", mass = 14.01, protons = 7, neutrons = 7, electrons = 7, electronegativity = 3.04),
            Atom(name = "Oxygen", mass = 16.00, protons = 8, neutrons = 8, electrons = 8, electronegativity = 3.44),
            Atom(name = "Fluorine", mass = 19.00, protons = 9, neutrons = 10, electrons = 9, electronegativity = 3.98),
            Atom(name = "Neon", mass = 20.18, protons = 10, neutrons = 10, electrons = 10, electronegativity = -1.0),
            Atom(name = "Sodium", mass = 22.99, protons = 11, neutrons = 12, electrons = 11, electronegativity = 0.93),
            Atom(name = "Magnesium", mass = 24.31, protons = 12, neutrons = 12, electrons = 12, electronegativity = 1.31),
            Atom(name = "Aluminum", mass = 26.98, protons = 13, neutrons = 14, electrons = 13, electronegativity = 1.61),
            Atom(name = "Silicon", mass = 28.09, protons = 14, neutrons = 14, electrons = 14, electronegativity = 1.9),
            Atom(name = "Phosphorus", mass = 30.97, protons = 15, neutrons = 16, electrons = 15, electronegativity = 2.19),
            Atom(name = "Sulfur", mass = 32.07, protons = 16, neutrons = 16, electrons = 16, electronegativity = 2.58),
            Atom(name = "Chlorine", mass = 35.45, protons = 17, neutrons = 18, electrons = 17, electronegativity = 3.16),
            Atom(name = "Argon", mass = 39.95, protons = 18, neutrons = 22, electrons = 18, electronegativity = -1.0),
            Atom(name = "Potassium", mass = 39.10, protons = 19, neutrons = 20, electrons = 19, electronegativity = 0.82),
            Atom(name = "Scandium", mass = 44.96, protons = 21, neutrons = 24, electrons = 21, electronegativity = 1.36),
            Atom(name = "Calcium", mass = 40.08, protons = 20, neutrons = 20, electrons = 20, electronegativity = 1.0),
            Atom(name = "Titanium", mass = 47.87, protons = 22, neutrons = 26, electrons = 22, electronegativity = 1.54),
            Atom(name = "Vanadium", mass = 50.94, protons = 23, neutrons = 28, electrons = 23, electronegativity = 1.63),
            Atom(name = "Chromium", mass = 52.00, protons = 24, neutrons = 28, electrons = 24, electronegativity = 1.66),
            Atom(name = "Manganese", mass = 54.94, protons = 25, neutrons = 30, electrons = 25, electronegativity = 1.55),
            Atom(name = "Iron", mass = 55.85, protons = 26, neutrons = 30, electrons = 26, electronegativity = 1.83),
            Atom(name = "Cobalt", mass = 58.93, protons = 27, neutrons = 32, electrons = 27, electronegativity = 1.88),
            Atom(name = "Nickel", mass = 58.69, protons = 28, neutrons = 31, electrons = 28, electronegativity = 1.91),
            Atom(name = "Copper", mass = 63.55, protons = 29, neutrons = 35, electrons = 29, electronegativity = 1.9),
            Atom(name = "Zinc", mass = 65.38, protons = 30, neutrons = 35, electrons = 30, electronegativity = 1.65),
            Atom(name = "Gallium", mass = 69.72, protons = 31, neutrons = 39, electrons = 31, electronegativity = 1.81),
            Atom(name = "Germanium", mass = 72.63, protons = 32, neutrons = 41, electrons = 32, electronegativity = 2.01),
            Atom(name = "Arsenic", mass = 74.92, protons = 33, neutrons = 42, electrons = 33, electronegativity = 2.18),
            Atom(name = "Selenium", mass = 78.96, protons = 34, neutrons = 45, electrons = 34, electronegativity = 2.55),
            Atom(name = "Bromine", mass = 79.90, protons = 35, neutrons = 45, electrons = 35, electronegativity = 2.96),
            Atom(name = "Krypton", mass = 83.80, protons = 36, neutrons = 48, electrons = 36, electronegativity = -1.0),
            Atom(name = "Rubidium", mass = 85.47, protons = 37, neutrons = 48, electrons = 37, electronegativity = 0.82),
            Atom(name = "Strontium", mass = 87.62, protons = 38, neutrons = 50, electrons = 38, electronegativity = 0.95),
            Atom(name = "Yttrium", mass = 88.91, protons = 39, neutrons = 50, electrons = 39, electronegativity = 1.22),
            Atom(name = "Zirconium", mass = 91.22, protons = 40, neutrons = 51, electrons = 40, electronegativity = 1.33),
            Atom(name = "Niobium", mass = 92.91, protons = 41, neutrons = 52, electrons = 41, electronegativity = 1.6),
            Atom(name = "Molybdenum", mass = 95.94, protons = 42, neutrons = 54, electrons = 42, electronegativity = 2.16),
            Atom(name = "Technetium", mass = 98.00, protons = 43, neutrons = 55, electrons = 43, electronegativity = 1.9),
            Atom(name = "Ruthenium", mass = 101.1, protons = 44, neutrons = 57, electrons = 44, electronegativity = 2.2),
            Atom(name = "Rhodium", mass = 102.9, protons = 45, neutrons = 58, electrons = 45, electronegativity = 2.28),
            Atom(name = "Palladium", mass = 106.4, protons = 46, neutrons = 60, electrons = 46, electronegativity = 2.2),
            Atom(name = "Silver", mass = 107.9, protons = 47, neutrons = 61, electrons = 47, electronegativity = 1.93),
            Atom(name = "Cadmium", mass = 112.4, protons = 48, neutrons = 64, electrons = 48, electronegativity = 1.69),
            Atom(name = "Indium", mass = 114.8, protons = 49, neutrons = 66, electrons = 49, electronegativity = 1.78),
            Atom(name = "Tin", mass = 118.7, protons = 50, neutrons = 69, electrons = 50, electronegativity = 1.96),
            Atom(name = "Antimony", mass = 121.8, protons = 51, neutrons = 70, electrons = 51, electronegativity = 2.05),
            Atom(name = "Tellurium", mass = 127.6, protons = 52, neutrons = 76, electrons = 52, electronegativity = 2.1),
            Atom(name = "Tellurium", mass = 127.6, protons = 52, neutrons = 76, electrons = 52, electronegativity = 2.1),
            Atom(name = "Xenon", mass = 131.3, protons = 54, neutrons = 77, electrons = 54, electronegativity = -1.0),
            Atom(name = "Cesium", mass = 132.9, protons = 55, neutrons = 78, electrons = 55, electronegativity = 0.79),
            Atom(name = "Barium", mass = 137.3, protons = 56, neutrons = 81, electrons = 56, electronegativity = 0.89),
            Atom(name = "Lanthanum", mass = 138.9, protons = 57, neutrons = 82, electrons = 57, electronegativity = 1.1),
            Atom(name = "Cerium", mass = 140.1, protons = 58, neutrons = 82, electrons = 58, electronegativity = 1.12),
            Atom(name = "Praseodymium", mass = 140.9, protons = 59, neutrons = 82, electrons = 59, electronegativity = 1.13),
            Atom(name = "Neodymium", mass = 144.2, protons = 60, neutrons = 84, electrons = 60, electronegativity = 1.14),
            Atom(name = "Promethium", mass = 145.0, protons = 61, neutrons = 84, electrons = 61, electronegativity = 1.13),
            Atom(name = "Samarium", mass = 150.4, protons = 62, neutrons = 88, electrons = 62, electronegativity = 1.17),
            Atom(name = "Europium", mass = 152.0, protons = 63, neutrons = 89, electrons = 63, electronegativity = 1.2),
            Atom(name = "Gadolinium", mass = 157.3, protons = 64, neutrons = 93, electrons = 64, electronegativity = 1.2),
            Atom(name = "Terbium", mass = 158.9, protons = 65, neutrons = 94, electrons = 65, electronegativity = 1.2),
            Atom(name = "Dysprosium", mass = 162.5, protons = 66, neutrons = 97, electrons = 66, electronegativity = 1.22),
            Atom(name = "Holmium", mass = 164.9, protons = 67, neutrons = 98, electrons = 67, electronegativity = 1.23),
            Atom(name = "Erbium", mass = 167.3, protons = 68, neutrons = 99, electrons = 68, electronegativity = 1.24),
            Atom(name = "Thulium", mass = 168.9, protons = 69, neutrons = 100, electrons = 69, electronegativity = 1.25),
            Atom(name = "Ytterbium", mass = 173.0, protons = 70, neutrons = 103, electrons = 70, electronegativity = 1.1),
            Atom(name = "Lutetium", mass = 175.0, protons = 71, neutrons = 104, electrons = 71, electronegativity = 1.27),
            Atom(name = "Hafnium", mass = 178.5, protons = 72, neutrons = 106, electrons = 72, electronegativity = 1.3),
            Atom(name = "Tantalum", mass = 180.9, protons = 73, neutrons = 108, electrons = 73, electronegativity = 1.5),
            Atom(name = "Tungsten", mass = 183.8, protons = 74, neutrons = 110, electrons = 74, electronegativity = 2.36),
            Atom(name = "Rhenium", mass = 186.2, protons = 75, neutrons = 111, electrons = 75, electronegativity = 1.9),
            Atom(name = "Osmium", mass = 190.2, protons = 76, neutrons = 114, electrons = 76, electronegativity = 2.2),
            Atom(name = "Iridium", mass = 192.2, protons = 77, neutrons = 115, electrons = 77, electronegativity = 2.2),
            Atom(name = "Platinum", mass = 195.1, protons = 78, neutrons = 117, electrons = 78, electronegativity = 2.28),
            Atom(name = "Gold", mass = 197.0, protons = 79, neutrons = 118, electrons = 79, electronegativity = 2.54),
            Atom(name = "Mercury", mass = 200.6, protons = 80, neutrons = 121, electrons = 80, electronegativity = 2.0),
            Atom(name = "Thallium", mass = 204.4, protons = 81, neutrons = 123, electrons = 81, electronegativity = 1.62),
            Atom(name = "Lead", mass = 207.2, protons = 82, neutrons = 125, electrons = 82, electronegativity = 2.33),
            Atom(name = "Bismuth", mass = 209.0, protons = 83, neutrons = 126, electrons = 83, electronegativity = 2.02),
            Atom(name = "Polonium", mass = 209.0, protons = 84, neutrons = 125, electrons = 84, electronegativity = 2.0),
            Atom(name = "Astatine", mass = 210.0, protons = 85, neutrons = 125, electrons = 85, electronegativity = 2.2),
            Atom(name = "Radon", mass = 222.0, protons = 86, neutrons = 136, electrons = 86, electronegativity = -1.0),
            Atom(name = "Francium", mass = 223.0, protons = 87, neutrons = 136, electrons = 87, electronegativity = 0.7),
            Atom(name = "Radium", mass = 226.0, protons = 88, neutrons = 138, electrons = 88, electronegativity = 0.9),
            Atom(name = "Actinium", mass = 227.0, protons = 89, neutrons = 138, electrons = 89, electronegativity = 1.1),
            Atom(name = "Thorium", mass = 232.0, protons = 90, neutrons = 142, electrons = 90, electronegativity = 1.3),
            Atom(name = "Protactinium", mass = 231.0, protons = 91, neutrons = 141, electrons = 91, electronegativity = 1.5),
            Atom(name = "Uranium", mass = 238.0, protons = 92, neutrons = 146, electrons = 92, electronegativity = 1.38),
            Atom(name = "Neptunium", mass = 237.0, protons = 93, neutrons = 145, electrons = 93, electronegativity = 1.36),
            Atom(name = "Plutonium", mass = 244.0, protons = 94, neutrons = 150, electrons = 94, electronegativity = 1.28),
            Atom(name = "Americium", mass = 243.0, protons = 95, neutrons = 148, electrons = 95, electronegativity = 1.3),
            Atom(name = "Curium", mass = 247.0, protons = 96, neutrons = 151, electrons = 96, electronegativity = 1.3),
            Atom(name = "Berkelium", mass = 247.0, protons = 97, neutrons = 153, electrons = 97, electronegativity = 1.3),
            Atom(name = "Californium", mass = 251.0, protons = 98, neutrons = 153, electrons = 98, electronegativity = 1.3),
            Atom(name = "Einsteinium", mass = 252.0, protons = 99, neutrons = 153, electrons = 99, electronegativity = 1.3),
            Atom(name = "Fermium", mass = 257.0, protons = 100, neutrons = 157, electrons = 100, electronegativity = 1.3),
            Atom(name = "Mendelevium", mass = 258.0, protons = 101, neutrons = 157, electrons = 101, electronegativity = 1.3),
            Atom(name = "Nobelium", mass = 259.0, protons = 102, neutrons = 157, electrons = 102, electronegativity = 1.3),
            Atom(name = "Lawrencium", mass = 262.0, protons = 103, neutrons = 159, electrons = 103, electronegativity = 1.3),
            Atom(name = "Rutherfordium", mass = 261.0, protons = 104, neutrons = 157, electrons = 104, electronegativity = 1.3),
            Atom(name = "Dubnium", mass = 262.0, protons = 105, neutrons = 157, electrons = 105, electronegativity = 1.3),
            Atom(name = "Seaborgium", mass = 266.0, protons = 106, neutrons = 160, electrons = 106, electronegativity = 1.3),
            Atom(name = "Bohrium", mass = 264.0, protons = 107, neutrons = 159, electrons = 107, electronegativity = 1.3),
            Atom(name = "Hassium", mass = 277.0, protons = 108, neutrons = 161, electrons = 108, electronegativity = 1.3),
            Atom(name = "Meitnerium", mass = 268.0, protons = 109, neutrons = 162, electrons = 109, electronegativity = 1.3),
            Atom(name = "Darmstadtium", mass = 281.0, protons = 110, neutrons = 164, electrons = 110, electronegativity = 1.3),
            Atom(name = "Roentgenium", mass = 280.0, protons = 111, neutrons = 162, electrons = 111, electronegativity = 1.3),
            Atom(name = "Copernicium", mass = 285.0, protons = 112, neutrons = 165, electrons = 112, electronegativity = 1.3),
            Atom(name = "Nihonium", mass = 286.0, protons = 113, neutrons = 165, electrons = 113, electronegativity = 1.3),
            Atom(name = "Flerovium", mass = 289.0, protons = 114, neutrons = 167, electrons = 114, electronegativity = 1.3),
            Atom(name = "Moscovium", mass = 289.0, protons = 115, neutrons = 167, electrons = 115, electronegativity = 1.3),
            Atom(name = "Livermorium", mass = 293.0, protons = 116, neutrons = 170, electrons = 116, electronegativity = 1.3),
            Atom(name = "Tennessine", mass = 294.0, protons = 117, neutrons = 170, electrons = 117, electronegativity = 1.3),
            Atom(name = "Oganesson", mass = 294.0, protons = 118, neutrons = 173, electrons = 118, electronegativity = 1.3)
        )
    }

    val Iron: Atom by lazy { "Iron".getAtom!! }
    val Carbon: Atom by lazy { "Carbon".getAtom!! }
    val Manganese: Atom by lazy { "Manganese".getAtom!! }
    val Silicon: Atom by lazy { "Silicon".getAtom!! }
    val Phosphorus: Atom by lazy { "Phosphorus".getAtom!! }
    val Sulfur: Atom by lazy { "Sulfur".getAtom!! }
    val Hydrogen: Atom by lazy { "Hydrogen".getAtom!! }
    val Oxygen: Atom by lazy { "Oxygen".getAtom!! }
    val Nitrogen: Atom by lazy { "Nitrogen".getAtom!! }
    val Calcium: Atom by lazy { "Calcium".getAtom!! }
    val Chlorine: Atom by lazy { "Chlorine".getAtom!! }
    val Sodium: Atom by lazy { "Sodium".getAtom!! }
    val Potassium: Atom by lazy { "Potassium".getAtom!! }
    val Magnesium: Atom by lazy { "Magnesium".getAtom!! }
}
