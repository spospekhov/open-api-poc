@file:JvmName("Utils")

package com.apron_api.api.core

import com.apron_api.api.errors.ApronApiInvalidDataException
import com.google.common.collect.ImmutableListMultimap
import com.google.common.collect.ListMultimap
import com.google.common.collect.Multimaps
import java.util.Collections

internal fun <T : Any> T?.getOrThrow(name: String): T {
    if (this == null) {
        throw ApronApiInvalidDataException("'${name}' is not present")
    }

    return this
}

internal fun <T> List<T>.toUnmodifiable(): List<T> {
    if (isEmpty()) {
        return Collections.emptyList()
    }

    return Collections.unmodifiableList(this)
}

internal fun <K, V> Map<K, V>.toUnmodifiable(): Map<K, V> {
    if (isEmpty()) {
        return Collections.emptyMap()
    }

    return Collections.unmodifiableMap(this)
}

internal fun <K, V> ListMultimap<K, V>.toUnmodifiable(): ListMultimap<K, V> {
    if (isEmpty()) {
        return ImmutableListMultimap.of()
    }

    return Multimaps.unmodifiableListMultimap(this)
}

internal fun ListMultimap<String, String>.getRequiredHeader(header: String): String {
    val value =
        entries()
            .stream()
            .filter { entry -> entry.key.equals(header, ignoreCase = true) }
            .map { entry -> entry.value }
            .findFirst()
    if (!value.isPresent) {
        throw ApronApiInvalidDataException("Could not find $header header")
    }
    return value.get()
}

internal interface Enum
