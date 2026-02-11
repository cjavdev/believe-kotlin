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
import com.believe.api.models.quotes.PaginatedResponseQuote
import com.believe.api.models.quotes.Quote
import com.believe.api.models.quotes.QuoteCreateParams
import com.believe.api.models.quotes.QuoteDeleteParams
import com.believe.api.models.quotes.QuoteGetRandomParams
import com.believe.api.models.quotes.QuoteListByCharacterPageAsync
import com.believe.api.models.quotes.QuoteListByCharacterParams
import com.believe.api.models.quotes.QuoteListByThemePageAsync
import com.believe.api.models.quotes.QuoteListByThemeParams
import com.believe.api.models.quotes.QuoteListPageAsync
import com.believe.api.models.quotes.QuoteListParams
import com.believe.api.models.quotes.QuoteRetrieveParams
import com.believe.api.models.quotes.QuoteUpdateParams

class QuoteServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    QuoteServiceAsync {

    private val withRawResponse: QuoteServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): QuoteServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): QuoteServiceAsync =
        QuoteServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(params: QuoteCreateParams, requestOptions: RequestOptions): Quote =
        // post /quotes
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: QuoteRetrieveParams,
        requestOptions: RequestOptions,
    ): Quote =
        // get /quotes/{quote_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(params: QuoteUpdateParams, requestOptions: RequestOptions): Quote =
        // patch /quotes/{quote_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: QuoteListParams,
        requestOptions: RequestOptions,
    ): QuoteListPageAsync =
        // get /quotes
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: QuoteDeleteParams, requestOptions: RequestOptions) {
        // delete /quotes/{quote_id}
        withRawResponse().delete(params, requestOptions)
    }

    override suspend fun getRandom(
        params: QuoteGetRandomParams,
        requestOptions: RequestOptions,
    ): Quote =
        // get /quotes/random
        withRawResponse().getRandom(params, requestOptions).parse()

    override suspend fun listByCharacter(
        params: QuoteListByCharacterParams,
        requestOptions: RequestOptions,
    ): QuoteListByCharacterPageAsync =
        // get /quotes/characters/{character_id}
        withRawResponse().listByCharacter(params, requestOptions).parse()

    override suspend fun listByTheme(
        params: QuoteListByThemeParams,
        requestOptions: RequestOptions,
    ): QuoteListByThemePageAsync =
        // get /quotes/themes/{theme}
        withRawResponse().listByTheme(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        QuoteServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): QuoteServiceAsync.WithRawResponse =
            QuoteServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createHandler: Handler<Quote> = jsonHandler<Quote>(clientOptions.jsonMapper)

        override suspend fun create(
            params: QuoteCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Quote> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("quotes")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Quote> = jsonHandler<Quote>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: QuoteRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Quote> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("quoteId", params.quoteId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("quotes", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<Quote> = jsonHandler<Quote>(clientOptions.jsonMapper)

        override suspend fun update(
            params: QuoteUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Quote> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("quoteId", params.quoteId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("quotes", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<PaginatedResponseQuote> =
            jsonHandler<PaginatedResponseQuote>(clientOptions.jsonMapper)

        override suspend fun list(
            params: QuoteListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<QuoteListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("quotes")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        QuoteListPageAsync.builder()
                            .service(QuoteServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: QuoteDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("quoteId", params.quoteId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("quotes", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val getRandomHandler: Handler<Quote> = jsonHandler<Quote>(clientOptions.jsonMapper)

        override suspend fun getRandom(
            params: QuoteGetRandomParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Quote> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("quotes", "random")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getRandomHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listByCharacterHandler: Handler<PaginatedResponseQuote> =
            jsonHandler<PaginatedResponseQuote>(clientOptions.jsonMapper)

        override suspend fun listByCharacter(
            params: QuoteListByCharacterParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<QuoteListByCharacterPageAsync> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("characterId", params.characterId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("quotes", "characters", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listByCharacterHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        QuoteListByCharacterPageAsync.builder()
                            .service(QuoteServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val listByThemeHandler: Handler<PaginatedResponseQuote> =
            jsonHandler<PaginatedResponseQuote>(clientOptions.jsonMapper)

        override suspend fun listByTheme(
            params: QuoteListByThemeParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<QuoteListByThemePageAsync> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("theme", params.theme())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("quotes", "themes", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listByThemeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        QuoteListByThemePageAsync.builder()
                            .service(QuoteServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
