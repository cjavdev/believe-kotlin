// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.biscuits

import com.believe.api.core.AutoPagerAsync
import com.believe.api.core.PageAsync
import com.believe.api.core.checkRequired
import com.believe.api.services.async.BiscuitServiceAsync
import java.util.Objects

/** @see BiscuitServiceAsync.list */
class BiscuitListPageAsync
private constructor(
    private val service: BiscuitServiceAsync,
    private val params: BiscuitListParams,
    private val response: BiscuitListPageResponse,
) : PageAsync<Biscuit> {

    /**
     * Delegates to [BiscuitListPageResponse], but gracefully handles missing data.
     *
     * @see BiscuitListPageResponse.data
     */
    fun data(): List<Biscuit> = response._data().getNullable("data") ?: emptyList()

    /**
     * Delegates to [BiscuitListPageResponse], but gracefully handles missing data.
     *
     * @see BiscuitListPageResponse.total
     */
    fun total(): Long? = response._total().getNullable("total")

    /**
     * Delegates to [BiscuitListPageResponse], but gracefully handles missing data.
     *
     * @see BiscuitListPageResponse.skip
     */
    fun skip(): Long? = response._skip().getNullable("skip")

    override fun items(): List<Biscuit> = data()

    override fun hasNextPage(): Boolean {
        if (items().isEmpty()) {
            return false
        }

        val offset = skip() ?: 0
        val totalCount = total()
        return totalCount == null || offset + items().size < totalCount
    }

    fun nextPageParams(): BiscuitListParams {
        val offset = skip() ?: 0
        return params.toBuilder().skip(offset + items().size).build()
    }

    override suspend fun nextPage(): BiscuitListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Biscuit> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): BiscuitListParams = params

    /** The response that this page was parsed from. */
    fun response(): BiscuitListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BiscuitListPageAsync].
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

    /** A builder for [BiscuitListPageAsync]. */
    class Builder internal constructor() {

        private var service: BiscuitServiceAsync? = null
        private var params: BiscuitListParams? = null
        private var response: BiscuitListPageResponse? = null

        internal fun from(biscuitListPageAsync: BiscuitListPageAsync) = apply {
            service = biscuitListPageAsync.service
            params = biscuitListPageAsync.params
            response = biscuitListPageAsync.response
        }

        fun service(service: BiscuitServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: BiscuitListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: BiscuitListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [BiscuitListPageAsync].
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
        fun build(): BiscuitListPageAsync =
            BiscuitListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BiscuitListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "BiscuitListPageAsync{service=$service, params=$params, response=$response}"
}
