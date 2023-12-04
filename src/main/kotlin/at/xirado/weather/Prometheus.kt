package at.xirado.weather

import io.prometheus.client.Gauge
import io.prometheus.client.exporter.HTTPServer

object Metrics {
    val temperatureOutside: Gauge = Gauge.build("tempf", "Outside temp in Fahrenheit").register()
    val temperatureInside: Gauge = Gauge.build("tempinf", "Inside temp in Fahrenheit").register()

    val humidityOutside: Gauge = Gauge.build("humidity", "Outside humidity in %").register()
    val humidityInside: Gauge = Gauge.build("humidityin", "Inside humidity in %").register()

    val windSpeed: Gauge = Gauge.build("windspeed", "Wind speed in mph").register()
    val windGust: Gauge = Gauge.build("windgust", "Wind gust in mph").register()
    val windDir: Gauge = Gauge.build("winddir", "Wind direction").register()

    val pressureRelative: Gauge = Gauge.build("relpressure", "Relative pressure").register()
    val pressureAbsolute: Gauge = Gauge.build("abspressure", "Absolute pressure").register()

    val rainRateIn: Gauge = Gauge.build("rainratein", "Rain rate").register()
    val eventRainIn: Gauge = Gauge.build("eventrainin", "Rain event").register()

    val solarRadiation: Gauge = Gauge.build("solar", "Solar radiation").register()
    val uv: Gauge = Gauge.build("uv", "UV").register()

    fun init(config: Config) {
        HTTPServer(config.prometheusHost, config.prometheusPort, true)
    }
}