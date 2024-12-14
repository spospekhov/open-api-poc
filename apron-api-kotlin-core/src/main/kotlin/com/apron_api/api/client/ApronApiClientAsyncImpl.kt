// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.client

import com.apron_api.api.core.ClientOptions
import com.apron_api.api.core.getPackageVersion
import com.apron_api.api.services.async.InstrumentServiceAsync
import com.apron_api.api.services.async.InstrumentServiceAsyncImpl

class ApronApiClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ApronApiClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: ApronApiClient by lazy { ApronApiClientImpl(clientOptions) }

    private val instruments: InstrumentServiceAsync by lazy {
        InstrumentServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): ApronApiClient = sync

    override fun instruments(): InstrumentServiceAsync = instruments
}
