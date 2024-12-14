// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InstrumentCreateParamsTest {

    @Test
    fun createInstrumentCreateParams() {
        InstrumentCreateParams.builder()
            .token("token")
            .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
            .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
            .name("name")
            .type(InstrumentCreateParams.Type.CARD)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            InstrumentCreateParams.builder()
                .token("token")
                .accountId("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
                .companyId("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .name("name")
                .type(InstrumentCreateParams.Type.CARD)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.token()).isEqualTo("token")
        assertThat(body.accountId()).isEqualTo("69c10e3a-d901-4c0c-8312-ce2df2ec2457")
        assertThat(body.companyId()).isEqualTo("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
        assertThat(body.name()).isEqualTo("name")
        assertThat(body.type()).isEqualTo(InstrumentCreateParams.Type.CARD)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = InstrumentCreateParams.builder().build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }
}
