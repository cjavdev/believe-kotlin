// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async.matches

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.matches.commentary.CommentaryStreamParams
import com.believe.api.models.matches.commentary.CommentaryStreamResponse
import com.google.errorprone.annotations.MustBeClosed

interface CommentaryServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): CommentaryServiceAsync

    /**
     * Stream live match commentary for a specific match. Uses Server-Sent Events (SSE) to stream
     * commentary events in real-time.
     */
    suspend fun stream(
        matchId: String,
        params: CommentaryStreamParams = CommentaryStreamParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommentaryStreamResponse =
        stream(params.toBuilder().matchId(matchId).build(), requestOptions)

    /** @see stream */
    suspend fun stream(
        params: CommentaryStreamParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommentaryStreamResponse

    /** @see stream */
    suspend fun stream(matchId: String, requestOptions: RequestOptions): CommentaryStreamResponse =
        stream(matchId, CommentaryStreamParams.none(), requestOptions)

    /**
     * A view of [CommentaryServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): CommentaryServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /matches/{match_id}/commentary/stream`, but is
         * otherwise the same as [CommentaryServiceAsync.stream].
         */
        @MustBeClosed
        suspend fun stream(
            matchId: String,
            params: CommentaryStreamParams = CommentaryStreamParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommentaryStreamResponse> =
            stream(params.toBuilder().matchId(matchId).build(), requestOptions)

        /** @see stream */
        @MustBeClosed
        suspend fun stream(
            params: CommentaryStreamParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommentaryStreamResponse>

        /** @see stream */
        @MustBeClosed
        suspend fun stream(
            matchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommentaryStreamResponse> =
            stream(matchId, CommentaryStreamParams.none(), requestOptions)
    }
}
