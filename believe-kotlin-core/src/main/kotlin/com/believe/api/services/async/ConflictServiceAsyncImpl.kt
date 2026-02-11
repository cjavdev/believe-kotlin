// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
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
import com.believe.api.models.conflicts.ConflictResolveParams
import com.believe.api.models.conflicts.ConflictResolveResponse

class ConflictServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ConflictServiceAsync {

    private val withRawResponse: ConflictServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ConflictServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ConflictServiceAsync =
        ConflictServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun resolve(
        params: ConflictResolveParams,
        requestOptions: RequestOptions,
    ): ConflictResolveResponse =
        // post /conflicts/resolve
        withRawResponse().resolve(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ConflictServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ConflictServiceAsync.WithRawResponse =
            ConflictServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val resolveHandler: Handler<ConflictResolveResponse> =
            jsonHandler<ConflictResolveResponse>(clientOptions.jsonMapper)

        override suspend fun resolve(
            params: ConflictResolveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ConflictResolveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("conflicts", "resolve")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { resolveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
