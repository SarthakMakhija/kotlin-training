package misc

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class SealedUnitTest : FunSpec() {

    init {
        test("should return sum of 2 expressions") {
            val expression = Expr.Sum(Expr.Num(1), Expr.Num(2))
            val result     = eval(expression)

            result shouldBe 3
        }

        test("should return the value of expression") {
            val expression = Expr.Num(1)
            val result     = eval(expression)

            result shouldBe 1
        }
    }
}