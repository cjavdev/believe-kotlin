// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async.client

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.handlers.emptyHandler
import com.believe.api.core.handlers.errorBodyHandler
import com.believe.api.core.handlers.errorHandler
import com.believe.api.core.http.HttpMethod
import com.believe.api.core.http.HttpRequest
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponse.Handler
import com.believe.api.core.http.parseable
import com.believe.api.core.prepareAsync
import com.believe.api.models.client.ws.WTestParams

class WServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    WServiceAsync {

    private val withRawResponse: WServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): WServiceAsync =
        WServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun test(params: WTestParams, requestOptions: RequestOptions) {
        // get /ws/test
        withRawResponse().test(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): WServiceAsync.WithRawResponse =
            WServiceAsyncImpl.WithRawResponseImpl(clientOptions.toBuilder().apply(modifier).build())

        private val testHandler: Handler<Void?> = emptyHandler()

        override suspend fun test(
            params: WTestParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("ws", "test")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { testHandler.handle(it) }
            }
        }
    }
}
