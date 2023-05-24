package engine.type

import engine.coroutineWithScope
import engine.integrityDecrease
import engine.tools.idGenerator

interface AdvancedGameItem {
    val id: Double
        get() = idGenerator()
    val name: String
    val presentation: Presentation
    val parts: MutableList<AdvancedGameItem>
    val integrity: Percentage
    val mass: Weight
    val containingLimit: Weight
        get() = 0.G
    val containing: MutableList<AdvancedGameItem>
        get() = parts.flatMap { it.containing }.toMutableList()
    val dressing: MutableList<AdvancedGameItem>
        get() = parts.flatMap { it.dressing }.toMutableList()
    val materials: Map<LongRange, ChemicalEntity>
        get() = mapOf()
    val connections: MutableList<AdvancedGameItem>
        get() = mutableListOf()
    val superimposed: MutableList<AdvancedGameItem>
        get() = mutableListOf()

    suspend fun simulationLowPriority() {
        coroutineWithScope {
            val totalWeightInGrams =
                containing.map { it.mass }.sumOf { it.inGrams }
            integrityDecrease(totalWeightInGrams, containingLimit.inGrams)
            if (totalWeightInGrams >= containingLimit.inGrams)
                integrity
        }
    }

    suspend fun simulation() {
        simulationLowPriority()
    }

}