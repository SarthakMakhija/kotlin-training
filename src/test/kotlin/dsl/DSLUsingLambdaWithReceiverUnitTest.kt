package dsl

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class DSLUsingLambdaWithReceiverUnitTest : FunSpec() {

    init {
        test("should return all compile dependencies") {
            val dependencies = dependencies {
                compile("org.jetbrains.kotlin:kotlin-stdlib:1.0.0")
            }

            val compileDependencies = dependencies.allCompileDependencies()
            compileDependencies shouldBe listOf("org.jetbrains.kotlin:kotlin-stdlib:1.0.0")
        }
    }
}