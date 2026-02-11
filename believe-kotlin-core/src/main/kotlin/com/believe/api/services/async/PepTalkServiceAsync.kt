// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.peptalk.PepTalkRetrieveParams
import com.believe.api.models.peptalk.PepTalkRetrieveResponse
import com.google.errorprone.annotations.MustBeClosed

interface PepTalkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PepTalkServiceAsync

    /**
     * Get a motivational pep talk from Ted Lasso himself. By default returns the complete pep talk.
     * Add `?stream=true` to get Server-Sent Events (SSE) streaming the pep talk chunk by chunk.
     */
    suspend fun retrieve(
        params: PepTalkRetrieveParams = PepTalkRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PepTalkRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(requestOptions: RequestOptions): PepTalkRetrieveResponse =
        retrieve(PepTalkRetrieveParams.none(), requestOptions)

    /**
     * A view of [PepTalkServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): PepTalkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /pep-talk`, but is otherwise the same as
         * [PepTalkServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: PepTalkRetrieveParams = PepTalkRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PepTalkRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            requestOptions: RequestOptions
        ): HttpResponseFor<PepTalkRetrieveResponse> =
            retrieve(PepTalkRetrieveParams.none(), requestOptions)
    }
}
