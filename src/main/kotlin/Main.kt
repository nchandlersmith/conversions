package org.example

import arrow.core.Either
import org.example.domain.Quantity

fun main() {
    print("Enter the amount: ")
    val amountInput = readLine() ?: ""
    print("Enter the unit: ")
    val unitInput = readLine() ?: ""

    when (val result = Quantity(amountInput, unitInput)) {
        is Either.Left -> println("Error: ${result.value}")
        is Either.Right -> println("Parsed number: ${result.value}")
    }
}