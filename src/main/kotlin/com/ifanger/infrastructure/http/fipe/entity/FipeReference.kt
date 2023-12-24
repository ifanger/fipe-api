package com.ifanger.infrastructure.http.fipe.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FipeReference(
    @SerialName("Codigo")
    val id: Int,
    @SerialName("Mes")
    val reference: String,
)
