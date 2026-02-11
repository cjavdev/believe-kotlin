// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.biscuits.Biscuit
import com.believe.api.models.biscuits.BiscuitGetFreshParams
import com.believe.api.models.biscuits.BiscuitListPageAsync
import com.believe.api.models.biscuits.BiscuitListParams
import com.believe.api.models.biscuits.BiscuitRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface BiscuitServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): BiscuitServiceAsync

    /** Get a specific type of biscuit by ID. */
    suspend fun retrieve(
        biscuitId: String,
        params: BiscuitRetrieveParams = BiscuitRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Biscuit = retrieve(params.toBuilder().biscuitId(biscuitId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: BiscuitRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Biscuit

    /** @see retrieve */
    suspend fun retrieve(biscuitId: String, requestOptions: RequestOptions): Biscuit =
        retrieve(biscuitId, BiscuitRetrieveParams.none(), requestOptions)

    /**
     * Get a paginated list of Ted's famous homemade biscuits! Each comes with a heartwarming
     * message.
     */
    suspend fun list(
        params: BiscuitListParams = BiscuitListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BiscuitListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): BiscuitListPageAsync =
        list(BiscuitListParams.none(), requestOptions)

    /** Get a single fresh biscuit with a personalized message from Ted. */
    suspend fun getFresh(
        params: BiscuitGetFreshParams = BiscuitGetFreshParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Biscuit

    /** @see getFresh */
    suspend fun getFresh(requestOptions: RequestOptions): Biscuit =
        getFresh(BiscuitGetFreshParams.none(), requestOptions)

    /**
     * A view of [BiscuitServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): BiscuitServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /biscuits/{biscuit_id}`, but is otherwise the same
         * as [BiscuitServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            biscuitId: String,
            params: BiscuitRetrieveParams = BiscuitRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Biscuit> =
            retrieve(params.toBuilder().biscuitId(biscuitId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: BiscuitRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Biscuit>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            biscuitId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Biscuit> =
            retrieve(biscuitId, BiscuitRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /biscuits`, but is otherwise the same as
         * [BiscuitServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: BiscuitListParams = BiscuitListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BiscuitListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<BiscuitListPageAsync> =
            list(BiscuitListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /biscuits/fresh`, but is otherwise the same as
         * [BiscuitServiceAsync.getFresh].
         */
        @MustBeClosed
        suspend fun getFresh(
            params: BiscuitGetFreshParams = BiscuitGetFreshParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Biscuit>

        /** @see getFresh */
        @MustBeClosed
        suspend fun getFresh(requestOptions: RequestOptions): HttpResponseFor<Biscuit> =
            getFresh(BiscuitGetFreshParams.none(), requestOptions)
    }
}
