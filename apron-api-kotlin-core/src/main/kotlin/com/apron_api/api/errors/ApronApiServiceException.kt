package com.apron_api.api.errors

import com.apron_api.api.core.http.Headers

abstract class ApronApiServiceException(
    private val statusCode: Int,
    private val headers: Headers,
    private val body: String,
    private val error: ApronApiError,
    message: String = "$statusCode: $error",
    cause: Throwable? = null
) : ApronApiException(message, cause) {

    fun statusCode(): Int = statusCode

    fun headers(): Headers = headers

    fun body(): String = body

    fun error(): ApronApiError = error
}
