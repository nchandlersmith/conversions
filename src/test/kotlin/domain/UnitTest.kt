package domain

import io.kotest.assertions.arrow.core.shouldBeLeft
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.example.domain.Unit

class UnitTest : StringSpec({
    "should create a Unit with valid parameters" {
        val expectedAliases = listOf("m", "meter")
        val conversionTo = mapOf("cm" to "100.0", "km" to "0.001")
        val expectedConversionTo = mapOf("cm" to 100.0, "km" to 0.001)
        val result = Unit(expectedAliases, conversionTo).shouldBeRight()
        result.aliases shouldBe expectedAliases
        result.conversionTo shouldBe expectedConversionTo
    }
    "should reject empty aliases" {
        val result = Unit(emptyList(), mapOf("cm" to "100.0")).shouldBeLeft()
        result.message shouldBe "Aliases cannot be empty"
    }
    "should reject blank aliases" {
        val result = Unit(listOf(" "), mapOf("cm" to "100.0")).shouldBeLeft()
        result.message shouldBe "Aliases cannot contain blank or empty values"
    }
    "should reject aliases containing empty strings" {
        val result = Unit(listOf(""), mapOf("cm" to "100.0")).shouldBeLeft()
        result.message shouldBe "Aliases cannot contain blank or empty values"
    }
    "should reject empty conversion map" {
        val result = Unit(listOf("m"), emptyMap()).shouldBeLeft()
        result.message shouldBe "Conversion map cannot be empty"
    }
    "should reject invalid conversion map" {
        val conversionMap = mapOf("cm" to "foo")
        val result = Unit(listOf("m"), conversionMap).shouldBeLeft()
        result.message shouldBe "Conversion map invalid"
    }
})