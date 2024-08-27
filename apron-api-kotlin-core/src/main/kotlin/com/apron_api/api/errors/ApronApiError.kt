// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.errors

import com.apron_api.api.core.JsonValue
import com.apron_api.api.core.NoAutoDetect
import com.apron_api.api.core.toUnmodifiable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects

@JsonDeserialize(builder = ApronApiError.Builder::class)
@NoAutoDetect
class ApronApiError
constructor(
    private val additionalProperties: Map<String, JsonValue>,
) {

    @JsonAnyGetter fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ApronApiError && this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(additionalProperties)
    }

    override fun toString() = "ApronApiError{additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        fun from(error: ApronApiError) = apply { additionalProperties(error.additionalProperties) }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): ApronApiError = ApronApiError(additionalProperties.toUnmodifiable())
    }
}
