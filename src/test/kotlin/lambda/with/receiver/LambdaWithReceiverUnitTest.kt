package lambda.with.receiver

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class LambdaWithReceiverUnitTest : FunSpec() {

    init {
        test("should make String given a lambda"){
            val str = LambdaWithReceiver.makeStringLambda {
                it.append("Hello")
                it.append(" ")
                it.append("World")
            }

            str shouldBe "Hello World"
        }

        test("should make String given a lambda with receiver"){
            val str = LambdaWithReceiver.makeStringLambdaWithReceiver {
                append("Hello")
                append(" ")
                append("World")
            }

            str shouldBe "Hello World"
        }
    }
}
