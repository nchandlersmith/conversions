package org.example.domain

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure

class Quantity private constructor (val amount: Double, val unit: String) {
    companion object {
       operator fun invoke(amount: String, unit: String): Either<Error, Quantity> =
           either {
               ensure(amount.isNotEmpty()) { Error("Amount cannot be empty") }
               Quantity(amount.toDouble(), unit)
           }
    }
}
