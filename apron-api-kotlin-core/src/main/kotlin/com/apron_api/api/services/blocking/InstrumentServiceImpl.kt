// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.services.blocking

import com.apron_api.api.core.ClientOptions
import com.apron_api.api.core.RequestOptions
import com.apron_api.api.core.handlers.errorHandler
import com.apron_api.api.core.handlers.jsonHandler
import com.apron_api.api.core.handlers.withErrorHandler
import com.apron_api.api.core.http.HttpMethod
import com.apron_api.api.core.http.HttpRequest
import com.apron_api.api.core.http.HttpResponse.Handler
import com.apron_api.api.core.json
import com.apron_api.api.errors.ApronApiError
import com.apron_api.api.models.InstrumentCreateParams
import com.apron_api.api.models.InstrumentCreateResponse

class InstrumentServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : InstrumentService {

    private val errorHandler: Handler<ApronApiError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<InstrumentCreateResponse> =
        jsonHandler<InstrumentCreateResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Create instrument */
    override fun create(
        params: InstrumentCreateParams,
        requestOptions: RequestOptions
    ): InstrumentCreateResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("instruments")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
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
