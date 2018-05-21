package operator.overloading

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec


class PointUnitTest : FunSpec() {

    init {
        test("should add 2 points"){
            val point1 = Point(x = 10, y = 20)
            val point2 = Point(x = 20, y = 30)

            val added  = point1 + point2
            added shouldBe Point(x = 30, y = 50)
        }

        test("should multiple a point by a factor"){
            val point   = Point(x = 10, y = 20)
            val result  = point * 5

            result shouldBe Point(x = 50, y = 100)
        }

        test("should perform unary minus"){
            val point    = Point(x = 10, y = 20)
            val negative = -point

            negative shouldBe Point(x = -10, y = -20)
        }
    }
}
