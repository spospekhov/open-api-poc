// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.client

import com.apron_api.api.models.*
import com.apron_api.api.services.async.*

interface ApronApiClientAsync {

    fun sync(): ApronApiClient

    fun instruments(): InstrumentServiceAsync
}
