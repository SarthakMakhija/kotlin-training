package dsl

class Greeter(val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting $name")
    }
}

fun main(args: Array<String>) {
    val greeter = Greeter(greeting = "Welcome")
    greeter(name = "Kotlin")
}