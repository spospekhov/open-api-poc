// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InstrumentCreateResponseTest {

    @Test
    fun createInstrumentCreateResponse() {
        val instrumentCreateResponse =
            InstrumentCreateResponse.builder()
                .id("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
                .expirationDate("01/25")
                .lastFour("1111")
                .ownerId("a614b5bd-df6f-4e9f-b9e6-0b9da05ff811")
                .build()
        assertThat(instrumentCreateResponse).isNotNull
        assertThat(instrumentCreateResponse.id()).isEqualTo("b8bce7cd-0d76-4d56-89f2-60b391d4656f")
        assertThat(instrumentCreateResponse.expirationDate()).isEqualTo("01/25")
        assertThat(instrumentCreateResponse.lastFour()).isEqualTo("1111")
        assertThat(instrumentCreateResponse.ownerId())
            .isEqualTo("a614b5bd-df6f-4e9f-b9e6-0b9da05ff811")
    }
}
