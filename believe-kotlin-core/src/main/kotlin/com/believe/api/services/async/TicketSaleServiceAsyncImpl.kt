// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.checkRequired
import com.believe.api.core.handlers.emptyHandler
import com.believe.api.core.handlers.errorBodyHandler
import com.believe.api.core.handlers.errorHandler
import com.believe.api.core.handlers.jsonHandler
import com.believe.api.core.http.HttpMethod
import com.believe.api.core.http.HttpRequest
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponse.Handler
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.core.http.json
import com.believe.api.core.http.parseable
import com.believe.api.core.prepareAsync
import com.believe.api.models.ticketsales.TicketSale
import com.believe.api.models.ticketsales.TicketSaleCreateParams
import com.believe.api.models.ticketsales.TicketSaleDeleteParams
import com.believe.api.models.ticketsales.TicketSaleListPage
import com.believe.api.models.ticketsales.TicketSaleListPageAsync
import com.believe.api.models.ticketsales.TicketSaleListPageResponse
import com.believe.api.models.ticketsales.TicketSaleListParams
import com.believe.api.models.ticketsales.TicketSaleRetrieveParams
import com.believe.api.models.ticketsales.TicketSaleUpdateParams
import com.believe.api.services.async.TicketSaleServiceAsync
import com.believe.api.services.async.TicketSaleServiceAsyncImpl

/** Ticket sales with 300 records for practicing pagination, filtering, and financial data */
class TicketSaleServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : TicketSaleServiceAsync {

    private val withRawResponse: TicketSaleServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): TicketSaleServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TicketSaleServiceAsync = TicketSaleServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(params: TicketSaleCreateParams, requestOptions: RequestOptions): TicketSale =
        // post /ticket-sales
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(params: TicketSaleRetrieveParams, requestOptions: RequestOptions): TicketSale =
        // get /ticket-sales/{ticket_sale_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(params: TicketSaleUpdateParams, requestOptions: RequestOptions): TicketSale =
        // patch /ticket-sales/{ticket_sale_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(params: TicketSaleListParams, requestOptions: RequestOptions): TicketSaleListPageAsync =
        // get /ticket-sales
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: TicketSaleDeleteParams, requestOptions: RequestOptions) {
      // delete /ticket-sales/{ticket_sale_id}
      withRawResponse().delete(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : TicketSaleServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> = errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TicketSaleServiceAsync.WithRawResponse = TicketSaleServiceAsyncImpl.WithRawResponseImpl(clientOptions.toBuilder().apply(modifier).build())

        private val createHandler: Handler<TicketSale> = jsonHandler<TicketSale>(clientOptions.jsonMapper)

        override suspend fun create(params: TicketSaleCreateParams, requestOptions: RequestOptions): HttpResponseFor<TicketSale> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .baseUrl(clientOptions.baseUrl())
            .addPathSegments("ticket-sales")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(
              clientOptions, params
            )
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.executeAsync(
            request, requestOptions
          )
          return errorHandler.handle(response).parseable {
              response.use {
                  createHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val retrieveHandler: Handler<TicketSale> = jsonHandler<TicketSale>(clientOptions.jsonMapper)

        override suspend fun retrieve(params: TicketSaleRetrieveParams, requestOptions: RequestOptions): HttpResponseFor<TicketSale> {
          // We check here instead of in the params builder because this can be specified positionally or in the params class.
          checkRequired("ticketSaleId", params.ticketSaleId())
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl(clientOptions.baseUrl())
            .addPathSegments("ticket-sales", params._pathParam(0))
            .build()
            .prepareAsync(
              clientOptions, params
            )
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.executeAsync(
            request, requestOptions
          )
          return errorHandler.handle(response).parseable {
              response.use {
                  retrieveHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val updateHandler: Handler<TicketSale> = jsonHandler<TicketSale>(clientOptions.jsonMapper)

        override suspend fun update(params: TicketSaleUpdateParams, requestOptions: RequestOptions): HttpResponseFor<TicketSale> {
          // We check here instead of in the params builder because this can be specified positionally or in the params class.
          checkRequired("ticketSaleId", params.ticketSaleId())
          val request = HttpRequest.builder()
            .method(HttpMethod.PATCH)
            .baseUrl(clientOptions.baseUrl())
            .addPathSegments("ticket-sales", params._pathParam(0))
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(
              clientOptions, params
            )
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.executeAsync(
            request, requestOptions
          )
          return errorHandler.handle(response).parseable {
              response.use {
                  updateHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val listHandler: Handler<TicketSaleListPageResponse> = jsonHandler<TicketSaleListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(params: TicketSaleListParams, requestOptions: RequestOptions): HttpResponseFor<TicketSaleListPageAsync> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl(clientOptions.baseUrl())
            .addPathSegments("ticket-sales")
            .build()
            .prepareAsync(
              clientOptions, params
            )
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.executeAsync(
            request, requestOptions
          )
          return errorHandler.handle(response).parseable {
              response.use {
                  listHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  TicketSaleListPageAsync.builder()
                      .service(TicketSaleServiceAsyncImpl(clientOptions))
                      .params(params)
                      .response(it)
                      .build()
              }
          }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(params: TicketSaleDeleteParams, requestOptions: RequestOptions): HttpResponse {
          // We check here instead of in the params builder because this can be specified positionally or in the params class.
          checkRequired("ticketSaleId", params.ticketSaleId())
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .baseUrl(clientOptions.baseUrl())
            .addPathSegments("ticket-sales", params._pathParam(0))
            .apply { params._body()?.let{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepareAsync(
              clientOptions, params
            )
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.executeAsync(
            request, requestOptions
          )
          return errorHandler.handle(response).parseable {
              response.use {
                  deleteHandler.handle(it)
              }
          }
        }
    }
}
