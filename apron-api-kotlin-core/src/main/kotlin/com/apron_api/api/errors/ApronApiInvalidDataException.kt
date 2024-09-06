package com.apron_api.api.errors

class ApronApiInvalidDataException constructor(message: String? = null, cause: Throwable? = null) :
    ApronApiException(message, cause)
