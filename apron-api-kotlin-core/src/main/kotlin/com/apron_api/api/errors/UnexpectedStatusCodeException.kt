package com.apron_api.api.errors

import com.apron_api.api.core.http.Headers

class UnexpectedStatusCodeException(
    statusCode: Int,
    headers: Headers,
    body: String,
    error: ApronApiError,
) : ApronApiServiceException(statusCode, headers, body, error)
