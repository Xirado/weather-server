package at.xirado.weather.plugins

import at.xirado.weather.Metrics
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        post("/weather") {
            val body = call.receiveParameters()
            body["tempf"]?.let { Metrics.temperatureOutside.set(it.toDouble()) }
            body["tempinf"]?.let { Metrics.temperatureInside.set(it.toDouble()) }

            body["humidity"]?.let { Metrics.humidityOutside.set(it.toDouble()) }
            body["humidityin"]?.let { Metrics.humidityInside.set(it.toDouble()) }

            body["windspeedmph"]?.let { Metrics.windSpeed.set(it.toDouble()) }
            body["windgustmph"]?.let { Metrics.windGust.set(it.toDouble()) }
            body["winddir"]?.let { Metrics.windDir.set(it.toDouble()) }

            body["baromrelin"]?.let { Metrics.pressureRelative.set(it.toDouble()) }
            body["baromabsin"]?.let { Metrics.pressureAbsolute.set(it.toDouble()) }

            body["rainratein"]?.let { Metrics.rainRateIn.set(it.toDouble()) }
            body["eventrainin"]?.let { Metrics.eventRainIn.set(it.toDouble()) }

            body["solarradiation"]?.let { Metrics.solarRadiation.set(it.toDouble()) }
            body["uv"]?.let { Metrics.uv.set(it.toDouble()) }

            call.respond(HttpStatusCode.OK)
        }
    }
}
