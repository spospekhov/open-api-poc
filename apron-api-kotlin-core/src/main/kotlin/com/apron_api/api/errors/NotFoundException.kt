package com.apron_api.api.errors

import com.apron_api.api.core.http.Headers

class NotFoundException(
    headers: Headers,
    body: String,
    error: ApronApiError,
) : ApronApiServiceException(404, headers, body, error)
