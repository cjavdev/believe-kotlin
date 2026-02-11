// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.blocking

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.press.PressSimulateParams
import com.believe.api.models.press.PressSimulateResponse
import com.google.errorprone.annotations.MustBeClosed

interface PressService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PressService

    /** Get Ted's response to press conference questions. */
    fun simulate(
        params: PressSimulateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PressSimulateResponse

    /** A view of [PressService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PressService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /press`, but is otherwise the same as
         * [PressService.simulate].
         */
        @MustBeClosed
        fun simulate(
            params: PressSimulateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PressSimulateResponse>
    }
}
