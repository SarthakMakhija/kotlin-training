package operator

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import extension.Rational

class OperatorUnitTest : FunSpec() {

    init {
        test("should add 2 rational numbers") {
            val rational1 = Rational(1, 3)
            val rational2 = Rational(1, 2)
            val expected  = Rational(5, 6)

            val added = rational1 + rational2

            added shouldBe expected
        }

        test("should multiplye rational by a given value") {
            val rational  = Rational(1, 3)
            val expected  = Rational(4, 3)

            val multiplied = rational * 4

            multiplied shouldBe expected
        }
    }
}