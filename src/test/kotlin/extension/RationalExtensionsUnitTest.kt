package extension

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class RationalExtensionsUnitTest : FunSpec() {

    init {
        test("should return false given a rational number is not a whole number"){
            val rational = Rational(numerator = 1, denominator = 3)
            rational.isWhole() shouldBe false
        }

        test("should return true given a rational number is a whole number"){
            val rational = Rational(numerator = 5)
            rational.isWhole() shouldBe true
        }

        test("should swap numerator and denominator of a rational number"){
            val rational = Rational(numerator = 4, denominator = 5)
            val swapped  = Rational(numerator = 5, denominator = 4)

            rational.swap() shouldBe swapped
        }
    }
}