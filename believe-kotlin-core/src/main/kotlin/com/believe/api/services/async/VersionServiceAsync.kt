// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.version.VersionRetrieveParams
import com.believe.api.models.version.VersionRetrieveResponse
import com.google.errorprone.annotations.MustBeClosed

interface VersionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): VersionServiceAsync

    /** Get detailed information about API versioning. */
    suspend fun retrieve(
        params: VersionRetrieveParams = VersionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VersionRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(requestOptions: RequestOptions): VersionRetrieveResponse =
        retrieve(VersionRetrieveParams.none(), requestOptions)

    /**
     * A view of [VersionServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): VersionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /version`, but is otherwise the same as
         * [VersionServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: VersionRetrieveParams = VersionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VersionRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            requestOptions: RequestOptions
        ): HttpResponseFor<VersionRetrieveResponse> =
            retrieve(VersionRetrieveParams.none(), requestOptions)
    }
}
