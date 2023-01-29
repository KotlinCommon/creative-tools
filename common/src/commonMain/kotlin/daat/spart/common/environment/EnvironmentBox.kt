package de.cicerohellmann.environment

data class EnvironmentBox(
    val name: String, // the name of the planet
    val radius: Double, // radius of the planet in meters
    val mass: Double, // mass of the planet in kilograms
    val gravity: Double, // acceleration due to gravity on the planet's surface in meters/second^2
    val temperature: Double, // average surface temperature of the planet in degrees Celsius
    val pressure: Double, // atmospheric pressure at the planet's surface in pascals
    val composition: Map<String, Double>, // the chemical makeup of the planet's atmosphere, oceans, and solid surface
    val rotation: Rotation, // the planet's rotational period and axial tilt
    val magneticField: MagneticField, // the planet's magnetic field
    val orbits: Orbits // the planet's orbit around its star and the orbits of any moons or other celestial objects in its system
)

data class Rotation(
    val period: Double, // the planet's rotational period in hours
    val axialTilt: Double // the planet's axial tilt in degrees
)

data class MagneticField(
    val strength: Double, // the strength of the planet's magnetic field in teslas
    val orientation: String // the orientation of the planet's magnetic field (e.g. dipole, quadrupole, etc.)
)

data class Orbits(
    val star: Star, // the planet's star
    val period: Double, // the planet's orbital period around its star in years
    val eccentricity: Double, // the planet's orbital eccentricity (a measure of the degree to which its orbit deviates from a perfect circle)
    val inclination: Double, // the planet's orbital inclination (the angle at which it orbits relative to the plane of the star's equator)
    val moons: List<Moon> // a list of the planet's moons
)

data class Star(
    val name: String, // the name of the star
    val mass: Double, // the mass of the star in solar masses
    val radius: Double, // the radius of the star in solar radii
    val temperature: Double, // the surface temperature of the star in degrees Kelvin
    val luminosity: Double // the luminosity of the star in solar luminosities
)

data class Moon(
    val name: String, // the name of the moon
    val mass: Double, // the mass of the moon in kilograms
    val radius: Double, // the radius of the moon in meters
    val orbits: Orbits // the moon's orbit around its planet
)