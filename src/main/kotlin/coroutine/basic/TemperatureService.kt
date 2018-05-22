package coroutine.basic

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import java.util.concurrent.TimeUnit

class TemperatureService {

    fun todaysTemperature(): Deferred<Temperature> {
        return async {
            delay(1, TimeUnit.SECONDS)
            Temperature(24.90)
        }
    }
}

class Temperature(val value: Double)