object Lambda {
    val add: (Int, Int) -> Int = { addend, augend -> addend + augend }

    private val persons = listOf(Person("John"), Person("Smith"), Person("David"))

    fun filterPerson(fn: (Person) -> Boolean) = persons.filter(fn)

    data class Person(val name: String)
}

