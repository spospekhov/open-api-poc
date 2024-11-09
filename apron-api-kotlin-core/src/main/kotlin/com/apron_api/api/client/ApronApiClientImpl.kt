// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.client

import com.apron_api.api.core.ClientOptions
import com.apron_api.api.core.getPackageVersion
import com.apron_api.api.models.*
import com.apron_api.api.services.blocking.*

class ApronApiClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : ApronApiClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: ApronApiClientAsync by lazy { ApronApiClientAsyncImpl(clientOptions) }

    private val instruments: InstrumentService by lazy {
        InstrumentServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): ApronApiClientAsync = async

    override fun instruments(): InstrumentService = instruments
}
