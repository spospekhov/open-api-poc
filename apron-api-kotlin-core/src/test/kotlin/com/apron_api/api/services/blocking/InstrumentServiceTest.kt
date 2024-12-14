// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.services.blocking

import com.apron_api.api.TestServerExtension
import com.apron_api.api.client.okhttp.ApronApiOkHttpClient
import com.apron_api.api.models.InstrumentCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class InstrumentServiceTest {

    @Test
    fun callCreate() {
        val client = ApronApiOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val instrumentService = client.instruments()
        val instrumentCreateResponse =
            instrumentService.create(
                InstrumentCreateParams.builder()
                    .token("token")
                    .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                    .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                    .name("name")
                    .type(InstrumentCreateParams.Type.CARD)
                    .build()
            )
        println(instrumentCreateResponse)
        instrumentCreateResponse.validate()
    }
}
