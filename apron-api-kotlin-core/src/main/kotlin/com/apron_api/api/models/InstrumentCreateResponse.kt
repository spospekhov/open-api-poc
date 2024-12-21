// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.models

import com.apron_api.api.core.ExcludeMissing
import com.apron_api.api.core.JsonField
import com.apron_api.api.core.JsonMissing
import com.apron_api.api.core.JsonValue
import com.apron_api.api.core.NoAutoDetect
import com.apron_api.api.core.immutableEmptyMap
import com.apron_api.api.core.toImmutable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects

@NoAutoDetect
class InstrumentCreateResponse
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("ownerId")
    @ExcludeMissing
    private val ownerId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("lastFour")
    @ExcludeMissing
    private val lastFour: JsonField<String> = JsonMissing.of(),
    @JsonProperty("expirationDate")
    @ExcludeMissing
    private val expirationDate: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

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

    private var validated: Boolean = false

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
            id = instrumentCreateResponse.id
            ownerId = instrumentCreateResponse.ownerId
            lastFour = instrumentCreateResponse.lastFour
            expirationDate = instrumentCreateResponse.expirationDate
            additionalProperties = instrumentCreateResponse.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) = apply { this.id = id }

        fun ownerId(ownerId: String) = ownerId(JsonField.of(ownerId))

        fun ownerId(ownerId: JsonField<String>) = apply { this.ownerId = ownerId }

        fun lastFour(lastFour: String) = lastFour(JsonField.of(lastFour))

        fun lastFour(lastFour: JsonField<String>) = apply { this.lastFour = lastFour }

        fun expirationDate(expirationDate: String) = expirationDate(JsonField.of(expirationDate))

        fun expirationDate(expirationDate: JsonField<String>) = apply {
            this.expirationDate = expirationDate
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        fun build(): InstrumentCreateResponse =
            InstrumentCreateResponse(
                id,
                ownerId,
                lastFour,
                expirationDate,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is InstrumentCreateResponse && id == other.id && ownerId == other.ownerId && lastFour == other.lastFour && expirationDate == other.expirationDate && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, ownerId, lastFour, expirationDate, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InstrumentCreateResponse{id=$id, ownerId=$ownerId, lastFour=$lastFour, expirationDate=$expirationDate, additionalProperties=$additionalProperties}"
}
