package lambda

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class LambdaUnitTest : FunSpec() {

    init {
        test("should add 2 numbers") {
            val result = Lambda.add(2, 3)
            result shouldBe 5
        }

        test("should return all persons") {
            val persons = Lambda.filterPerson { true }
            val expected = listOf(Lambda.Person("John"), Lambda.Person("Smith"), Lambda.Person("David"))

            persons shouldBe expected
        }

        test("should return persons where name = John") {
            val persons = Lambda.filterPerson(fun(person: Lambda.Person): Boolean {
                return person.name.toLowerCase() == "john"
            })
            val expected = listOf(Lambda.Person("John"))

            persons shouldBe expected
        }
    }
}