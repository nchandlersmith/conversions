package org.example

import arrow.core.Either
import arrow.core.left
import arrow.core.right

fun parseInt(input: String): Either<String, Int> =
    input.toIntOrNull()?.right() ?: "Invalid number: $input".left()

fun main() {
    print("Enter a number: ")
    val input = readLine() ?: ""

    val result = parseInt(input)
    when (result) {
        is Either.Left -> println("Error: ${result.value}")
        is Either.Right -> println("Parsed number: ${result.value}")
    }
}