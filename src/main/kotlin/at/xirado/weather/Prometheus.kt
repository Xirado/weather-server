package at.xirado.weather

import io.prometheus.client.Gauge
import io.prometheus.client.exporter.HTTPServer

fun initPrometheus(config: Config) {
    HTTPServer(config.prometheusHost, config.prometheusPort, true)
}

object Metrics {
    val temperatureOutside: Gauge = Gauge.build("tempf", "Outside temp in Fahrenheit").create()
    val temperatureInside: Gauge = Gauge.build("intempf", "Inside temp in Fahrenheit").create()

    val humidityOutside: Gauge = Gauge.build("humidity", "Outside humidity in %").create()
    val humidityInside: Gauge = Gauge.build("humidityin", "Inside humidity in %").create()
}