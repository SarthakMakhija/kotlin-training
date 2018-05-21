package misc

object TailRecursion{

    fun factorialTco(value: Int): Int {
        tailrec fun factorial(n: Int, acc: Int): Int =
                if ( n == 1 ) acc else factorial(n - 1, acc * n)
        return  factorial(value, acc = 1)
    }
}