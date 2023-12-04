package at.xirado.weather

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

val json = Json {
    ignoreUnknownKeys = true
}

@Serializable
data class Config(
    val host: String = "0.0.0.0",
    val port: Int = 6060,
    val prometheusHost: String = "0.0.0.0",
    val prometheusPort: Int = 5123,
)

fun readConfig(): Config {
    val file = File("config.json")

    if (!file.exists())
        throw IllegalStateException("Missing config.json!")

    return json.decodeFromString(file.readText())
}