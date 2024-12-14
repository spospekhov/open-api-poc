// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.client

import com.apron_api.api.services.async.InstrumentServiceAsync

interface ApronApiClientAsync {

    fun sync(): ApronApiClient

    fun instruments(): InstrumentServiceAsync
}
