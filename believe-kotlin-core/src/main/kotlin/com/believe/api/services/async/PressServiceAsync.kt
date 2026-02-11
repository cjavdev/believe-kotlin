// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.press.PressSimulateParams
import com.believe.api.models.press.PressSimulateResponse
import com.google.errorprone.annotations.MustBeClosed

interface PressServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PressServiceAsync

    /** Get Ted's response to press conference questions. */
    suspend fun simulate(
        params: PressSimulateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PressSimulateResponse

    /** A view of [PressServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): PressServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /press`, but is otherwise the same as
         * [PressServiceAsync.simulate].
         */
        @MustBeClosed
        suspend fun simulate(
            params: PressSimulateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PressSimulateResponse>
    }
}
