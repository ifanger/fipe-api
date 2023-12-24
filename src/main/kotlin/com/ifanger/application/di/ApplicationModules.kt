package com.ifanger.application.di

import com.ifanger.domain.repository.FipeRepository
import com.ifanger.domain.service.BrandService
import com.ifanger.infrastructure.http.ApplicationClients
import com.ifanger.infrastructure.http.fipe.FipeClient
import com.ifanger.infrastructure.repository.FipeRepositoryImpl
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.cache.storage.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.nio.file.Files
import java.nio.file.Paths

fun applicationModules() = module {
    single(named(ApplicationClients.FIPE)) {
        HttpClient(CIO) {
            expectSuccess = true
            defaultRequest {
                contentType(ContentType.parse("application/json"))
                url("https://veiculos.fipe.org.br/api/veiculos/")
            }
            install(ContentNegotiation) {
                json()
            }
            install(HttpCache) {
                val cacheFile = Files.createDirectories(Paths.get("build/cache")).toFile()
                publicStorage(FileStorage(cacheFile))
            }
        }
    }

    // Data Source
    factoryOf(::FipeClient)

    // Repository
    single<FipeRepository> { FipeRepositoryImpl(get()) }

    // Service
    factoryOf(::BrandService)
}