package org.example

import arrow.core.Either
import arrow.core.left
import arrow.core.right

fun parseInt(input: String): Either<String, Int> =
    input.toIntOrNull()?.right() ?: "Invalid number: $input".left()

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Please provide a number")
        return
    }
    val input = args[0]

    val result = parseInt(input)
    when (result) {
        is Either.Left -> println("Error: ${result.value}")
        is Either.Right -> println("Parsed number: ${result.value}")
    }
}