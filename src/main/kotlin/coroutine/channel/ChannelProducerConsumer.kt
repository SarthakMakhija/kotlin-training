package coroutine.channel

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.produce

class ChannelProducerConsumer {

    fun operate(): Deferred<ArrayList<Int>> {
        val squares = produceSquares()
        val mapped  = mapSquares(squares)

        return async {
            collectSquares(mapped)
        }
    }

    private fun produceSquares(): ReceiveChannel<Int> = produce {
        for (x in 1..5) send(x * x)
    }

    private fun mapSquares(channel: ReceiveChannel<Int>) = produce {
        for (value in channel) send(value - 1)
    }

    private suspend fun collectSquares(channel: ReceiveChannel<Int>): ArrayList<Int> {
        val output = arrayListOf<Int>()
        for (value in channel)
            output += value

        return output
    }
}