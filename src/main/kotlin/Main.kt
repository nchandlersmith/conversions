package org.example

import kotlinx.serialization.json.Json
import org.example.domain.Conversions
import java.io.File

fun main() {
    val jsonString = File("conversions.json").readText()
    val result = Json.decodeFromString<Conversions>(jsonString)
    println(result.units[0].aliases)
}