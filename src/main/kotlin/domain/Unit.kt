package org.example.domain

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure

class Unit private constructor(
    val label: String,
    val tags: List<String>,
    val aliases: List<String>,
    val conversionTo: Map<String, Double>
) {
    companion object {
        operator fun invoke(
            label: String,
            tags: List<String>,
            aliases: List<String>,
            conversionTo: Map<String, Double>
        ): Either<Error, Unit> =
            either {
                ensure(label.isNotBlank()) { Error("Label cannot be empty or blank") }
                Unit(label, tags, aliases, conversionTo)
            }
    }
}