// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.coaching.principles

import com.believe.api.core.AutoPagerAsync
import com.believe.api.core.PageAsync
import com.believe.api.core.checkRequired
import com.believe.api.services.async.coaching.PrincipleServiceAsync
import java.util.Objects

/** @see PrincipleServiceAsync.list */
class PrincipleListPageAsync
private constructor(
    private val service: PrincipleServiceAsync,
    private val params: PrincipleListParams,
    private val response: PrincipleListPageResponse,
) : PageAsync<CoachingPrinciple> {

    /**
     * Delegates to [PrincipleListPageResponse], but gracefully handles missing data.
     *
     * @see PrincipleListPageResponse.data
     */
    fun data(): List<CoachingPrinciple> = response._data().getNullable("data") ?: emptyList()

    /**
     * Delegates to [PrincipleListPageResponse], but gracefully handles missing data.
     *
     * @see PrincipleListPageResponse.total
     */
    fun total(): Long? = response._total().getNullable("total")

    /**
     * Delegates to [PrincipleListPageResponse], but gracefully handles missing data.
     *
     * @see PrincipleListPageResponse.skip
     */
    fun skip(): Long? = response._skip().getNullable("skip")

    override fun items(): List<CoachingPrinciple> = data()

    override fun hasNextPage(): Boolean {
        if (items().isEmpty()) {
            return false
        }

        val offset = skip() ?: 0
        val totalCount = total()
        return totalCount == null || offset + items().size < totalCount
    }

    fun nextPageParams(): PrincipleListParams {
        val offset = skip() ?: 0
        return params.toBuilder().skip(offset + items().size).build()
    }

    override suspend fun nextPage(): PrincipleListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<CoachingPrinciple> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): PrincipleListParams = params

    /** The response that this page was parsed from. */
    fun response(): PrincipleListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PrincipleListPageAsync].
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

    /** A builder for [PrincipleListPageAsync]. */
    class Builder internal constructor() {

        private var service: PrincipleServiceAsync? = null
        private var params: PrincipleListParams? = null
        private var response: PrincipleListPageResponse? = null

        internal fun from(principleListPageAsync: PrincipleListPageAsync) = apply {
            service = principleListPageAsync.service
            params = principleListPageAsync.params
            response = principleListPageAsync.response
        }

        fun service(service: PrincipleServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: PrincipleListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PrincipleListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [PrincipleListPageAsync].
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
        fun build(): PrincipleListPageAsync =
            PrincipleListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PrincipleListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "PrincipleListPageAsync{service=$service, params=$params, response=$response}"
}
