package introduction

import java.time.DayOfWeek
import java.time.LocalDate

fun welcomeMessage() = "Welcome to Kotlin"

fun welcomeGreetingMessage(name: String) = "Welcome $name"

fun sumOf(range: IntRange) = range.sum()

fun makeString(values: List<String>, separator: String = ","): String {
    val sb   = StringBuilder()
    val size = values.size

    for ( (index, value) in values.withIndex() ){
        if ( index == size - 1 )
            sb.append(value)
        else
            sb.append(value).append(separator)
    }
    return sb.toString()
}

fun isWeekDay(date: LocalDate) = when (date.dayOfWeek) {
    DayOfWeek.MONDAY    -> true
    DayOfWeek.TUESDAY   -> true
    DayOfWeek.WEDNESDAY -> true
    DayOfWeek.THURSDAY  -> true
    DayOfWeek.FRIDAY    -> true
    else                -> false
}