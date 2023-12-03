package at.xirado.weather.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    // Starting point for a Ktor app:
    routing {
        post("/weather") {
            val body = call.receive<String>()

            log.info(body)
            call.respond(HttpStatusCode.OK)
        }
    }
}
