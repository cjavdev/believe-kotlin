// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.teammembers

import com.believe.api.core.AutoPagerAsync
import com.believe.api.core.PageAsync
import com.believe.api.core.checkRequired
import com.believe.api.services.async.TeamMemberServiceAsync
import java.util.Objects

/** @see TeamMemberServiceAsync.listCoaches */
class TeamMemberListCoachesPageAsync
private constructor(
    private val service: TeamMemberServiceAsync,
    private val params: TeamMemberListCoachesParams,
    private val response: TeamMemberListCoachesPageResponse,
) : PageAsync<Coach> {

    /**
     * Delegates to [TeamMemberListCoachesPageResponse], but gracefully handles missing data.
     *
     * @see TeamMemberListCoachesPageResponse.data
     */
    fun data(): List<Coach> = response._data().getNullable("data") ?: emptyList()

    /**
     * Delegates to [TeamMemberListCoachesPageResponse], but gracefully handles missing data.
     *
     * @see TeamMemberListCoachesPageResponse.total
     */
    fun total(): Long? = response._total().getNullable("total")

    /**
     * Delegates to [TeamMemberListCoachesPageResponse], but gracefully handles missing data.
     *
     * @see TeamMemberListCoachesPageResponse.skip
     */
    fun skip(): Long? = response._skip().getNullable("skip")

    override fun items(): List<Coach> = data()

    override fun hasNextPage(): Boolean {
        if (items().isEmpty()) {
            return false
        }

        val offset = skip() ?: 0
        val totalCount = total()
        return totalCount == null || offset + items().size < totalCount
    }

    fun nextPageParams(): TeamMemberListCoachesParams {
        val offset = skip() ?: 0
        return params.toBuilder().skip(offset + items().size).build()
    }

    override suspend fun nextPage(): TeamMemberListCoachesPageAsync =
        service.listCoaches(nextPageParams())

    fun autoPager(): AutoPagerAsync<Coach> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): TeamMemberListCoachesParams = params

    /** The response that this page was parsed from. */
    fun response(): TeamMemberListCoachesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [TeamMemberListCoachesPageAsync].
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

    /** A builder for [TeamMemberListCoachesPageAsync]. */
    class Builder internal constructor() {

        private var service: TeamMemberServiceAsync? = null
        private var params: TeamMemberListCoachesParams? = null
        private var response: TeamMemberListCoachesPageResponse? = null

        internal fun from(teamMemberListCoachesPageAsync: TeamMemberListCoachesPageAsync) = apply {
            service = teamMemberListCoachesPageAsync.service
            params = teamMemberListCoachesPageAsync.params
            response = teamMemberListCoachesPageAsync.response
        }

        fun service(service: TeamMemberServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: TeamMemberListCoachesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TeamMemberListCoachesPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [TeamMemberListCoachesPageAsync].
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
        fun build(): TeamMemberListCoachesPageAsync =
            TeamMemberListCoachesPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TeamMemberListCoachesPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "TeamMemberListCoachesPageAsync{service=$service, params=$params, response=$response}"
}
