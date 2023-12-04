package at.xirado.weather

import io.prometheus.client.Gauge
import io.prometheus.client.exporter.HTTPServer

object Metrics {
    val temperatureOutside: Gauge = Gauge.build("tempf", "Outside temp in Fahrenheit").register()
    val temperatureInside: Gauge = Gauge.build("tempinf", "Inside temp in Fahrenheit").register()

    val humidityOutside: Gauge = Gauge.build("humidity", "Outside humidity in %").register()
    val humidityInside: Gauge = Gauge.build("humidityin", "Inside humidity in %").register()

    fun init(config: Config) {
        HTTPServer(config.prometheusHost, config.prometheusPort, true)
    }
}