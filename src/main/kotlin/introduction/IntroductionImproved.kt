package introduction

import extension.rangeTo
import java.time.DayOfWeek
import java.time.LocalDate

fun isWeekDayImproved(date: LocalDate) = when (date.dayOfWeek) {
    in DayOfWeek.MONDAY..DayOfWeek.FRIDAY -> true
    else                                  -> false
}

fun makeStringImproved(values: List<String>, separator: String = ","): String =
        StringBuilder().apply {
            for ((index, value) in values.withIndex()) {
                if (index == values.lastIndex)
                    append(value)
                else
                    append(value).append(separator)
            }
        }.toString()