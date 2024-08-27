// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.client

import com.apron_api.api.core.ClientOptions
import com.apron_api.api.core.http.HttpResponse.Handler
import com.apron_api.api.errors.ApronApiError
import com.apron_api.api.models.*
import com.apron_api.api.services.async.*
import com.apron_api.api.services.errorHandler

class ApronApiClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ApronApiClientAsync {

    private val errorHandler: Handler<ApronApiError> = errorHandler(clientOptions.jsonMapper)

    private val sync: ApronApiClient by lazy { ApronApiClientImpl(clientOptions) }

    private val instruments: InstrumentServiceAsync by lazy {
        InstrumentServiceAsyncImpl(clientOptions)
    }

    override fun sync(): ApronApiClient = sync

    override fun instruments(): InstrumentServiceAsync = instruments
}
