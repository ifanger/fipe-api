package com.ifanger.domain.repository

import com.ifanger.domain.model.Brand

interface FipeRepository {
    suspend fun getReferenceTableIds(): List<Int>
    suspend fun findAll(referenceTableId: Int): List<Brand>
}