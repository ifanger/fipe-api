package com.ifanger.application.plugins

import com.ifanger.application.routes.router
import io.ktor.server.application.*

fun Application.configureRouting() {
    router()
}
