// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async.coaching

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.checkRequired
import com.believe.api.core.handlers.errorBodyHandler
import com.believe.api.core.handlers.errorHandler
import com.believe.api.core.handlers.jsonHandler
import com.believe.api.core.http.HttpMethod
import com.believe.api.core.http.HttpRequest
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponse.Handler
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.core.http.parseable
import com.believe.api.core.prepareAsync
import com.believe.api.models.coaching.principles.CoachingPrinciple
import com.believe.api.models.coaching.principles.PrincipleGetRandomParams
import com.believe.api.models.coaching.principles.PrincipleListPageAsync
import com.believe.api.models.coaching.principles.PrincipleListPageResponse
import com.believe.api.models.coaching.principles.PrincipleListParams
import com.believe.api.models.coaching.principles.PrincipleRetrieveParams

class PrincipleServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PrincipleServiceAsync {

    private val withRawResponse: PrincipleServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PrincipleServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PrincipleServiceAsync =
        PrincipleServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun retrieve(
        params: PrincipleRetrieveParams,
        requestOptions: RequestOptions,
    ): CoachingPrinciple =
        // get /coaching/principles/{principle_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: PrincipleListParams,
        requestOptions: RequestOptions,
    ): PrincipleListPageAsync =
        // get /coaching/principles
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun getRandom(
        params: PrincipleGetRandomParams,
        requestOptions: RequestOptions,
    ): CoachingPrinciple =
        // get /coaching/principles/random
        withRawResponse().getRandom(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PrincipleServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): PrincipleServiceAsync.WithRawResponse =
            PrincipleServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val retrieveHandler: Handler<CoachingPrinciple> =
            jsonHandler<CoachingPrinciple>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: PrincipleRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CoachingPrinciple> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("principleId", params.principleId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("coaching", "principles", params._pathParam(0))
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

        private val listHandler: Handler<PrincipleListPageResponse> =
            jsonHandler<PrincipleListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: PrincipleListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PrincipleListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("coaching", "principles")
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
                        PrincipleListPageAsync.builder()
                            .service(PrincipleServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val getRandomHandler: Handler<CoachingPrinciple> =
            jsonHandler<CoachingPrinciple>(clientOptions.jsonMapper)

        override suspend fun getRandom(
            params: PrincipleGetRandomParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CoachingPrinciple> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("coaching", "principles", "random")
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
    }
}
