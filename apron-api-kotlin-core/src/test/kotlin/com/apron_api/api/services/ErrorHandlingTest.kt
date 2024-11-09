// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.services

import com.apron_api.api.client.ApronApiClient
import com.apron_api.api.client.okhttp.ApronApiOkHttpClient
import com.apron_api.api.core.JsonString
import com.apron_api.api.core.http.Headers
import com.apron_api.api.core.jsonMapper
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
import com.apron_api.api.models.*
import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.put
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.InstanceOfAssertFactories
import org.assertj.guava.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ErrorHandlingTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private val APRON_API_ERROR: ApronApiError =
        ApronApiError.builder().putAdditionalProperty("key", JsonString.of("value")).build()

    private lateinit var client: ApronApiClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client = ApronApiOkHttpClient.builder().baseUrl(wmRuntimeInfo.getHttpBaseUrl()).build()
    }

    @Test
    fun instrumentsCreate200() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()

        val expected =
            InstrumentCreateResponse.builder()
                .id("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .expirationDate("01/25")
                .lastFour("1111")
                .ownerId("a614b5bd-df6f-4e9f-b9e6-0b9da05ff811")
                .build()

        stubFor(post(anyUrl()).willReturn(ok().withBody(toJson(expected))))

        assertThat(client.instruments().create(params)).isEqualTo(expected)
    }

    @Test
    fun instrumentsCreate400() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(400).withHeader("Foo", "Bar").withBody(toJson(APRON_API_ERROR)))
        )

        assertThatThrownBy({ client.instruments().create(params) })
            .satisfies({ e ->
                assertBadRequest(e, Headers.builder().put("Foo", "Bar").build(), APRON_API_ERROR)
            })
    }

    @Test
    fun instrumentsCreate401() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(401).withHeader("Foo", "Bar").withBody(toJson(APRON_API_ERROR)))
        )

        assertThatThrownBy({ client.instruments().create(params) })
            .satisfies({ e ->
                assertUnauthorized(e, Headers.builder().put("Foo", "Bar").build(), APRON_API_ERROR)
            })
    }

    @Test
    fun instrumentsCreate403() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(403).withHeader("Foo", "Bar").withBody(toJson(APRON_API_ERROR)))
        )

        assertThatThrownBy({ client.instruments().create(params) })
            .satisfies({ e ->
                assertPermissionDenied(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    APRON_API_ERROR
                )
            })
    }

    @Test
    fun instrumentsCreate404() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(404).withHeader("Foo", "Bar").withBody(toJson(APRON_API_ERROR)))
        )

        assertThatThrownBy({ client.instruments().create(params) })
            .satisfies({ e ->
                assertNotFound(e, Headers.builder().put("Foo", "Bar").build(), APRON_API_ERROR)
            })
    }

    @Test
    fun instrumentsCreate422() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(422).withHeader("Foo", "Bar").withBody(toJson(APRON_API_ERROR)))
        )

        assertThatThrownBy({ client.instruments().create(params) })
            .satisfies({ e ->
                assertUnprocessableEntity(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    APRON_API_ERROR
                )
            })
    }

    @Test
    fun instrumentsCreate429() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(429).withHeader("Foo", "Bar").withBody(toJson(APRON_API_ERROR)))
        )

        assertThatThrownBy({ client.instruments().create(params) })
            .satisfies({ e ->
                assertRateLimit(e, Headers.builder().put("Foo", "Bar").build(), APRON_API_ERROR)
            })
    }

    @Test
    fun instrumentsCreate500() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(500).withHeader("Foo", "Bar").withBody(toJson(APRON_API_ERROR)))
        )

        assertThatThrownBy({ client.instruments().create(params) })
            .satisfies({ e ->
                assertInternalServer(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    APRON_API_ERROR
                )
            })
    }

    @Test
    fun unexpectedStatusCode() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(999).withHeader("Foo", "Bar").withBody(toJson(APRON_API_ERROR)))
        )

        assertThatThrownBy({ client.instruments().create(params) })
            .satisfies({ e ->
                assertUnexpectedStatusCodeException(
                    e,
                    999,
                    Headers.builder().put("Foo", "Bar").build(),
                    toJson(APRON_API_ERROR)
                )
            })
    }

    @Test
    fun invalidBody() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()

        stubFor(post(anyUrl()).willReturn(status(200).withBody("Not JSON")))

        assertThatThrownBy({ client.instruments().create(params) })
            .satisfies({ e ->
                assertThat(e)
                    .isInstanceOf(ApronApiException::class.java)
                    .hasMessage("Error reading response")
            })
    }

    @Test
    fun invalidErrorBody() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()

        stubFor(post(anyUrl()).willReturn(status(400).withBody("Not JSON")))

        assertThatThrownBy({ client.instruments().create(params) })
            .satisfies({ e ->
                assertBadRequest(e, Headers.builder().build(), ApronApiError.builder().build())
            })
    }

    private fun <T> toJson(body: T): ByteArray {
        return JSON_MAPPER.writeValueAsBytes(body)
    }

    private fun assertUnexpectedStatusCodeException(
        throwable: Throwable,
        statusCode: Int,
        headers: Headers,
        responseBody: ByteArray
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnexpectedStatusCodeException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(statusCode)
                assertThat(e.body()).isEqualTo(String(responseBody))
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertBadRequest(throwable: Throwable, headers: Headers, error: ApronApiError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(BadRequestException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(400)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertUnauthorized(throwable: Throwable, headers: Headers, error: ApronApiError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(UnauthorizedException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(401)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertPermissionDenied(
        throwable: Throwable,
        headers: Headers,
        error: ApronApiError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(PermissionDeniedException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(403)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertNotFound(throwable: Throwable, headers: Headers, error: ApronApiError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(NotFoundException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(404)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertUnprocessableEntity(
        throwable: Throwable,
        headers: Headers,
        error: ApronApiError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnprocessableEntityException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(422)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertRateLimit(throwable: Throwable, headers: Headers, error: ApronApiError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(RateLimitException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(429)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertInternalServer(throwable: Throwable, headers: Headers, error: ApronApiError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(InternalServerException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(500)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
