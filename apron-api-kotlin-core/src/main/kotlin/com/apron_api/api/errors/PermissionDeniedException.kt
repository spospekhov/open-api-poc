package com.apron_api.api.errors

import com.apron_api.api.core.http.Headers

class PermissionDeniedException(
    headers: Headers,
    body: String,
    error: ApronApiError,
) : ApronApiServiceException(403, headers, body, error)
