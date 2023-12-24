package com.ifanger

import com.ifanger.application.di.applicationModules
import com.ifanger.application.plugins.configureHTTP
import com.ifanger.application.plugins.configureRouting
import com.ifanger.application.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureHTTP()
    configureRouting()
    install(Koin) {
        slf4jLogger()
        modules(applicationModules())
    }
}
