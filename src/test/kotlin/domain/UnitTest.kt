package domain

import io.kotest.assertions.arrow.core.shouldBeLeft
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.example.domain.Unit

class UnitTest : StringSpec({
    "should create a Unit with valid parameters" {
        val result = Unit("meter", listOf("length"), listOf("m"), mapOf("kilometer" to 0.001)).shouldBeRight()
        result.label shouldBe "meter"
        result.tags shouldBe listOf("length")
        result.aliases shouldBe listOf("m")
        result.conversionTo shouldBe mapOf("kilometer" to 0.001)
    }
    "should reject empty label" {
        val result = Unit("", listOf("length"), listOf("m"), mapOf("kilometer" to 0.001)).shouldBeLeft()
        result.message shouldBe "Label cannot be empty or blank"
    }
    "should reject blank label" {
        val result = Unit("   ", listOf("length"), listOf("m"), mapOf("kilometer" to 0.001)).shouldBeLeft()
        result.message shouldBe "Label cannot be empty or blank"
    }
})