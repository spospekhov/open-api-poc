// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.services.async

import com.apron_api.api.core.RequestOptions
import com.apron_api.api.models.InstrumentCreateParams
import com.apron_api.api.models.InstrumentCreateResponse

interface InstrumentServiceAsync {

    /** Create instrument */
    suspend fun create(
        params: InstrumentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InstrumentCreateResponse
}
