package misc

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class TailRecursionUnitTest : FunSpec(){

    init {
        test("should return factorial of 1"){
            val factorial = TailRecursion.factorialTco(1)
            factorial shouldBe  1
        }

        test("should return factorial of 5"){
            val factorial = TailRecursion.factorialTco(5)
            factorial shouldBe  120
        }
    }
}