package com.ifanger.domain.service

import com.ifanger.domain.model.Brand
import com.ifanger.domain.repository.FipeRepository

class BrandService(
    private val fipeRepository: FipeRepository,
) {

    suspend fun findAll(): List<Brand> {
        val latestReferenceTableId = fipeRepository.getReferenceTableIds().first()

        return fipeRepository.findAll(latestReferenceTableId)
    }
}