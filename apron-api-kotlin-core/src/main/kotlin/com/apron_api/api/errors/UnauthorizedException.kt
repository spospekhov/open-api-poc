package com.apron_api.api.errors

import com.google.common.collect.ListMultimap

class UnauthorizedException
constructor(
    headers: ListMultimap<String, String>,
    private val error: ApronApiError,
) : ApronApiServiceException(headers, "${error}") {
    override fun statusCode(): Int = 401

    fun error(): ApronApiError = error
}
