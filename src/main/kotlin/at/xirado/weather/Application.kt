package at.xirado.weather

import at.xirado.weather.plugins.configureRouting
import io.ktor.server.engine.*
import io.ktor.server.cio.*

val config = readConfig()

fun main() {
    val host = config.host
    val port = config.port

    Metrics.init(config)
    embeddedServer(CIO, port = port, host = host) {
        configureRouting()
    }.start(wait = true)
}
