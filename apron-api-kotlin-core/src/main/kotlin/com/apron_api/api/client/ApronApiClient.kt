// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.client

import com.apron_api.api.services.blocking.InstrumentService

interface ApronApiClient {

    fun async(): ApronApiClientAsync

    fun instruments(): InstrumentService
}
