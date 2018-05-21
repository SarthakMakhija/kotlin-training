package nullability

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import java.time.LocalDate

class LibraryUnitTest : FunSpec() {

    init {
        val robertMartin        = Author(firstName = "Robert C Martin")
        val martinFowler        = Author(firstName = "Martin",  lastName = "Fowler")
        val jayFields           = Author(firstName = "Jay",     lastName = "Fields")
        val michaelFeathers     = Author(firstName = "Michael", lastName = "Feathers")

        val cleanCode     = Book(title = "Clean Code",                           price = 180.0, authors = listOf(robertMartin),     publishedDate  = LocalDate.now())
        val refactoring   = Book(title = "Refactoring",                          price = 280.0, authors = listOf(martinFowler),     publishedDate  = LocalDate.now())
        val unitTest      = Book(title = "Effective Unit Tests",                 price = 380.0, authors = listOf(jayFields))
        val legacyCode    = Book(title = "Working Effectively with Legacy Code", price = 480.0, authors = listOf(michaelFeathers),  publishedDate  = LocalDate.now())

        val library       = Library(listOf(cleanCode, refactoring, unitTest, legacyCode))

        test("should return all books by title in library") {
            val cleanCodeBooks = library.allBooksBy { it.title == "Clean Code" }
            cleanCodeBooks shouldBe listOf(cleanCode)
        }

        test("should return all books by price in library") {
            val unit           = library.allBooksBy { it.price == 380.0 }.first()
            val (title, price) = unit

            title shouldBe "Effective Unit Tests"
            price shouldBe 380.0
        }

        test("should return unpublished books"){
            val unpublishedBooks = library.unpublishedBooks()
            unpublishedBooks shouldBe listOf(unitTest)
        }

        test("should return published books"){
            val publishedBooks   = library.publishedBooks()
            publishedBooks shouldBe listOf(cleanCode, refactoring, legacyCode)
        }

        test("should return distinctAuthorNames"){
            val authorNames = library.distinctAuthorNames()
            authorNames shouldBe listOf("Robert C Martin", "Martin Fowler", "Jay Fields", "Michael Feathers")
        }

        test("should return allBooksBy multiple predicates"){
            val predicateByBookTitle:  (Book) -> Boolean  = { it.title == "Refactoring" }
            val predicateByPriceRange: (Book) -> Boolean  = { it.price in 200.0..400.0}
            val predicates                                = listOf(predicateByBookTitle, predicateByPriceRange)

            val allBooksBy = library.allBooksBy(predicates)
            allBooksBy shouldBe listOf(refactoring)
        }

        test("should return 0 books not matching multiple predicates"){
            val predicateByBookTitle:  (Book) -> Boolean  = { it.title == "Clean Code" }
            val predicateByPriceRange: (Book) -> Boolean  = { it.price in 100.0..150.0}
            val predicates                                = listOf(predicateByBookTitle, predicateByPriceRange)

            val allBooksBy = library.allBooksBy(predicates)
            allBooksBy.size shouldBe 0
        }
    }
}