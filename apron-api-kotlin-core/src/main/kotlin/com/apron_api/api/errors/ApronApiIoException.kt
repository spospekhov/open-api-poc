package com.apron_api.api.errors

class ApronApiIoException constructor(message: String? = null, cause: Throwable? = null) :
    ApronApiException(message, cause)
