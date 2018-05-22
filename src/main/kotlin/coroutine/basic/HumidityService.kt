package coroutine.basic

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import java.util.concurrent.TimeUnit

class HumidityService {

    fun todaysHumidity(): Deferred<Humidity> {
        return async {
            delay(2, TimeUnit.SECONDS)
            Humidity(12.90)
        }
    }
}

class Humidity(val value: Double)