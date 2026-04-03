// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.ticketsales.TicketSale
import com.believe.api.models.ticketsales.TicketSaleCreateParams
import com.believe.api.models.ticketsales.TicketSaleDeleteParams
import com.believe.api.models.ticketsales.TicketSaleListPageAsync
import com.believe.api.models.ticketsales.TicketSaleListParams
import com.believe.api.models.ticketsales.TicketSaleRetrieveParams
import com.believe.api.models.ticketsales.TicketSaleUpdateParams
import com.believe.api.services.async.TicketSaleServiceAsync
import com.google.errorprone.annotations.MustBeClosed

/** Ticket sales with 300 records for practicing pagination, filtering, and financial data */
interface TicketSaleServiceAsync {

    /** Returns a view of this service that provides access to raw HTTP responses for each method. */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TicketSaleServiceAsync

    /** Record a new ticket sale. */
    suspend fun create(params: TicketSaleCreateParams, requestOptions: RequestOptions = RequestOptions.none()): TicketSale

    /** Retrieve detailed information about a specific ticket sale. */
    suspend fun retrieve(ticketSaleId: String, params: TicketSaleRetrieveParams = TicketSaleRetrieveParams.none(), requestOptions: RequestOptions = RequestOptions.none()): TicketSale =
        retrieve(
          params.toBuilder()
              .ticketSaleId(ticketSaleId)
              .build(), requestOptions
        )

    /** @see retrieve */
    suspend fun retrieve(params: TicketSaleRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): TicketSale

    /** @see retrieve */
    suspend fun retrieve(ticketSaleId: String, requestOptions: RequestOptions): TicketSale =
        retrieve(
          ticketSaleId,
          TicketSaleRetrieveParams.none(),
          requestOptions,
        )

    /** Update specific fields of an existing ticket sale. */
    suspend fun update(ticketSaleId: String, params: TicketSaleUpdateParams = TicketSaleUpdateParams.none(), requestOptions: RequestOptions = RequestOptions.none()): TicketSale =
        update(
          params.toBuilder()
              .ticketSaleId(ticketSaleId)
              .build(), requestOptions
        )

    /** @see update */
    suspend fun update(params: TicketSaleUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): TicketSale

    /** @see update */
    suspend fun update(ticketSaleId: String, requestOptions: RequestOptions): TicketSale =
        update(
          ticketSaleId,
          TicketSaleUpdateParams.none(),
          requestOptions,
        )

    /** Get a paginated list of all ticket sales with optional filtering. With 300 records, this endpoint is ideal for practicing pagination. */
    suspend fun list(params: TicketSaleListParams = TicketSaleListParams.none(), requestOptions: RequestOptions = RequestOptions.none()): TicketSaleListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): TicketSaleListPageAsync =
        list(
          TicketSaleListParams.none(), requestOptions
        )

    /** Remove a ticket sale from the database. */
    suspend fun delete(ticketSaleId: String, params: TicketSaleDeleteParams = TicketSaleDeleteParams.none(), requestOptions: RequestOptions = RequestOptions.none()) =
        delete(
          params.toBuilder()
              .ticketSaleId(ticketSaleId)
              .build(), requestOptions
        )

    /** @see delete */
    suspend fun delete(params: TicketSaleDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    suspend fun delete(ticketSaleId: String, requestOptions: RequestOptions) =
        delete(
          ticketSaleId,
          TicketSaleDeleteParams.none(),
          requestOptions,
        )

    /** A view of [TicketSaleServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TicketSaleServiceAsync.WithRawResponse

        /** Returns a raw HTTP response for `post /ticket-sales`, but is otherwise the             same as [TicketSaleServiceAsync.create]. */
        @MustBeClosed
        suspend fun create(params: TicketSaleCreateParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<TicketSale>

        /** Returns a raw HTTP response for `get /ticket-sales/{ticket_sale_id}`, but is otherwise the             same as [TicketSaleServiceAsync.retrieve]. */
        @MustBeClosed
        suspend fun retrieve(ticketSaleId: String, params: TicketSaleRetrieveParams = TicketSaleRetrieveParams.none(), requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<TicketSale> =
            retrieve(
              params.toBuilder()
                  .ticketSaleId(ticketSaleId)
                  .build(), requestOptions
            )

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(params: TicketSaleRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<TicketSale>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(ticketSaleId: String, requestOptions: RequestOptions): HttpResponseFor<TicketSale> =
            retrieve(
              ticketSaleId,
              TicketSaleRetrieveParams.none(),
              requestOptions,
            )

        /** Returns a raw HTTP response for `patch /ticket-sales/{ticket_sale_id}`, but is otherwise the             same as [TicketSaleServiceAsync.update]. */
        @MustBeClosed
        suspend fun update(ticketSaleId: String, params: TicketSaleUpdateParams = TicketSaleUpdateParams.none(), requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<TicketSale> =
            update(
              params.toBuilder()
                  .ticketSaleId(ticketSaleId)
                  .build(), requestOptions
            )

        /** @see update */
        @MustBeClosed
        suspend fun update(params: TicketSaleUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<TicketSale>

        /** @see update */
        @MustBeClosed
        suspend fun update(ticketSaleId: String, requestOptions: RequestOptions): HttpResponseFor<TicketSale> =
            update(
              ticketSaleId,
              TicketSaleUpdateParams.none(),
              requestOptions,
            )

        /** Returns a raw HTTP response for `get /ticket-sales`, but is otherwise the             same as [TicketSaleServiceAsync.list]. */
        @MustBeClosed
        suspend fun list(params: TicketSaleListParams = TicketSaleListParams.none(), requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<TicketSaleListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<TicketSaleListPageAsync> =
            list(
              TicketSaleListParams.none(), requestOptions
            )

        /** Returns a raw HTTP response for `delete /ticket-sales/{ticket_sale_id}`, but is otherwise the             same as [TicketSaleServiceAsync.delete]. */
        @MustBeClosed
        suspend fun delete(ticketSaleId: String, params: TicketSaleDeleteParams = TicketSaleDeleteParams.none(), requestOptions: RequestOptions = RequestOptions.none()): HttpResponse =
            delete(
              params.toBuilder()
                  .ticketSaleId(ticketSaleId)
                  .build(), requestOptions
            )

        /** @see delete */
        @MustBeClosed
        suspend fun delete(params: TicketSaleDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(ticketSaleId: String, requestOptions: RequestOptions): HttpResponse =
            delete(
              ticketSaleId,
              TicketSaleDeleteParams.none(),
              requestOptions,
            )
    }
}
