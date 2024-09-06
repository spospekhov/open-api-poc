@file:JvmName("Handlers")

package com.apron_api.api.services

import com.apron_api.api.core.http.BinaryResponseContent
import com.apron_api.api.core.http.HttpResponse
import com.apron_api.api.core.http.HttpResponse.Handler
import com.apron_api.api.errors.ApronApiError
import com.apron_api.api.errors.ApronApiException
import com.apron_api.api.errors.BadRequestException
import com.apron_api.api.errors.InternalServerException
import com.apron_api.api.errors.NotFoundException
import com.apron_api.api.errors.PermissionDeniedException
import com.apron_api.api.errors.RateLimitException
import com.apron_api.api.errors.UnauthorizedException
import com.apron_api.api.errors.UnexpectedStatusCodeException
import com.apron_api.api.errors.UnprocessableEntityException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.io.InputStream
import java.io.OutputStream

internal fun emptyHandler(): Handler<Void?> = EmptyHandler

private object EmptyHandler : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}

internal fun stringHandler(): Handler<String> = StringHandler

internal fun binaryHandler(): Handler<BinaryResponseContent> = BinaryHandler

private object StringHandler : Handler<String> {
    override fun handle(response: HttpResponse): String {
        return response.body().readBytes().toString(Charsets.UTF_8)
    }
}

private object BinaryHandler : Handler<BinaryResponseContent> {
    override fun handle(response: HttpResponse): BinaryResponseContent {
        return object : BinaryResponseContent {
            override fun contentType(): String? =
                response.headers().get("Content-Type").firstOrNull()

            override fun body(): InputStream = response.body()

            override fun close() = response.close()

            override fun writeTo(outputStream: OutputStream) {
                response.body().copyTo(outputStream)
            }
        }
    }
}

internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> {
    return object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            try {
                return jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw ApronApiException("Error reading response", e)
            }
        }
    }
}

internal fun errorHandler(jsonMapper: JsonMapper): Handler<ApronApiError> {
    val handler = jsonHandler<ApronApiError>(jsonMapper)

    return object : Handler<ApronApiError> {
        override fun handle(response: HttpResponse): ApronApiError {
            try {
                return handler.handle(response)
            } catch (e: Exception) {
                return ApronApiError.builder().build()
            }
        }
    }
}

internal fun <T> Handler<T>.withErrorHandler(errorHandler: Handler<ApronApiError>): Handler<T> {
    return object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            when (val statusCode = response.statusCode()) {
                in 200..299 -> return this@withErrorHandler.handle(response)
                400 -> throw BadRequestException(response.headers(), errorHandler.handle(response))
                401 ->
                    throw UnauthorizedException(response.headers(), errorHandler.handle(response))
                403 ->
                    throw PermissionDeniedException(
                        response.headers(),
                        errorHandler.handle(response)
                    )
                404 -> throw NotFoundException(response.headers(), errorHandler.handle(response))
                422 ->
                    throw UnprocessableEntityException(
                        response.headers(),
                        errorHandler.handle(response)
                    )
                429 -> throw RateLimitException(response.headers(), errorHandler.handle(response))
                in 500..599 ->
                    throw InternalServerException(
                        statusCode,
                        response.headers(),
                        errorHandler.handle(response)
                    )
                else ->
                    throw UnexpectedStatusCodeException(
                        statusCode,
                        response.headers(),
                        StringHandler.handle(response)
                    )
            }
        }
    }
}
