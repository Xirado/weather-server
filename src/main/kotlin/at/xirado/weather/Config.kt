package at.xirado.weather

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

val json = Json {
    ignoreUnknownKeys = true
}

@Serializable
data class Config(
    val host: String,
    val port: Int,
)

fun readConfig(): Config {
    val file = File("config.json")

    if (!file.exists())
        throw IllegalStateException("Missing config.json!")

    return json.decodeFromString(file.readText())
}