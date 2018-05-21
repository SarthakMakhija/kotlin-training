package operator.overloading

data class Point(val x: Int, val y: Int) {

    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun times(scale: Int): Point {
        return Point((x * scale), (y * scale))
    }

    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }
}