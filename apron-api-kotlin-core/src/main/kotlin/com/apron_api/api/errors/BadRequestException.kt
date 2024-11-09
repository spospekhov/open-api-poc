package com.apron_api.api.errors

import com.apron_api.api.core.http.Headers

class BadRequestException(
    headers: Headers,
    body: String,
    error: ApronApiError,
) : ApronApiServiceException(400, headers, body, error)
