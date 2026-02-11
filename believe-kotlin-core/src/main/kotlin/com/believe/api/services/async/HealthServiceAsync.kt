// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.health.HealthCheckParams
import com.believe.api.models.health.HealthCheckResponse
import com.google.errorprone.annotations.MustBeClosed

interface HealthServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): HealthServiceAsync

    /** Check if the API is running and healthy. */
    suspend fun check(
        params: HealthCheckParams = HealthCheckParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HealthCheckResponse

    /** @see check */
    suspend fun check(requestOptions: RequestOptions): HealthCheckResponse =
        check(HealthCheckParams.none(), requestOptions)

    /**
     * A view of [HealthServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): HealthServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /health`, but is otherwise the same as
         * [HealthServiceAsync.check].
         */
        @MustBeClosed
        suspend fun check(
            params: HealthCheckParams = HealthCheckParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<HealthCheckResponse>

        /** @see check */
        @MustBeClosed
        suspend fun check(requestOptions: RequestOptions): HttpResponseFor<HealthCheckResponse> =
            check(HealthCheckParams.none(), requestOptions)
    }
}
