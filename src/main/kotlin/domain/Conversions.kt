package org.example.domain

import kotlinx.serialization.Serializable

@Serializable
data class Conversions(
    val units: List<UnitDeserializable>
)