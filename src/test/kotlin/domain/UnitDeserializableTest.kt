package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.example.domain.UnitDeserializable

class UnitDeserializableTest : StringSpec({
    "UnitDeserializable deserialization" {
        val json = """
            {
                "aliases": ["meter", "m"],
                "conversionTo": {
                    "kilometer": "0.001",
                    "centimeter": "100"
                }
            }
        """.trimIndent()

        val unit = kotlinx.serialization.json.Json.decodeFromString<UnitDeserializable>(json)

        unit.aliases shouldBe listOf("meter", "m")
        unit.conversionTo shouldBe mapOf("kilometer" to "0.001", "centimeter" to "100")
    }
})
