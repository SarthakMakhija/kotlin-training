package misc

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import extension.Rational

class InfixUnitTest : FunSpec() {

    init {
        test("should add 2 rational numbers") {
            val rational1 = Rational(1, 3)
            val rational2 = Rational(1, 2)
            val expected  = Rational(5, 6)

            val added = rational1 add rational2

            added shouldBe expected
        }
    }
}