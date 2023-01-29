package de.cicerohellmann.crafting.data.sample

import de.cicerohellmann.crafting.data.BodyPart
import de.cicerohellmann.crafting.data.L
import de.cicerohellmann.types.Percentage
import de.cicerohellmann.types.PrI
import de.cicerohellmann.viking.R


val Head = BodyPart(
    name = "Head",
    presentation = R.drawable.head.PrI,
    materials = HumanBodyPart.L,
    integrity = Percentage(value = 100.0),
)

val LeftArm = BodyPart(
    name = "Left Arm",
    presentation = R.drawable.left_arm.PrI,
    materials = HumanBodyPart.L,
    integrity = Percentage(value = 100.0),
)

val Torso = BodyPart(
    name = "Torso",
    presentation = R.drawable.torso.PrI,
    materials = HumanBodyPart.L,
    integrity = Percentage(value = 100.0),
)

val RightArm = BodyPart(
    name = "Right Arm",
    presentation = R.drawable.right_arm.PrI,
    materials = HumanBodyPart.L,
    integrity = Percentage(value = 100.0),
)

val LeftLeg = BodyPart(
    name = "Left Leg",
    presentation = R.drawable.left_leg.PrI,
    materials = HumanBodyPart.L,
    integrity = Percentage(value = 100.0),
)

val RightLeg = BodyPart(
    name = "Head",
    presentation = R.drawable.right_leg.PrI,
    materials = HumanBodyPart.L,
    integrity = Percentage(value = 100.0),
)