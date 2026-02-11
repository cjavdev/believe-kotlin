// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.episodes

import com.believe.api.core.AutoPagerAsync
import com.believe.api.core.PageAsync
import com.believe.api.core.checkRequired
import com.believe.api.services.async.EpisodeServiceAsync
import java.util.Objects

/** @see EpisodeServiceAsync.listBySeason */
class EpisodeListBySeasonPageAsync
private constructor(
    private val service: EpisodeServiceAsync,
    private val params: EpisodeListBySeasonParams,
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

    fun nextPageParams(): EpisodeListBySeasonParams {
        val offset = skip() ?: 0
        return params.toBuilder().skip(offset + items().size).build()
    }

    override suspend fun nextPage(): EpisodeListBySeasonPageAsync =
        service.listBySeason(nextPageParams())

    fun autoPager(): AutoPagerAsync<Episode> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): EpisodeListBySeasonParams = params

    /** The response that this page was parsed from. */
    fun response(): PaginatedResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [EpisodeListBySeasonPageAsync].
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

    /** A builder for [EpisodeListBySeasonPageAsync]. */
    class Builder internal constructor() {

        private var service: EpisodeServiceAsync? = null
        private var params: EpisodeListBySeasonParams? = null
        private var response: PaginatedResponse? = null

        internal fun from(episodeListBySeasonPageAsync: EpisodeListBySeasonPageAsync) = apply {
            service = episodeListBySeasonPageAsync.service
            params = episodeListBySeasonPageAsync.params
            response = episodeListBySeasonPageAsync.response
        }

        fun service(service: EpisodeServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: EpisodeListBySeasonParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PaginatedResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [EpisodeListBySeasonPageAsync].
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
        fun build(): EpisodeListBySeasonPageAsync =
            EpisodeListBySeasonPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EpisodeListBySeasonPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "EpisodeListBySeasonPageAsync{service=$service, params=$params, response=$response}"
}
