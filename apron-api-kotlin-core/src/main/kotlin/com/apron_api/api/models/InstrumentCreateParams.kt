// File generated from our OpenAPI spec by Stainless.

package com.apron_api.api.models

import com.apron_api.api.core.Enum
import com.apron_api.api.core.ExcludeMissing
import com.apron_api.api.core.JsonField
import com.apron_api.api.core.JsonValue
import com.apron_api.api.core.NoAutoDetect
import com.apron_api.api.core.http.Headers
import com.apron_api.api.core.http.QueryParams
import com.apron_api.api.core.toImmutable
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
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
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

    internal fun getHeaders(): Headers = additionalHeaders

    internal fun getQueryParams(): QueryParams = additionalQueryParams

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

        @JsonProperty("token") fun token(): String? = token

        @JsonProperty("accountId") fun accountId(): String? = accountId

        @JsonProperty("companyId") fun companyId(): String? = companyId

        @JsonProperty("name") fun name(): String? = name

        @JsonProperty("type") fun type(): Type? = type

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

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
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is InstrumentCreateBody && token == other.token && accountId == other.accountId && companyId == other.companyId && name == other.name && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(token, accountId, companyId, name, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InstrumentCreateBody{token=$token, accountId=$accountId, companyId=$companyId, name=$name, type=$type, additionalProperties=$additionalProperties}"
    }

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is InstrumentCreateParams && token == other.token && accountId == other.accountId && companyId == other.companyId && name == other.name && type == other.type && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams && additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(token, accountId, companyId, name, type, additionalHeaders, additionalQueryParams, additionalBodyProperties) /* spotless:on */

    override fun toString() =
        "InstrumentCreateParams{token=$token, accountId=$accountId, companyId=$companyId, name=$name, type=$type, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams, additionalBodyProperties=$additionalBodyProperties}"

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
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(instrumentCreateParams: InstrumentCreateParams) = apply {
            this.token = instrumentCreateParams.token
            this.accountId = instrumentCreateParams.accountId
            this.companyId = instrumentCreateParams.companyId
            this.name = instrumentCreateParams.name
            this.type = instrumentCreateParams.type
            additionalHeaders(instrumentCreateParams.additionalHeaders)
            additionalQueryParams(instrumentCreateParams.additionalQueryParams)
            additionalBodyProperties(instrumentCreateParams.additionalBodyProperties)
        }

        fun token(token: String) = apply { this.token = token }

        fun accountId(accountId: String) = apply { this.accountId = accountId }

        fun companyId(companyId: String) = apply { this.companyId = companyId }

        fun name(name: String) = apply { this.name = name }

        fun type(type: Type) = apply { this.type = type }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            putAllAdditionalBodyProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply {
            additionalBodyProperties.remove(key)
        }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalBodyProperty)
        }

        fun build(): InstrumentCreateParams =
            InstrumentCreateParams(
                token,
                accountId,
                companyId,
                name,
                type,
                additionalHeaders.build(),
                additionalQueryParams.build(),
                additionalBodyProperties.toImmutable(),
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

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
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
