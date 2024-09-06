// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.services.async

import com.apron_api.api.core.ClientOptions
import com.apron_api.api.core.RequestOptions
import com.apron_api.api.core.http.HttpMethod
import com.apron_api.api.core.http.HttpRequest
import com.apron_api.api.core.http.HttpResponse.Handler
import com.apron_api.api.errors.ApronApiError
import com.apron_api.api.models.InstrumentCreateParams
import com.apron_api.api.models.InstrumentCreateResponse
import com.apron_api.api.services.errorHandler
import com.apron_api.api.services.json
import com.apron_api.api.services.jsonHandler
import com.apron_api.api.services.withErrorHandler

class InstrumentServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : InstrumentServiceAsync {

    private val errorHandler: Handler<ApronApiError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<InstrumentCreateResponse> =
        jsonHandler<InstrumentCreateResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Create instrument */
    override suspend fun create(
        params: InstrumentCreateParams,
        requestOptions: RequestOptions
    ): InstrumentCreateResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("instruments")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
