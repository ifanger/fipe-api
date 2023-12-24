package com.ifanger.domain.model

import com.ifanger.infrastructure.http.utils.DateSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Brand(
    val id: String,
    val name: String,
    val fipeId: String,
    @Serializable(DateSerializer::class)
    val lastModified: Date,
)
