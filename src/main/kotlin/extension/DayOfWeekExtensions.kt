package extension

import java.time.DayOfWeek

operator fun DayOfWeek.rangeTo(to: DayOfWeek) = object: ClosedRange<DayOfWeek>{

    override val start: DayOfWeek
        get() = this@rangeTo

    override val endInclusive: DayOfWeek
        get() = to
}