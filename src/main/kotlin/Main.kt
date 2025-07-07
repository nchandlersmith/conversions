package org.example

import arrow.core.Either
import arrow.core.left
import arrow.core.right

fun main() {
    print("Enter the amount: ")
    val amountInput = readLine() ?: ""
    print("Enter the unit: ")
    val unitInput = readLine() ?: ""
    print("Enter the conversion unit: ")
    val conversionUnitInput = readLine() ?: ""

    val result: Either<String, Double> = when {
        unitInput.equals("feet", ignoreCase = true) -> {
            amountInput.toDoubleOrNull()?.let { (it * 12).right() }
                ?: "Invalid number: $amountInput".left()
        }
        !unitInput.equals("feet", ignoreCase = true) && !conversionUnitInput.equals("inches", ignoreCase = true) -> {
            "Unsupported conversion: $unitInput to $conversionUnitInput".left()
        }
        else -> {
            amountInput.toDoubleOrNull()?.right() ?: "Invalid number: $amountInput".left()
        }
    }
    when (result) {
        is Either.Left -> println("Error: ${result.value}")
        is Either.Right -> println("Parsed number: ${result.value}")
    }
}