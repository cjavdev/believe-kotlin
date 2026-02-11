// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.matches

import com.believe.api.core.AutoPagerAsync
import com.believe.api.core.PageAsync
import com.believe.api.core.checkRequired
import com.believe.api.services.async.MatchServiceAsync
import java.util.Objects

/** @see MatchServiceAsync.list */
class MatchListPageAsync
private constructor(
    private val service: MatchServiceAsync,
    private val params: MatchListParams,
    private val response: MatchListPageResponse,
) : PageAsync<Match> {

    /**
     * Delegates to [MatchListPageResponse], but gracefully handles missing data.
     *
     * @see MatchListPageResponse.data
     */
    fun data(): List<Match> = response._data().getNullable("data") ?: emptyList()

    /**
     * Delegates to [MatchListPageResponse], but gracefully handles missing data.
     *
     * @see MatchListPageResponse.total
     */
    fun total(): Long? = response._total().getNullable("total")

    /**
     * Delegates to [MatchListPageResponse], but gracefully handles missing data.
     *
     * @see MatchListPageResponse.skip
     */
    fun skip(): Long? = response._skip().getNullable("skip")

    override fun items(): List<Match> = data()

    override fun hasNextPage(): Boolean {
        if (items().isEmpty()) {
            return false
        }

        val offset = skip() ?: 0
        val totalCount = total()
        return totalCount == null || offset + items().size < totalCount
    }

    fun nextPageParams(): MatchListParams {
        val offset = skip() ?: 0
        return params.toBuilder().skip(offset + items().size).build()
    }

    override suspend fun nextPage(): MatchListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Match> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): MatchListParams = params

    /** The response that this page was parsed from. */
    fun response(): MatchListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MatchListPageAsync].
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

    /** A builder for [MatchListPageAsync]. */
    class Builder internal constructor() {

        private var service: MatchServiceAsync? = null
        private var params: MatchListParams? = null
        private var response: MatchListPageResponse? = null

        internal fun from(matchListPageAsync: MatchListPageAsync) = apply {
            service = matchListPageAsync.service
            params = matchListPageAsync.params
            response = matchListPageAsync.response
        }

        fun service(service: MatchServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MatchListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MatchListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MatchListPageAsync].
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
        fun build(): MatchListPageAsync =
            MatchListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MatchListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "MatchListPageAsync{service=$service, params=$params, response=$response}"
}
