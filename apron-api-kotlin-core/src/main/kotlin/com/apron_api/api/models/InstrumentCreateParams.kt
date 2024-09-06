// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.models

import com.apron_api.api.core.Enum
import com.apron_api.api.core.ExcludeMissing
import com.apron_api.api.core.JsonField
import com.apron_api.api.core.JsonValue
import com.apron_api.api.core.NoAutoDetect
import com.apron_api.api.core.toUnmodifiable
import com.apron_api.api.errors.ApronApiInvalidDataException
import com.apron_api.api.models.*
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects

class InstrumentCreateParams
constructor(
    private val token: String?,
    private val accountId: String?,
    private val companyId: String?,
    private val name: String?,
    private val type: Type?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun token(): String? = token

    fun accountId(): String? = accountId

    fun companyId(): String? = companyId

    fun name(): String? = name

    fun type(): Type? = type

    internal fun getBody(): InstrumentCreateBody {
        return InstrumentCreateBody(
            token,
            accountId,
            companyId,
            name,
            type,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = InstrumentCreateBody.Builder::class)
    @NoAutoDetect
    class InstrumentCreateBody
    internal constructor(
        private val token: String?,
        private val accountId: String?,
        private val companyId: String?,
        private val name: String?,
        private val type: Type?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("token") fun token(): String? = token

        @JsonProperty("accountId") fun accountId(): String? = accountId

        @JsonProperty("companyId") fun companyId(): String? = companyId

        @JsonProperty("name") fun name(): String? = name

        @JsonProperty("type") fun type(): Type? = type

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is InstrumentCreateBody &&
                this.token == other.token &&
                this.accountId == other.accountId &&
                this.companyId == other.companyId &&
                this.name == other.name &&
                this.type == other.type &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        token,
                        accountId,
                        companyId,
                        name,
                        type,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "InstrumentCreateBody{token=$token, accountId=$accountId, companyId=$companyId, name=$name, type=$type, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var token: String? = null
            private var accountId: String? = null
            private var companyId: String? = null
            private var name: String? = null
            private var type: Type? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(instrumentCreateBody: InstrumentCreateBody) = apply {
                this.token = instrumentCreateBody.token
                this.accountId = instrumentCreateBody.accountId
                this.companyId = instrumentCreateBody.companyId
                this.name = instrumentCreateBody.name
                this.type = instrumentCreateBody.type
                additionalProperties(instrumentCreateBody.additionalProperties)
            }

            @JsonProperty("token") fun token(token: String) = apply { this.token = token }

            @JsonProperty("accountId")
            fun accountId(accountId: String) = apply { this.accountId = accountId }

            @JsonProperty("companyId")
            fun companyId(companyId: String) = apply { this.companyId = companyId }

            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            @JsonProperty("type") fun type(type: Type) = apply { this.type = type }

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

            fun build(): InstrumentCreateBody =
                InstrumentCreateBody(
                    token,
                    accountId,
                    companyId,
                    name,
                    type,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InstrumentCreateParams &&
            this.token == other.token &&
            this.accountId == other.accountId &&
            this.companyId == other.companyId &&
            this.name == other.name &&
            this.type == other.type &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            token,
            accountId,
            companyId,
            name,
            type,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "InstrumentCreateParams{token=$token, accountId=$accountId, companyId=$companyId, name=$name, type=$type, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var token: String? = null
        private var accountId: String? = null
        private var companyId: String? = null
        private var name: String? = null
        private var type: Type? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(instrumentCreateParams: InstrumentCreateParams) = apply {
            this.token = instrumentCreateParams.token
            this.accountId = instrumentCreateParams.accountId
            this.companyId = instrumentCreateParams.companyId
            this.name = instrumentCreateParams.name
            this.type = instrumentCreateParams.type
            additionalQueryParams(instrumentCreateParams.additionalQueryParams)
            additionalHeaders(instrumentCreateParams.additionalHeaders)
            additionalBodyProperties(instrumentCreateParams.additionalBodyProperties)
        }

        fun token(token: String) = apply { this.token = token }

        fun accountId(accountId: String) = apply { this.accountId = accountId }

        fun companyId(companyId: String) = apply { this.companyId = companyId }

        fun name(name: String) = apply { this.name = name }

        fun type(type: Type) = apply { this.type = type }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): InstrumentCreateParams =
            InstrumentCreateParams(
                token,
                accountId,
                companyId,
                name,
                type,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Type && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val CARD = Type(JsonField.of("CARD"))

            val PLAID = Type(JsonField.of("PLAID"))

            fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            CARD,
            PLAID,
        }

        enum class Value {
            CARD,
            PLAID,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CARD -> Value.CARD
                PLAID -> Value.PLAID
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CARD -> Known.CARD
                PLAID -> Known.PLAID
                else -> throw ApronApiInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
