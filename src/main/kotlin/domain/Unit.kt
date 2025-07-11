package org.example.domain

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure
import kotlinx.serialization.Serializable

@Serializable
class Unit private constructor(
    val aliases: List<String>,
    val conversionTo: Map<String, Double>
) {
    companion object {
        operator fun invoke(
            aliases: List<String>,
            conversionTo: Map<String, String>
        ): Either<Error, Unit> =
            either {
                ensure(aliases.isNotEmpty()) {Error("Aliases cannot be empty") }
                ensure(aliases.all { it.isNotBlank() }) { Error("Aliases cannot contain blank or empty values") }
                ensure(conversionTo.isNotEmpty()) { Error("Conversion map cannot be empty") }
                ensure(conversionTo.values.all { it.toDoubleOrNull() != null }) { Error("Conversion map invalid") }
                Unit(aliases, conversionTo.mapValues { it.value.toDouble() })
            }
    }
}