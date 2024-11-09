package com.apron_api.api.errors

import com.apron_api.api.core.http.Headers

class RateLimitException(
    headers: Headers,
    body: String,
    error: ApronApiError,
) : ApronApiServiceException(429, headers, body, error)
