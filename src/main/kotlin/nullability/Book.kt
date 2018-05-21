package nullability

import java.time.LocalDate

class Book(val title: String, val price: Double, private val authors: List<Author>) {

    private var publishedDate: LocalDate? = null

    constructor(title: String, price: Double, authors: List<Author>, publishedDate: LocalDate) : this(title, price, authors) {
        this.publishedDate = publishedDate
    }

    fun isYetToBePublished() = publishedDate == null

    fun isPublished()        = publishedDate != null

    fun distinctAuthorName() = authors.map { it.authorName() }.distinct()

    operator fun component1() = title

    operator fun component2() = price

    override fun toString(): String {
        return "Book(title='$title', price=$price, authors=$authors, publishedDate=$publishedDate)"
    }
}