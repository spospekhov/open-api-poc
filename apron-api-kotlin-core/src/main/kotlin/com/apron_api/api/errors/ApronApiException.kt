package com.apron_api.api.errors

open class ApronApiException constructor(message: String? = null, cause: Throwable? = null) :
    RuntimeException(message, cause)
