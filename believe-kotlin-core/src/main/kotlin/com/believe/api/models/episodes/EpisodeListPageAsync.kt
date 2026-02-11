// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.episodes

import com.believe.api.core.AutoPagerAsync
import com.believe.api.core.PageAsync
import com.believe.api.core.checkRequired
import com.believe.api.services.async.EpisodeServiceAsync
import java.util.Objects

/** @see EpisodeServiceAsync.list */
class EpisodeListPageAsync
private constructor(
    private val service: EpisodeServiceAsync,
    private val params: EpisodeListParams,
    private val response: PaginatedResponse,
) : PageAsync<Episode> {

    /**
     * Delegates to [PaginatedResponse], but gracefully handles missing data.
     *
     * @see PaginatedResponse.data
     */
    fun data(): List<Episode> = response._data().getNullable("data") ?: emptyList()

    /**
     * Delegates to [PaginatedResponse], but gracefully handles missing data.
     *
     * @see PaginatedResponse.total
     */
    fun total(): Long? = response._total().getNullable("total")

    /**
     * Delegates to [PaginatedResponse], but gracefully handles missing data.
     *
     * @see PaginatedResponse.skip
     */
    fun skip(): Long? = response._skip().getNullable("skip")

    override fun items(): List<Episode> = data()

    override fun hasNextPage(): Boolean {
        if (items().isEmpty()) {
            return false
        }

        val offset = skip() ?: 0
        val totalCount = total()
        return totalCount == null || offset + items().size < totalCount
    }

    fun nextPageParams(): EpisodeListParams {
        val offset = skip() ?: 0
        return params.toBuilder().skip(offset + items().size).build()
    }

    override suspend fun nextPage(): EpisodeListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Episode> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): EpisodeListParams = params

    /** The response that this page was parsed from. */
    fun response(): PaginatedResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [EpisodeListPageAsync].
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

    /** A builder for [EpisodeListPageAsync]. */
    class Builder internal constructor() {

        private var service: EpisodeServiceAsync? = null
        private var params: EpisodeListParams? = null
        private var response: PaginatedResponse? = null

        internal fun from(episodeListPageAsync: EpisodeListPageAsync) = apply {
            service = episodeListPageAsync.service
            params = episodeListPageAsync.params
            response = episodeListPageAsync.response
        }

        fun service(service: EpisodeServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: EpisodeListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PaginatedResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [EpisodeListPageAsync].
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
        fun build(): EpisodeListPageAsync =
            EpisodeListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EpisodeListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "EpisodeListPageAsync{service=$service, params=$params, response=$response}"
}
