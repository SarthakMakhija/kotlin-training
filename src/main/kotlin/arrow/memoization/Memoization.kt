package arrow.memoization

import arrow.syntax.function.memoize
import kotlin.system.measureTimeMillis

object Memoization {

    fun recursiveFib(n: Long): Long = if (n < 2) n else recursiveFib(n - 1) + recursiveFib(n - 2)

    fun memoization(n : Long): Long {

        var memoizedFib: (Long) -> Long = { it }
        memoizedFib = { n: Long -> if (n < 2) n else memoizedFib(n - 1) + memoizedFib(n - 2) }.memoize()

        return memoizedFib(n)
    }
}

fun main(args: Array<String>){


    println(measureTimeMillis { Memoization.recursiveFib(n = 40) })
    println(measureTimeMillis { Memoization.memoization(n = 40) })
}