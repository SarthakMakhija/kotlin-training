package coroutine.basic

import kotlinx.coroutines.experimental.runBlocking

class WeatherService(private val humidityService: HumidityService, private val temperatureService: TemperatureService) {

    fun todaysWeather(): Weather {
        val humidity    = humidityService.todaysHumidity()
        val temperature = temperatureService.todaysTemperature()

        return runBlocking {
            Weather(humidity.await(), temperature.await())
        }
    }
}

class Weather(private val humidity: Humidity, private val temperature: Temperature){

    fun humidity()    = humidity.value
    fun temperature() = temperature.value
}