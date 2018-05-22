package coroutine.channel

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class BasicChannelUnitTest : FunSpec() {

    init {
        test("should return the values produced by sender in channel") {
            val basicChannel = BasicChannel()
            val output       = basicChannel.operate()

            output shouldBe listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        }
    }
}