package com.ifanger.infrastructure.http.fipe.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FipeBrandRequest(
    @SerialName("codigoTabelaReferencia")
    val referenceTableId: Int,
    @SerialName("codigoTipoVeiculo")
    val vehicleType: Int,
)
