package nullability

class Library(val books: List<Book>) {

    inline fun allBooksBy(predicate: (Book) -> Boolean) = books.filter(predicate)

    fun allBooksBy(predicates: List<(Book) -> Boolean>): List<Book> {
        val filteredBooks = arrayListOf<Book>()
        books.forEach book@ { book ->
            predicates.forEach predicate@ {
                predicate ->
                if (!predicate.invoke(book)) {
                    return@book
                }
            }
            filteredBooks += book
        }
        return filteredBooks
    }

    fun publishedBooks()      = books.asSequence().filter(Book::isPublished).toList()

    fun unpublishedBooks()    = books.filter(Book::isYetToBePublished)

    fun distinctAuthorNames() = books.flatMap{ it.distinctAuthorName() }
}

/**
 * Tasks:
 * (1). can allBooksBy be inline?
 */