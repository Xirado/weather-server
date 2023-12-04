package at.xirado.weather.plugins

import at.xirado.weather.Metrics
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    // Starting point for a Ktor app:
    routing {
        post("/weather") {
            val body = call.receiveParameters()

            body["tempf"]?.let { Metrics.temperatureOutside.set(it.toDouble()) }
            body["intempf"]?.let { Metrics.temperatureInside.set(it.toDouble()) }

            body["humidity"]?.let { Metrics.humidityOutside.set(it.toDouble()) }
            body["humidityin"]?.let { Metrics.humidityInside.set(it.toDouble()) }

            call.respond(HttpStatusCode.OK)
        }
    }
}
