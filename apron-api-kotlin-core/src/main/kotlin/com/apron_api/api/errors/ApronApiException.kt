package com.apron_api.api.errors

open class ApronApiException(message: String? = null, cause: Throwable? = null) :
    RuntimeException(message, cause)
