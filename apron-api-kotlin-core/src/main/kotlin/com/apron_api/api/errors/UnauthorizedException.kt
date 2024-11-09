package com.apron_api.api.errors

import com.apron_api.api.core.http.Headers

class UnauthorizedException(
    headers: Headers,
    body: String,
    error: ApronApiError,
) : ApronApiServiceException(401, headers, body, error)
