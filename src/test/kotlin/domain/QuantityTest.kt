package domain

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
        val result = Quantity("", "kg")
        result.isLeft() shouldBe true
    }
})


