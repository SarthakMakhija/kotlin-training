package objects

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class IterationUnitTest : FunSpec() {

    init {
        test("should return 0 spikes in an iteration"){
            val tasks            = listOf<Task>(Story("Allow Users to add items to cart", size = OnePoint),
                                                Story("Integrate with Payment Gateway", size = TwoPoints)
                                               )
            val currentIteration = Iteration(1, tasks)
            val totalSpikes      = currentIteration.totalSpikes()

            totalSpikes shouldBe 0
        }

        test("should return total spikes in an iteration"){
            val tasks            = listOf(Story("Allow Users to add items to cart", size = OnePoint),
                                          Story("Integrate with Payment Gateway", size = TwoPoints),
                                          Story("Integration with SendGrid", size = FourPoints),
                                          Spike("SAML Authentication")
                                         )
            val currentIteration = Iteration(1, tasks)
            val totalSpikes      = currentIteration.totalSpikes()

            totalSpikes shouldBe 1
        }

        test("should return stories by size"){
            val addItemsToCart              = Story("Allow Users to add items to cart", size = OnePoint)
            val paymentGatewayIntegration   = Story("Integrate with Payment Gateway",   size = TwoPoints)
            val sendGridIntegration         = Story("Integration with SendGrid",        size = FourPoints)
            val samlAuthentication          = Spike("SAML Authentication")
            val paymentUsingPaytm           = Story("Allow users to pay by Paytm Wallet", size = TwoPoints)

            val tasks            = listOf(addItemsToCart, paymentGatewayIntegration, sendGridIntegration, samlAuthentication, paymentUsingPaytm)
            val expected         = mapOf(OnePoint   to listOf(addItemsToCart),
                                         TwoPoints  to listOf(paymentGatewayIntegration, paymentUsingPaytm),
                                         FourPoints to listOf(sendGridIntegration)
                                        )
            val currentIteration = Iteration(1, tasks)
            val storiesBySize    = currentIteration.storiesBySize()

            storiesBySize shouldBe expected
        }

        test("should return all 1 pointer stories"){
            val tasks            = listOf(Story("Allow Users to add items to cart", size = OnePoint),
                                          Story("Integrate with Payment Gateway", size = TwoPoints),
                                          Story("Integration with SendGrid", size = FourPoints),
                                          Spike("SAML Authentication")
            )
            val currentIteration        = Iteration(1, tasks)
            val allOnePointerStories    = currentIteration.filterStoriesBy { it.size == OnePoint }

            allOnePointerStories shouldBe listOf(Story("Allow Users to add items to cart", size = OnePoint))
        }

        test("should return a single 1 pointer story"){
            val tasks            = listOf(Story("Allow Users to add items to cart", size = OnePoint),
                                          Story("Integrate with Payment Gateway", size = TwoPoints),
                                          Story("Integration with SendGrid", size = FourPoints),
                                          Spike("SAML Authentication")
                                         )
            val currentIteration   = Iteration(1, tasks)
            val onePointerStory    = currentIteration.filterStoriesBy { it.size == OnePoint }.first()

            val (description, size) = onePointerStory

            description shouldBe "Allow Users to add items to cart"
            size        shouldBe OnePoint
        }
    }
}