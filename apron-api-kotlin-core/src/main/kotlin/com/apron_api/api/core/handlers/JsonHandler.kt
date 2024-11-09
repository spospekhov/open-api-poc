@file:JvmName("JsonHandler")

package com.apron_api.api.core.handlers

import com.apron_api.api.core.http.HttpResponse
import com.apron_api.api.core.http.HttpResponse.Handler
import com.apron_api.api.errors.ApronApiException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            try {
                return jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw ApronApiException("Error reading response", e)
            }
        }
    }
