// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.teammembers

import com.believe.api.core.AutoPagerAsync
import com.believe.api.core.PageAsync
import com.believe.api.core.checkRequired
import com.believe.api.services.async.TeamMemberServiceAsync
import java.util.Objects

/** @see TeamMemberServiceAsync.list */
class TeamMemberListPageAsync
private constructor(
    private val service: TeamMemberServiceAsync,
    private val params: TeamMemberListParams,
    private val response: TeamMemberListPageResponse,
) : PageAsync<TeamMemberListResponse> {

    /**
     * Delegates to [TeamMemberListPageResponse], but gracefully handles missing data.
     *
     * @see TeamMemberListPageResponse.data
     */
    fun data(): List<TeamMemberListResponse> = response._data().getNullable("data") ?: emptyList()

    /**
     * Delegates to [TeamMemberListPageResponse], but gracefully handles missing data.
     *
     * @see TeamMemberListPageResponse.total
     */
    fun total(): Long? = response._total().getNullable("total")

    /**
     * Delegates to [TeamMemberListPageResponse], but gracefully handles missing data.
     *
     * @see TeamMemberListPageResponse.skip
     */
    fun skip(): Long? = response._skip().getNullable("skip")

    override fun items(): List<TeamMemberListResponse> = data()

    override fun hasNextPage(): Boolean {
        if (items().isEmpty()) {
            return false
        }

        val offset = skip() ?: 0
        val totalCount = total()
        return totalCount == null || offset + items().size < totalCount
    }

    fun nextPageParams(): TeamMemberListParams {
        val offset = skip() ?: 0
        return params.toBuilder().skip(offset + items().size).build()
    }

    override suspend fun nextPage(): TeamMemberListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<TeamMemberListResponse> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): TeamMemberListParams = params

    /** The response that this page was parsed from. */
    fun response(): TeamMemberListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TeamMemberListPageAsync].
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

    /** A builder for [TeamMemberListPageAsync]. */
    class Builder internal constructor() {

        private var service: TeamMemberServiceAsync? = null
        private var params: TeamMemberListParams? = null
        private var response: TeamMemberListPageResponse? = null

        internal fun from(teamMemberListPageAsync: TeamMemberListPageAsync) = apply {
            service = teamMemberListPageAsync.service
            params = teamMemberListPageAsync.params
            response = teamMemberListPageAsync.response
        }

        fun service(service: TeamMemberServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: TeamMemberListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TeamMemberListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TeamMemberListPageAsync].
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
        fun build(): TeamMemberListPageAsync =
            TeamMemberListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TeamMemberListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "TeamMemberListPageAsync{service=$service, params=$params, response=$response}"
}
