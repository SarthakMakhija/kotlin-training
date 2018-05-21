package introduction

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import java.time.LocalDate
import java.time.Month

class IntroductionUnitTest : FunSpec() {

    init {
        test("should return a welcome message") {
            val welcomeMessage = welcomeMessage()
            welcomeMessage shouldBe "Welcome to Kotlin"
        }

        test("should return a welcome greeting message") {
            val welcomeMessage = welcomeGreetingMessage("Hyderabad")
            welcomeMessage shouldBe "Welcome Hyderabad"
        }

        test("should return sum of IntRange") {
            val range = 1..10
            val sum   = sumOf(range)
            sum shouldBe 55
        }

        test("return return false given day is not a weekday") {
            val date      = LocalDate.of(2018, Month.MAY, 20)
            val isWeekDay = isWeekDay(date)
            isWeekDay shouldBe false
        }

        test("should return comma separated string representation"){
            val names = listOf("John", "Martin", "Flower")
            makeString(names) shouldBe "John,Martin,Flower"
        }

        test("should return custom separator separated string representation"){
            val names = listOf("John", "Martin", "Flower")
            makeString(values = names, separator = ", ") shouldBe "John, Martin, Flower"
        }
    }
}