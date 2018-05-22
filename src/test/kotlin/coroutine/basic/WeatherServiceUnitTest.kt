package coroutine.basic

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class WeatherServiceUnitTest : FunSpec() {

    init {
        test("should return weather"){
            val weatherService = WeatherService(HumidityService(), TemperatureService())
            val weather        = weatherService.todaysWeather()

            weather.humidity() shouldBe 12.90
            weather.temperature() shouldBe 24.90
        }
    }
}