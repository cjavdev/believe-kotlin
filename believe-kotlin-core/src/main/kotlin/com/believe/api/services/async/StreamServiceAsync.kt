// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.stream.StreamTestConnectionParams
import com.believe.api.models.stream.StreamTestConnectionResponse
import com.google.errorprone.annotations.MustBeClosed

interface StreamServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): StreamServiceAsync

    /** A simple SSE test endpoint that streams numbers 1-5. */
    suspend fun testConnection(
        params: StreamTestConnectionParams = StreamTestConnectionParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamTestConnectionResponse

    /** @see testConnection */
    suspend fun testConnection(requestOptions: RequestOptions): StreamTestConnectionResponse =
        testConnection(StreamTestConnectionParams.none(), requestOptions)

    /**
     * A view of [StreamServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): StreamServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /stream/test`, but is otherwise the same as
         * [StreamServiceAsync.testConnection].
         */
        @MustBeClosed
        suspend fun testConnection(
            params: StreamTestConnectionParams = StreamTestConnectionParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamTestConnectionResponse>

        /** @see testConnection */
        @MustBeClosed
        suspend fun testConnection(
            requestOptions: RequestOptions
        ): HttpResponseFor<StreamTestConnectionResponse> =
            testConnection(StreamTestConnectionParams.none(), requestOptions)
    }
}
