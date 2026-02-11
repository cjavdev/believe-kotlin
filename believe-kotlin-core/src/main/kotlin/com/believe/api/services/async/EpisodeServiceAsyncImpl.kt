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
import com.believe.api.models.episodes.Episode
import com.believe.api.models.episodes.EpisodeCreateParams
import com.believe.api.models.episodes.EpisodeDeleteParams
import com.believe.api.models.episodes.EpisodeGetWisdomParams
import com.believe.api.models.episodes.EpisodeGetWisdomResponse
import com.believe.api.models.episodes.EpisodeListBySeasonPageAsync
import com.believe.api.models.episodes.EpisodeListBySeasonParams
import com.believe.api.models.episodes.EpisodeListPageAsync
import com.believe.api.models.episodes.EpisodeListParams
import com.believe.api.models.episodes.EpisodeRetrieveParams
import com.believe.api.models.episodes.EpisodeUpdateParams
import com.believe.api.models.episodes.PaginatedResponse

class EpisodeServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    EpisodeServiceAsync {

    private val withRawResponse: EpisodeServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): EpisodeServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): EpisodeServiceAsync =
        EpisodeServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(
        params: EpisodeCreateParams,
        requestOptions: RequestOptions,
    ): Episode =
        // post /episodes
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: EpisodeRetrieveParams,
        requestOptions: RequestOptions,
    ): Episode =
        // get /episodes/{episode_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: EpisodeUpdateParams,
        requestOptions: RequestOptions,
    ): Episode =
        // patch /episodes/{episode_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: EpisodeListParams,
        requestOptions: RequestOptions,
    ): EpisodeListPageAsync =
        // get /episodes
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: EpisodeDeleteParams, requestOptions: RequestOptions) {
        // delete /episodes/{episode_id}
        withRawResponse().delete(params, requestOptions)
    }

    override suspend fun getWisdom(
        params: EpisodeGetWisdomParams,
        requestOptions: RequestOptions,
    ): EpisodeGetWisdomResponse =
        // get /episodes/{episode_id}/wisdom
        withRawResponse().getWisdom(params, requestOptions).parse()

    override suspend fun listBySeason(
        params: EpisodeListBySeasonParams,
        requestOptions: RequestOptions,
    ): EpisodeListBySeasonPageAsync =
        // get /episodes/seasons/{season_number}
        withRawResponse().listBySeason(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EpisodeServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): EpisodeServiceAsync.WithRawResponse =
            EpisodeServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createHandler: Handler<Episode> = jsonHandler<Episode>(clientOptions.jsonMapper)

        override suspend fun create(
            params: EpisodeCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Episode> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("episodes")
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

        private val retrieveHandler: Handler<Episode> =
            jsonHandler<Episode>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: EpisodeRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Episode> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("episodeId", params.episodeId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("episodes", params._pathParam(0))
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

        private val updateHandler: Handler<Episode> = jsonHandler<Episode>(clientOptions.jsonMapper)

        override suspend fun update(
            params: EpisodeUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Episode> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("episodeId", params.episodeId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("episodes", params._pathParam(0))
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

        private val listHandler: Handler<PaginatedResponse> =
            jsonHandler<PaginatedResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: EpisodeListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EpisodeListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("episodes")
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
                        EpisodeListPageAsync.builder()
                            .service(EpisodeServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: EpisodeDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("episodeId", params.episodeId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("episodes", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val getWisdomHandler: Handler<EpisodeGetWisdomResponse> =
            jsonHandler<EpisodeGetWisdomResponse>(clientOptions.jsonMapper)

        override suspend fun getWisdom(
            params: EpisodeGetWisdomParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EpisodeGetWisdomResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("episodeId", params.episodeId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("episodes", params._pathParam(0), "wisdom")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getWisdomHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listBySeasonHandler: Handler<PaginatedResponse> =
            jsonHandler<PaginatedResponse>(clientOptions.jsonMapper)

        override suspend fun listBySeason(
            params: EpisodeListBySeasonParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EpisodeListBySeasonPageAsync> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("seasonNumber", params.seasonNumber())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("episodes", "seasons", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listBySeasonHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        EpisodeListBySeasonPageAsync.builder()
                            .service(EpisodeServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
