package coroutine.channel

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.runBlocking

class BasicChannel {
    fun operate(): ArrayList<Int> {
        val channel  = Channel<Int>()
        val sender   = Sender(channel)
        val receiver = Receiver(channel)

        val senderDeferred = async {
            sender.send()
        }

        val receiverDeferred = async {
            receiver.receive()
        }

        return runBlocking {
            senderDeferred.await()
            receiverDeferred.await()
        }
    }
}

class Sender(private val channel: Channel<Int>) {
    suspend fun send() {
        for (v in 1..10) {
            channel.send(v)
        }
    }
}

class Receiver(private val channel: Channel<Int>) {
    suspend fun receive(): ArrayList<Int> {
        val result = arrayListOf<Int>()
        repeat(10) {
            result += channel.receive()
        }
        return result
    }
}