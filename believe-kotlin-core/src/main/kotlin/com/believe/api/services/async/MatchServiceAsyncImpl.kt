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
import com.believe.api.models.matches.Match
import com.believe.api.models.matches.MatchCreateParams
import com.believe.api.models.matches.MatchDeleteParams
import com.believe.api.models.matches.MatchGetLessonParams
import com.believe.api.models.matches.MatchGetLessonResponse
import com.believe.api.models.matches.MatchGetTurningPointsParams
import com.believe.api.models.matches.MatchGetTurningPointsResponse
import com.believe.api.models.matches.MatchListPageAsync
import com.believe.api.models.matches.MatchListPageResponse
import com.believe.api.models.matches.MatchListParams
import com.believe.api.models.matches.MatchRetrieveParams
import com.believe.api.models.matches.MatchStreamLiveParams
import com.believe.api.models.matches.MatchUpdateParams
import com.believe.api.services.async.matches.CommentaryServiceAsync
import com.believe.api.services.async.matches.CommentaryServiceAsyncImpl

class MatchServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    MatchServiceAsync {

    private val withRawResponse: MatchServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val commentary: CommentaryServiceAsync by lazy {
        CommentaryServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): MatchServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): MatchServiceAsync =
        MatchServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun commentary(): CommentaryServiceAsync = commentary

    override suspend fun create(params: MatchCreateParams, requestOptions: RequestOptions): Match =
        // post /matches
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: MatchRetrieveParams,
        requestOptions: RequestOptions,
    ): Match =
        // get /matches/{match_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(params: MatchUpdateParams, requestOptions: RequestOptions): Match =
        // patch /matches/{match_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: MatchListParams,
        requestOptions: RequestOptions,
    ): MatchListPageAsync =
        // get /matches
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: MatchDeleteParams, requestOptions: RequestOptions) {
        // delete /matches/{match_id}
        withRawResponse().delete(params, requestOptions)
    }

    override suspend fun getLesson(
        params: MatchGetLessonParams,
        requestOptions: RequestOptions,
    ): MatchGetLessonResponse =
        // get /matches/{match_id}/lesson
        withRawResponse().getLesson(params, requestOptions).parse()

    override suspend fun getTurningPoints(
        params: MatchGetTurningPointsParams,
        requestOptions: RequestOptions,
    ): List<MatchGetTurningPointsResponse> =
        // get /matches/{match_id}/turning-points
        withRawResponse().getTurningPoints(params, requestOptions).parse()

    override suspend fun streamLive(params: MatchStreamLiveParams, requestOptions: RequestOptions) {
        // get /matches/live
        withRawResponse().streamLive(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MatchServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val commentary: CommentaryServiceAsync.WithRawResponse by lazy {
            CommentaryServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): MatchServiceAsync.WithRawResponse =
            MatchServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun commentary(): CommentaryServiceAsync.WithRawResponse = commentary

        private val createHandler: Handler<Match> = jsonHandler<Match>(clientOptions.jsonMapper)

        override suspend fun create(
            params: MatchCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Match> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("matches")
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

        private val retrieveHandler: Handler<Match> = jsonHandler<Match>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: MatchRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Match> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("matchId", params.matchId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("matches", params._pathParam(0))
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

        private val updateHandler: Handler<Match> = jsonHandler<Match>(clientOptions.jsonMapper)

        override suspend fun update(
            params: MatchUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Match> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("matchId", params.matchId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("matches", params._pathParam(0))
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

        private val listHandler: Handler<MatchListPageResponse> =
            jsonHandler<MatchListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: MatchListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MatchListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("matches")
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
                        MatchListPageAsync.builder()
                            .service(MatchServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: MatchDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("matchId", params.matchId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("matches", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val getLessonHandler: Handler<MatchGetLessonResponse> =
            jsonHandler<MatchGetLessonResponse>(clientOptions.jsonMapper)

        override suspend fun getLesson(
            params: MatchGetLessonParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MatchGetLessonResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("matchId", params.matchId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("matches", params._pathParam(0), "lesson")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getLessonHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getTurningPointsHandler: Handler<List<MatchGetTurningPointsResponse>> =
            jsonHandler<List<MatchGetTurningPointsResponse>>(clientOptions.jsonMapper)

        override suspend fun getTurningPoints(
            params: MatchGetTurningPointsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<MatchGetTurningPointsResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("matchId", params.matchId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("matches", params._pathParam(0), "turning-points")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getTurningPointsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val streamLiveHandler: Handler<Void?> = emptyHandler()

        override suspend fun streamLive(
            params: MatchStreamLiveParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("matches", "live")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { streamLiveHandler.handle(it) }
            }
        }
    }
}
