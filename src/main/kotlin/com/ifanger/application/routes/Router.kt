package com.ifanger.application.routes

import com.ifanger.application.routes.brand.brandRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.router() = routing {
    route("/api") {
        brandRoute()
    }
}