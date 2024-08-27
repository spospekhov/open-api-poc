package com.apron_api.api.errors

import com.google.common.collect.ListMultimap

class InternalServerException
constructor(
    private val statusCode: Int,
    headers: ListMultimap<String, String>,
    private val error: ApronApiError,
) : ApronApiServiceException(headers, "${error}") {
    override fun statusCode(): Int = statusCode

    fun error(): ApronApiError = error
}
