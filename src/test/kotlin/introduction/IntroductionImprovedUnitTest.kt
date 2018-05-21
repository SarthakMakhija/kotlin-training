package introduction

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import java.time.LocalDate
import java.time.Month

class IntroductionImproved : FunSpec() {

    init {
        test("return return false given day is not a weekday") {
            val date      = LocalDate.of(2018, Month.MAY, 20)
            val isWeekDay = isWeekDayImproved(date)
            isWeekDay shouldBe false
        }

        test("should return comma separated string representation"){
            val names = listOf("John", "Martin", "Flower")
            makeStringImproved(names) shouldBe "John,Martin,Flower"
        }

        test("should return custom separator separated string representation"){
            val names = listOf("John", "Martin", "Flower")
            makeStringImproved(values = names, separator = ", ") shouldBe "John, Martin, Flower"
        }
    }
}