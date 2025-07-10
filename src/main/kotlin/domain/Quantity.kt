package org.example.domain

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure
import org.example.exception.QuantityCreationException

class Quantity private constructor(val amount: Double, val unit: String) {
    companion object {
        operator fun invoke(amount: String, unit: String): Either<QuantityCreationException, Quantity> =
            either {
                ensure(amount.isNotBlank()) { QuantityCreationException("Amount cannot be empty or blank") }
                ensure(amount.matches(Regex("[0-9]+"))) { QuantityCreationException("Invalid number: $amount") }
                ensure(unit.isNotBlank()) { QuantityCreationException("Unit cannot be empty or blank") }
                Quantity(amount.toDouble(), unit)
            }
    }
}
