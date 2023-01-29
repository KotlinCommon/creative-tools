package de.cicerohellmann.crafting.data

import de.cicerohellmann.types.*

data class BodyPart(
    override val name: String,
    override val presentation: Presentation = name.Pr,
    override val parts: MutableList<AdvancedGameItem> = mutableListOf(),
    override val materials: Map<LongRange, ChemicalEntity> = parts.flatMap { it.materials.entries }
        .associate { it.key to it.value },
    override val mass: Weight = parts.sumOf { it.mass.inGrams.toInt() }.G,
    override val integrity: Percentage = 100.P,
    override val containingLimit: Weight = 0.G,
    override val containing: MutableList<AdvancedGameItem> = parts.flatMap { it.dressing }
        .toMutableList(),
    override val dressing: MutableList<AdvancedGameItem> = parts.flatMap { it.containing }
        .toMutableList(),
) : AdvancedGameItem