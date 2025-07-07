package org.example.domain

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure

class Quantity private constructor (val amount: Double, val unit: String) {
    companion object {
       operator fun invoke(amount: String, unit: String): Either<Error, Quantity> =
           either {
               ensure(amount.isNotBlank()) { Error("Amount cannot be empty or blank") }
               ensure(amount.matches(Regex("[0-9]+"))) { Error("Invalid number: $amount") }
               ensure(unit.isNotBlank()) { Error("Unit cannot be empty or blank") }
               Quantity(amount.toDouble(), unit)
           }
    }
}
