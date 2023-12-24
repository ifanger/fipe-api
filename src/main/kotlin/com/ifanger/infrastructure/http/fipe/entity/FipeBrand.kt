package com.ifanger.infrastructure.http.fipe.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FipeBrand(
    @SerialName("Value")
    val id: String,
    @SerialName("Label")
    val name: String,
)
