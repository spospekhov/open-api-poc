package com.apron_api.api.errors

import com.google.common.collect.ListMultimap

abstract class ApronApiServiceException
constructor(
    private val headers: ListMultimap<String, String>,
    message: String? = null,
    cause: Throwable? = null
) : ApronApiException(message, cause) {
    abstract fun statusCode(): Int

    fun headers(): ListMultimap<String, String> = headers
}
