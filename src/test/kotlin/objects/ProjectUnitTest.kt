package objects

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class ProjectUnitTest : FunSpec() {

    init {
        test("should return true given an iteration falls in the project cycle"){
            val tasks            = listOf<Task>(Story("Allow Users to add items to cart", size = OnePoint),
                                                Story("Integrate with Payment Gateway",   size = TwoPoints)
                                                )

            val iteration1 = Iteration(1, tasks)
            val iteration2 = Iteration(2, tasks)
            val project    = Project(listOf(iteration1, iteration2))

            (iteration1 in project) shouldBe true
        }

        test("should return false given an iteration does not fall in the project cycle"){
            val tasks            = listOf<Task>(Story("Allow Users to add items to cart", size = OnePoint),
                                                Story("Integrate with Payment Gateway",   size = TwoPoints)
                                               )

            val iteration1 = Iteration(1, tasks)
            val iteration2 = Iteration(2, tasks)
            val iteration3 = Iteration(3, tasks)
            val project    = Project(listOf(iteration1, iteration2))

            (iteration3 in project) shouldBe false
        }

        test("should return mapped story field for a given iteration"){
            val tasks1            = listOf<Task>(Story("Allow Users to add items to cart", size = OnePoint),
                                                Story("Integrate with Payment Gateway",   size = TwoPoints)
                                               )

            val tasks2            = listOf<Task>(Story("SendGrid Integration", size = TwoPoints),
                                                Story("Push Notifications",    size = OnePoint)
                                                )

            val iteration1 = Iteration(1, tasks1)
            val iteration2 = Iteration(2, tasks2)
            val project    = Project(listOf(iteration1, iteration2))

            val storyDescriptions = project.mapStoryFieldFor(iteration1, { it.description })

            storyDescriptions shouldBe listOf("Allow Users to add items to cart", "Integrate with Payment Gateway")
        }
    }
}