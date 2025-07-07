package domain

import io.kotest.assertions.arrow.core.shouldBeLeft
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.example.domain.Quantity


class QuantityTest : StringSpec({
    "should create a Quantity from strings" {
        val result = Quantity("10", "kg").shouldBeRight()
        result.amount shouldBe 10.0
        result.unit shouldBe "kg"
    }
    "should reject empty amount" {
        val result = Quantity("", "kg").shouldBeLeft()
        result.message shouldBe "Amount cannot be empty"
    }
    "should reject empty unit" {
        val result = Quantity("6", "").shouldBeLeft()
        result.message shouldBe "Unit cannot be empty"
    }
})


