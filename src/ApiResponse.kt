package com.zestfly.im

import com.google.gson.Gson

class ApiResponse<T>(val errorCode: Int = 0, val errorMessage: String = "ok", val data: T? = null) {

    companion object {
        private val gson = Gson()
    }

    override fun toString(): String {
        return gson.toJson(this)
    }
}