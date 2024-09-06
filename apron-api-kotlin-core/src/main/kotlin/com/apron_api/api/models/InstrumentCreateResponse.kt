// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.models

import com.apron_api.api.core.ExcludeMissing
import com.apron_api.api.core.JsonField
import com.apron_api.api.core.JsonMissing
import com.apron_api.api.core.JsonValue
import com.apron_api.api.core.NoAutoDetect
import com.apron_api.api.core.toUnmodifiable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects

@JsonDeserialize(builder = InstrumentCreateResponse.Builder::class)
@NoAutoDetect
class InstrumentCreateResponse
private constructor(
    private val id: JsonField<String>,
    private val ownerId: JsonField<String>,
    private val lastFour: JsonField<String>,
    private val expirationDate: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): String = id.getRequired("id")

    fun ownerId(): String = ownerId.getRequired("ownerId")

    fun lastFour(): String = lastFour.getRequired("lastFour")

    fun expirationDate(): String = expirationDate.getRequired("expirationDate")

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("ownerId") @ExcludeMissing fun _ownerId() = ownerId

    @JsonProperty("lastFour") @ExcludeMissing fun _lastFour() = lastFour

    @JsonProperty("expirationDate") @ExcludeMissing fun _expirationDate() = expirationDate

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): InstrumentCreateResponse = apply {
        if (!validated) {
            id()
            ownerId()
            lastFour()
            expirationDate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InstrumentCreateResponse &&
            this.id == other.id &&
            this.ownerId == other.ownerId &&
            this.lastFour == other.lastFour &&
            this.expirationDate == other.expirationDate &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    ownerId,
                    lastFour,
                    expirationDate,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "InstrumentCreateResponse{id=$id, ownerId=$ownerId, lastFour=$lastFour, expirationDate=$expirationDate, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var ownerId: JsonField<String> = JsonMissing.of()
        private var lastFour: JsonField<String> = JsonMissing.of()
        private var expirationDate: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(instrumentCreateResponse: InstrumentCreateResponse) = apply {
            this.id = instrumentCreateResponse.id
            this.ownerId = instrumentCreateResponse.ownerId
            this.lastFour = instrumentCreateResponse.lastFour
            this.expirationDate = instrumentCreateResponse.expirationDate
            additionalProperties(instrumentCreateResponse.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun ownerId(ownerId: String) = ownerId(JsonField.of(ownerId))

        @JsonProperty("ownerId")
        @ExcludeMissing
        fun ownerId(ownerId: JsonField<String>) = apply { this.ownerId = ownerId }

        fun lastFour(lastFour: String) = lastFour(JsonField.of(lastFour))

        @JsonProperty("lastFour")
        @ExcludeMissing
        fun lastFour(lastFour: JsonField<String>) = apply { this.lastFour = lastFour }

        fun expirationDate(expirationDate: String) = expirationDate(JsonField.of(expirationDate))

        @JsonProperty("expirationDate")
        @ExcludeMissing
        fun expirationDate(expirationDate: JsonField<String>) = apply {
            this.expirationDate = expirationDate
        }

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

        fun build(): InstrumentCreateResponse =
            InstrumentCreateResponse(
                id,
                ownerId,
                lastFour,
                expirationDate,
                additionalProperties.toUnmodifiable(),
            )
    }
}
