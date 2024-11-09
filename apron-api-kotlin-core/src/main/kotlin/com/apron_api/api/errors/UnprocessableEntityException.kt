package com.apron_api.api.errors

import com.apron_api.api.core.http.Headers

class UnprocessableEntityException(
    headers: Headers,
    body: String,
    error: ApronApiError,
) : ApronApiServiceException(422, headers, body, error)
