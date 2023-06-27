package flashLight

fun segments(width: Double, height: Double) = listOf(
    // Border
    Segment(Point(0.0,0.0), Point(width,0.0)),
    Segment(Point(width,0.0), Point(width,height)),
    Segment(Point(width,height), Point(0.0,height)),
    Segment(Point(0.0,height), Point(0.0,0.0)),

    // Polygon #1
    Segment(Point(100.0,150.0), Point(120.0,50.0)),
    Segment(Point(120.0,50.0), Point(200.0,80.0)),
    Segment(Point(200.0,80.0), Point(140.0,210.0)),
    Segment(Point(140.0,210.0), Point(100.0,150.0)),

    // Polygon #2
    Segment(Point(100.0,200.0), Point(120.0,250.0)),
    Segment(Point(120.0,250.0), Point(60.0,300.0)),
    Segment(Point(60.0,300.0), Point(100.0,200.0)),

    // Polygon #3
    Segment(Point(200.0,260.0), Point(220.0,150.0)),
    Segment(Point(220.0,150.0), Point(300.0,200.0)),
    Segment(Point(300.0,200.0), Point(350.0,320.0)),
    Segment(Point(350.0,320.0), Point(200.0,260.0)),

    // Polygon #4
    Segment(Point(540.0,60.0), Point(560.0,40.0)),
    Segment(Point(560.0,40.0), Point(570.0,70.0)),
    Segment(Point(570.0,70.0), Point(540.0,60.0)),

    // Polygon #5
    Segment(Point(650.0,190.0), Point(760.0,170.0)),
    Segment(Point(760.0,170.0), Point(740.0,270.0)),
    Segment(Point(740.0,270.0), Point(630.0,290.0)),
    Segment(Point(630.0,290.0), Point(650.0,190.0)),

    // Polygon #6
    Segment(Point(600.0,95.0), Point(780.0,50.0)),
    Segment(Point(780.0,50.0), Point(680.0,150.0)),
    Segment(Point(680.0,150.0), Point(600.0,95.0))
)
