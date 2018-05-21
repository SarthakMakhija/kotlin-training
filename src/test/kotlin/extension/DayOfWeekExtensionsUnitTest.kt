package extension

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import java.time.DayOfWeek

class DayOfWeekExtensionsUnitTest : FunSpec(){

    init {
        test("should return a range consisting of DayOfWeek"){
            val weekDays = DayOfWeek.MONDAY..DayOfWeek.FRIDAY

            weekDays.contains(DayOfWeek.SATURDAY)  shouldBe false
            weekDays.contains(DayOfWeek.WEDNESDAY) shouldBe true
        }
    }
}