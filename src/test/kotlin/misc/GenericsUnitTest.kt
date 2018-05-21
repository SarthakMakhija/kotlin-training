package misc

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class GenericsUnitTest : FunSpec() {

    init {
        test("should return comma separated string representation"){
            val names                = listOf("John", "Martin", "Flower")
            val stringRepresentation = names.makeString(separator = ","){
                it
            }

            stringRepresentation shouldBe "John,Martin,Flower"
        }

        test("should return custom separator separated string representation"){
            val names                = listOf("John", "Martin", "Flower")
            val stringRepresentation = names.makeString(separator = ", "){
                it
            }

            stringRepresentation shouldBe "John, Martin, Flower"
        }
    }
}