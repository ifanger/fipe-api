package com.ifanger.application.routes.brand

import com.ifanger.domain.service.BrandService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.async
import org.koin.ktor.ext.inject

fun Route.brandRoute() = route("/v1/brand") {
    val brandService by inject<BrandService>()

    get {
        val result = async { brandService.findAll() }

        call.respond(result.await())
    }

    get("/{id}") {
        call.parameters["id"]?.let { id ->
            call.respondText("Buscando marca $id")
        } ?: call.respond(HttpStatusCode.BadRequest)
    }
}