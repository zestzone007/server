package com.zestfly.im

import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
//    install(ContentNegotiation){
//        gson{}
//    }
    routing {
        get("/") {
            call.respondText("Hello World!", ContentType.Text.Plain)
        }
        get("/register") {
            val parameters = call.parameters
            val name = parameters["name"]
            if (name.isNullOrEmpty()) {
                val apiResponse = ApiResponse<LoginBean>(errorCode = 1, errorMessage = "name null or empty !")
                call.respondText(apiResponse.toString())
            } else {
                if (name.isBlank()) {
                    val apiResponse =
                        ApiResponse<LoginBean>(errorCode = 1, errorMessage = "name is blank string")
                    call.respondText(apiResponse.toString())
                } else {
                    val password = parameters["password"]
                    val email = parameters["email"]
                    val apiResponse = ApiResponse<LoginBean>()
                    call.respondText(apiResponse.toString())
                }
            }
        }
    }
}

