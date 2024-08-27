package com.apron_api.api.errors

import com.google.common.collect.ListMultimap

class UnprocessableEntityException
constructor(
    headers: ListMultimap<String, String>,
    private val error: ApronApiError,
) : ApronApiServiceException(headers, "${error}") {
    override fun statusCode(): Int = 422

    fun error(): ApronApiError = error
}
