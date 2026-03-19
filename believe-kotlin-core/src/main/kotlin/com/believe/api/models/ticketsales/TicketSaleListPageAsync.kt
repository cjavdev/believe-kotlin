// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.ticketsales

import com.believe.api.core.AutoPagerAsync
import com.believe.api.core.PageAsync
import com.believe.api.core.checkRequired
import com.believe.api.services.async.TicketSaleServiceAsync
import java.util.Objects

/** @see TicketSaleServiceAsync.list */
class TicketSaleListPageAsync
private constructor(
    private val service: TicketSaleServiceAsync,
    private val params: TicketSaleListParams,
    private val response: TicketSaleListPageResponse,
) : PageAsync<TicketSale> {

    /**
     * Delegates to [TicketSaleListPageResponse], but gracefully handles missing data.
     *
     * @see TicketSaleListPageResponse.data
     */
    fun data(): List<TicketSale> = response._data().getNullable("data") ?: emptyList()

    /**
     * Delegates to [TicketSaleListPageResponse], but gracefully handles missing data.
     *
     * @see TicketSaleListPageResponse.total
     */
    fun total(): Long? = response._total().getNullable("total")

    /**
     * Delegates to [TicketSaleListPageResponse], but gracefully handles missing data.
     *
     * @see TicketSaleListPageResponse.skip
     */
    fun skip(): Long? = response._skip().getNullable("skip")

    override fun items(): List<TicketSale> = data()

    override fun hasNextPage(): Boolean {
        if (items().isEmpty()) {
            return false
        }

        val offset = skip() ?: 0
        val totalCount = total()
        return totalCount == null || offset + items().size < totalCount
    }

    fun nextPageParams(): TicketSaleListParams {
        val offset = skip() ?: 0
        return params.toBuilder().skip(offset + items().size).build()
    }

    override suspend fun nextPage(): TicketSaleListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<TicketSale> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): TicketSaleListParams = params

    /** The response that this page was parsed from. */
    fun response(): TicketSaleListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TicketSaleListPageAsync].
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

    /** A builder for [TicketSaleListPageAsync]. */
    class Builder internal constructor() {

        private var service: TicketSaleServiceAsync? = null
        private var params: TicketSaleListParams? = null
        private var response: TicketSaleListPageResponse? = null

        internal fun from(ticketSaleListPageAsync: TicketSaleListPageAsync) = apply {
            service = ticketSaleListPageAsync.service
            params = ticketSaleListPageAsync.params
            response = ticketSaleListPageAsync.response
        }

        fun service(service: TicketSaleServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: TicketSaleListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TicketSaleListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TicketSaleListPageAsync].
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
        fun build(): TicketSaleListPageAsync =
            TicketSaleListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TicketSaleListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "TicketSaleListPageAsync{service=$service, params=$params, response=$response}"
}
