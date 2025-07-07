package org.example

import arrow.core.Either
import arrow.core.left
import arrow.core.right

fun parseInt(input: String): Either<String, Int> =
    input.toIntOrNull()?.right() ?: "Invalid number: $input".left()

fun main(args: Array<String>) {
    val input = if (args.isNotEmpty()) {
            args.joinToString(" ")
        } else {
            print("Enter a number: ")
            readLine() ?: ""
        }

    val result = parseInt(input)
    when (result) {
        is Either.Left -> println("Error: ${result.value}")
        is Either.Right -> println("Parsed number: ${result.value}")
    }
}