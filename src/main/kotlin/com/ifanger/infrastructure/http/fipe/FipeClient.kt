package com.ifanger.infrastructure.http.fipe

import com.ifanger.infrastructure.http.ApplicationClients
import com.ifanger.infrastructure.http.fipe.entity.FipeBrand
import com.ifanger.infrastructure.http.fipe.entity.FipeBrandRequest
import com.ifanger.infrastructure.http.fipe.entity.FipeReference
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named

class FipeClient : KoinComponent {

    private val client: HttpClient by inject(named(ApplicationClients.FIPE))

    suspend fun getReferenceTable(): List<FipeReference> {
        val response = client.post("ConsultarTabelaDeReferencia")
        return response.body()
    }

    suspend fun getBrands(referenceTableId: Int): List<FipeBrand> {
        val response = client.post("ConsultarMarcas") {
            setBody(FipeBrandRequest(referenceTableId = referenceTableId, vehicleType = 1))
        }
        return response.body()
    }
}