package com.ifanger.infrastructure.repository

import com.ifanger.domain.model.Brand
import com.ifanger.domain.repository.FipeRepository
import com.ifanger.infrastructure.http.fipe.FipeClient
import java.util.*

class FipeRepositoryImpl(
    private val fipeClient: FipeClient,
) : FipeRepository {

    override suspend fun getReferenceTableIds(): List<Int> {
        return fipeClient.getReferenceTable().map { it.id }
    }

    override suspend fun findAll(referenceTableId: Int): List<Brand> {
        val now = Date()

        return fipeClient.getBrands(referenceTableId).map {
            Brand(
                id = it.id,
                name = it.name,
                fipeId = it.id,
                lastModified = now,
            )
        }
    }
}