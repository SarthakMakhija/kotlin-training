package nullability

class Author(private val firstName: String){

    private var lastName: String? = null

    constructor(firstName: String, lastName: String) : this(firstName) {
        this.lastName = lastName
    }

    fun authorName() = "${this.firstName} ${this.lastName ?: ""}".trim()
}