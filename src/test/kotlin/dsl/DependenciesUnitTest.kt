package dsl

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class DependenciesUnitTest : FunSpec() {

    init {
        test("should return all compile dependencies") {
            val dependencies = Dependencies()
            dependencies {
                compile("org.jetbrains.kotlin:kotlin-stdlib:1.0.0")
                compile("io.kotlintest:kotlintest-runner-junit5:3.1.0")
            }

            val allCompileDependencies = dependencies.allCompileDependencies()
            allCompileDependencies shouldBe listOf("org.jetbrains.kotlin:kotlin-stdlib:1.0.0", "io.kotlintest:kotlintest-runner-junit5:3.1.0")
        }

        test("should return all testCompile dependencies") {
            val dependencies = Dependencies()
            dependencies {
                compile("org.jetbrains.kotlin:kotlin-stdlib:1.0.0")
                testCompile("io.kotlintest:kotlintest-runner-junit5:3.1.0")
            }

            val allTestCompileDependencies = dependencies.allTestCompileDependencies()
            allTestCompileDependencies shouldBe listOf("io.kotlintest:kotlintest-runner-junit5:3.1.0")
        }

        test("should return all testRuntime dependencies") {
            val dependencies = Dependencies()
            dependencies {
                testRuntime("io.kotlintest:kotlintest-runner-junit5:3.1.0")
            }

            val allTestRuntimeDependencies = dependencies.allTestRuntimeDependencies()
            allTestRuntimeDependencies shouldBe listOf("io.kotlintest:kotlintest-runner-junit5:3.1.0")
        }
    }
}