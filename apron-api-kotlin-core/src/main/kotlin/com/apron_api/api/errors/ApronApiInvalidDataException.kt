package com.apron_api.api.errors

class ApronApiInvalidDataException(message: String? = null, cause: Throwable? = null) :
    ApronApiException(message, cause)
