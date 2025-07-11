package org.example.domain

import kotlinx.serialization.Serializable

@Serializable
data class UnitDeserializable(
    val aliases: List<String>,
    val conversionTo: Map<String, String>
)
