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
import com.believe.api.core.http.parseable
import com.believe.api.core.prepareAsync
import com.believe.api.models.health.HealthCheckParams
import com.believe.api.models.health.HealthCheckResponse

class HealthServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    HealthServiceAsync {

    private val withRawResponse: HealthServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): HealthServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): HealthServiceAsync =
        HealthServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun check(
        params: HealthCheckParams,
        requestOptions: RequestOptions,
    ): HealthCheckResponse =
        // get /health
        withRawResponse().check(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        HealthServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): HealthServiceAsync.WithRawResponse =
            HealthServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val checkHandler: Handler<HealthCheckResponse> =
            jsonHandler<HealthCheckResponse>(clientOptions.jsonMapper)

        override suspend fun check(
            params: HealthCheckParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<HealthCheckResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("health")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { checkHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
