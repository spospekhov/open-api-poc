// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.client

import com.apron_api.api.core.ClientOptions
import com.apron_api.api.core.http.HttpResponse.Handler
import com.apron_api.api.errors.ApronApiError
import com.apron_api.api.models.*
import com.apron_api.api.services.blocking.*
import com.apron_api.api.services.errorHandler

class ApronApiClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : ApronApiClient {

    private val errorHandler: Handler<ApronApiError> = errorHandler(clientOptions.jsonMapper)

    private val async: ApronApiClientAsync by lazy { ApronApiClientAsyncImpl(clientOptions) }

    private val instruments: InstrumentService by lazy { InstrumentServiceImpl(clientOptions) }

    override fun async(): ApronApiClientAsync = async

    override fun instruments(): InstrumentService = instruments
}
