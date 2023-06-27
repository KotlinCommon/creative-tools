package flashLight

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt


data class Point(val x: Double, val y: Double)
data class Ray(val a: Point, val b: Point)
data class Segment(val a: Point, val b: Point)
data class Intersection(val point: Point, val param: Double, var angle: Double? = null)

fun getIntersection(ray: Ray, segment: Segment): Intersection? {
    // RAY in parametric: Point + Delta*T1
    val r_px = ray.a.x
    val r_py = ray.a.y
    val r_dx = ray.b.x - ray.a.x
    val r_dy = ray.b.y - ray.a.y

    // SEGMENT in parametric: Point + Delta*T2
    val s_px = segment.a.x
    val s_py = segment.a.y
    val s_dx = segment.b.x - segment.a.x
    val s_dy = segment.b.y - segment.a.y

    // Are they parallel? If so, no intersect
    val r_mag = sqrt(r_dx * r_dx + r_dy * r_dy)
    val s_mag = sqrt(s_dx * s_dx + s_dy * s_dy)
    if (r_dx / r_mag == s_dx / s_mag && r_dy / r_mag == s_dy / s_mag) {
        // Unit vectors are the same.
        return null
    }

    // SOLVE FOR T1 & T2
    // r_px+r_dx*T1 = s_px+s_dx*T2 && r_py+r_dy*T1 = s_py+s_dy*T2
    // ==> T1 = (s_px+s_dx*T2-r_px)/r_dx = (s_py+s_dy*T2-r_py)/r_dy
    // ==> s_px*r_dy + s_dx*T2*r_dy - r_px*r_dy = s_py*r_dx + s_dy*T2*r_dx - r_py*r_dx
    // ==> T2 = (r_dx*(s_py-r_py) + r_dy*(r_px-s_px))/(s_dx*r_dy - s_dy*r_dx)
    val T2 = (r_dx * (s_py - r_py) + r_dy * (r_px - s_px)) / (s_dx * r_dy - s_dy * r_dx)
    val T1 = (s_px + s_dx * T2 - r_px) / r_dx

    // Must be within parametric whatevers for RAY/SEGMENT
    if (T1 < 0) return null
    if (T2 < 0 || T2 > 1) return null

    // Return the POINT OF INTERSECTION
    return Intersection(
        point = Point(
            x = r_px + r_dx * T1, y = r_py + r_dy * T1
        ), param = T1
    )
}

fun getSightPolygon(sightX: Double, sightY: Double, segments: List<Segment>): List<Intersection> {
    // Get all unique points
    val points = segments.flatMap { listOf(it.a, it.b) }
    val uniquePoints = points.distinct()

    // Get all angles
    val uniqueAngles = uniquePoints.flatMap { point ->
        val angle = atan2(point.y - sightY, point.x - sightX)
        listOf(angle - 0.00001f, angle, angle + 0.00001f)
    }

    // RAYS IN ALL DIRECTIONS
    val intersects = uniqueAngles.mapNotNull { angle ->
        val dx = cos(angle)
        val dy = sin(angle)

        // Ray from center of screen to mouse
        val ray = Ray(Point(sightX, sightY), Point(sightX + dx, sightY + dy))

        // Find CLOSEST intersection
        var closestIntersect: Intersection? = null
        for (segment in segments) {
            val intersect = getIntersection(ray, segment)
            if (intersect != null && (closestIntersect == null || intersect.param < closestIntersect.param)) {
                closestIntersect = intersect
            }
        }

        // Intersect angle
        closestIntersect?.angle = angle

        closestIntersect
    }

    // Sort intersects by angle
    return intersects.sortedBy { it.angle }
}


@Composable
fun draw(segments: List<Segment>) {

    val mousePosition = remember { mutableStateOf(Offset(0f, 0f)) } // initialize with the appropriate mouse position
    val fuzzyRadius = 10

    Canvas(modifier = Modifier.fillMaxSize().pointerInput(Unit) {
            detectDragGestures { change, _ ->
                mousePosition.value = change.position
            }
        }) {
        // Clear canvas
        drawRect(Color.Black)


        // Get sight polygons
        val polygons =
            mutableListOf(getSightPolygon(mousePosition.value.x.toDouble(), mousePosition.value.y.toDouble(), segments))
//        IF WE DON'T NEED FUZZYNESS then this part of the algo is unnecessary
        for (angle in 0 until 360 step 36) { // (Math.PI*2)/10 is roughly equal to 36 degrees
            val radian = angle.toDouble().toRadians()
            val dx = cos(radian) * fuzzyRadius
            val dy = sin(radian) * fuzzyRadius
            polygons.add(getSightPolygon(mousePosition.value.x + dx, mousePosition.value.y + dy, segments))
        }


        // Define color for transparency
        val transparentWhite = Color.White.copy(alpha = 0.2f)



        // Draw segments
        segments.forEach { segment ->
            drawLine(
                color = Color.Gray,  // "#999" in ARGB is Color.Gray
                start = Offset(x = segment.a.x.toFloat(), y = segment.a.y.toFloat()),
                end = Offset(x = segment.b.x.toFloat(), y = segment.b.y.toFloat()),
                strokeWidth = Stroke.DefaultMiter
            )
        }
//         Draw the polygons as paths
        for (i in 1 until polygons.size) {
//            This makes the shadow get stylish and causes the glitch when the dot goes over the border and the light sort of splashes everywhere
            drawPolygon(polygon = polygons[i], fillStyle = transparentWhite)
        }
        drawPolygon(polygon = polygons[0], fillStyle = Color.White)


        // Draw a red dot at the mouse location

        drawCircle(
            color = Color(0xFFDD3838), // "#dd3838" in ARGB
            radius = 2f, center = mousePosition.value
        )

        // Draw additional red dots in a circular pattern around the mouse location
//        for (angle in 0 until 360 step 36) { // (Math.PI*2)/10 is roughly equal to 36 degrees
//            val radian = angle.toDouble().toRadians()
//            val dx = cos(radian) * fuzzyRadius
//            val dy = sin(radian) * fuzzyRadius
//            drawCircle(
//                color = Color.Red, // "#dd3838" in ARGB
//                radius = 2f,
//                center = Offset(
//                    x = (mousePosition.value.x + dx).toFloat(),
//                    y = (mousePosition.value.y + dy).toFloat()
//                )
//            )
//        }
//        END OF DRAWSCOPE
    }
}


fun DrawScope.drawPolygon(polygon: List<Intersection>, fillStyle: Color) {
    if (polygon.isNotEmpty()) {
        val path = Path().apply {
            moveTo(polygon[0].point.x.toFloat(), polygon[0].point.y.toFloat())
            for (i in 1 until polygon.size) {
                lineTo(polygon[i].point.x.toFloat(), polygon[i].point.y.toFloat())
            }
            close()
        }
        drawPath(path = path, color = fillStyle)
    }
}