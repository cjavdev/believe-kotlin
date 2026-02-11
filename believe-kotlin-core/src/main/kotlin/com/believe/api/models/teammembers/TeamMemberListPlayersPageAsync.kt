// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.teammembers

import com.believe.api.core.AutoPagerAsync
import com.believe.api.core.PageAsync
import com.believe.api.core.checkRequired
import com.believe.api.services.async.TeamMemberServiceAsync
import java.util.Objects

/** @see TeamMemberServiceAsync.listPlayers */
class TeamMemberListPlayersPageAsync
private constructor(
    private val service: TeamMemberServiceAsync,
    private val params: TeamMemberListPlayersParams,
    private val response: TeamMemberListPlayersPageResponse,
) : PageAsync<Player> {

    /**
     * Delegates to [TeamMemberListPlayersPageResponse], but gracefully handles missing data.
     *
     * @see TeamMemberListPlayersPageResponse.data
     */
    fun data(): List<Player> = response._data().getNullable("data") ?: emptyList()

    /**
     * Delegates to [TeamMemberListPlayersPageResponse], but gracefully handles missing data.
     *
     * @see TeamMemberListPlayersPageResponse.total
     */
    fun total(): Long? = response._total().getNullable("total")

    /**
     * Delegates to [TeamMemberListPlayersPageResponse], but gracefully handles missing data.
     *
     * @see TeamMemberListPlayersPageResponse.skip
     */
    fun skip(): Long? = response._skip().getNullable("skip")

    override fun items(): List<Player> = data()

    override fun hasNextPage(): Boolean {
        if (items().isEmpty()) {
            return false
        }

        val offset = skip() ?: 0
        val totalCount = total()
        return totalCount == null || offset + items().size < totalCount
    }

    fun nextPageParams(): TeamMemberListPlayersParams {
        val offset = skip() ?: 0
        return params.toBuilder().skip(offset + items().size).build()
    }

    override suspend fun nextPage(): TeamMemberListPlayersPageAsync =
        service.listPlayers(nextPageParams())

    fun autoPager(): AutoPagerAsync<Player> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): TeamMemberListPlayersParams = params

    /** The response that this page was parsed from. */
    fun response(): TeamMemberListPlayersPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [TeamMemberListPlayersPageAsync].
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

    /** A builder for [TeamMemberListPlayersPageAsync]. */
    class Builder internal constructor() {

        private var service: TeamMemberServiceAsync? = null
        private var params: TeamMemberListPlayersParams? = null
        private var response: TeamMemberListPlayersPageResponse? = null

        internal fun from(teamMemberListPlayersPageAsync: TeamMemberListPlayersPageAsync) = apply {
            service = teamMemberListPlayersPageAsync.service
            params = teamMemberListPlayersPageAsync.params
            response = teamMemberListPlayersPageAsync.response
        }

        fun service(service: TeamMemberServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: TeamMemberListPlayersParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TeamMemberListPlayersPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [TeamMemberListPlayersPageAsync].
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
        fun build(): TeamMemberListPlayersPageAsync =
            TeamMemberListPlayersPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TeamMemberListPlayersPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "TeamMemberListPlayersPageAsync{service=$service, params=$params, response=$response}"
}
