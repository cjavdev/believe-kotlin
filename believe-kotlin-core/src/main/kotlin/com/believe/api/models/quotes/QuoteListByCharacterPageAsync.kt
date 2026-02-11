// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.quotes

import com.believe.api.core.AutoPagerAsync
import com.believe.api.core.PageAsync
import com.believe.api.core.checkRequired
import com.believe.api.services.async.QuoteServiceAsync
import java.util.Objects

/** @see QuoteServiceAsync.listByCharacter */
class QuoteListByCharacterPageAsync
private constructor(
    private val service: QuoteServiceAsync,
    private val params: QuoteListByCharacterParams,
    private val response: PaginatedResponseQuote,
) : PageAsync<Quote> {

    /**
     * Delegates to [PaginatedResponseQuote], but gracefully handles missing data.
     *
     * @see PaginatedResponseQuote.data
     */
    fun data(): List<Quote> = response._data().getNullable("data") ?: emptyList()

    /**
     * Delegates to [PaginatedResponseQuote], but gracefully handles missing data.
     *
     * @see PaginatedResponseQuote.total
     */
    fun total(): Long? = response._total().getNullable("total")

    /**
     * Delegates to [PaginatedResponseQuote], but gracefully handles missing data.
     *
     * @see PaginatedResponseQuote.skip
     */
    fun skip(): Long? = response._skip().getNullable("skip")

    override fun items(): List<Quote> = data()

    override fun hasNextPage(): Boolean {
        if (items().isEmpty()) {
            return false
        }

        val offset = skip() ?: 0
        val totalCount = total()
        return totalCount == null || offset + items().size < totalCount
    }

    fun nextPageParams(): QuoteListByCharacterParams {
        val offset = skip() ?: 0
        return params.toBuilder().skip(offset + items().size).build()
    }

    override suspend fun nextPage(): QuoteListByCharacterPageAsync =
        service.listByCharacter(nextPageParams())

    fun autoPager(): AutoPagerAsync<Quote> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): QuoteListByCharacterParams = params

    /** The response that this page was parsed from. */
    fun response(): PaginatedResponseQuote = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [QuoteListByCharacterPageAsync].
         *
         * The following fields are required:
         * ```kotlin
         * .service()
         * .params()
         * .response()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [QuoteListByCharacterPageAsync]. */
    class Builder internal constructor() {

        private var service: QuoteServiceAsync? = null
        private var params: QuoteListByCharacterParams? = null
        private var response: PaginatedResponseQuote? = null

        internal fun from(quoteListByCharacterPageAsync: QuoteListByCharacterPageAsync) = apply {
            service = quoteListByCharacterPageAsync.service
            params = quoteListByCharacterPageAsync.params
            response = quoteListByCharacterPageAsync.response
        }

        fun service(service: QuoteServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: QuoteListByCharacterParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PaginatedResponseQuote) = apply { this.response = response }

        /**
         * Returns an immutable instance of [QuoteListByCharacterPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): QuoteListByCharacterPageAsync =
            QuoteListByCharacterPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is QuoteListByCharacterPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "QuoteListByCharacterPageAsync{service=$service, params=$params, response=$response}"
}
