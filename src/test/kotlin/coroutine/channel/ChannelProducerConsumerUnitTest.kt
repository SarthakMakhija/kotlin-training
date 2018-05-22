package coroutine.channel

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import kotlinx.coroutines.experimental.runBlocking

class ChannelProducerConsumerUnitTest : FunSpec() {

    init {
        test("should return mapped values (-1 from the square of values from 1..5)") {
            val channelProducerConsumer = ChannelProducerConsumer()
            val deferred                = channelProducerConsumer.operate()

            val output = runBlocking {
                deferred.await()
            }

            output shouldBe listOf(0, 3, 8, 15, 24)
        }
    }
}