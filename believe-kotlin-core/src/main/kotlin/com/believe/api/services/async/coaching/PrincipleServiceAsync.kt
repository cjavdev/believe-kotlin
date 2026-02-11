// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async.coaching

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.coaching.principles.CoachingPrinciple
import com.believe.api.models.coaching.principles.PrincipleGetRandomParams
import com.believe.api.models.coaching.principles.PrincipleListPageAsync
import com.believe.api.models.coaching.principles.PrincipleListParams
import com.believe.api.models.coaching.principles.PrincipleRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface PrincipleServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PrincipleServiceAsync

    /** Get details about a specific coaching principle. */
    suspend fun retrieve(
        principleId: String,
        params: PrincipleRetrieveParams = PrincipleRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CoachingPrinciple =
        retrieve(params.toBuilder().principleId(principleId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: PrincipleRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CoachingPrinciple

    /** @see retrieve */
    suspend fun retrieve(principleId: String, requestOptions: RequestOptions): CoachingPrinciple =
        retrieve(principleId, PrincipleRetrieveParams.none(), requestOptions)

    /** Get a paginated list of Ted Lasso's core coaching principles and philosophy. */
    suspend fun list(
        params: PrincipleListParams = PrincipleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PrincipleListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): PrincipleListPageAsync =
        list(PrincipleListParams.none(), requestOptions)

    /** Get a random coaching principle to inspire your day. */
    suspend fun getRandom(
        params: PrincipleGetRandomParams = PrincipleGetRandomParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CoachingPrinciple

    /** @see getRandom */
    suspend fun getRandom(requestOptions: RequestOptions): CoachingPrinciple =
        getRandom(PrincipleGetRandomParams.none(), requestOptions)

    /**
     * A view of [PrincipleServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): PrincipleServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /coaching/principles/{principle_id}`, but is
         * otherwise the same as [PrincipleServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            principleId: String,
            params: PrincipleRetrieveParams = PrincipleRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CoachingPrinciple> =
            retrieve(params.toBuilder().principleId(principleId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: PrincipleRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CoachingPrinciple>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            principleId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CoachingPrinciple> =
            retrieve(principleId, PrincipleRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /coaching/principles`, but is otherwise the same as
         * [PrincipleServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: PrincipleListParams = PrincipleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PrincipleListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<PrincipleListPageAsync> =
            list(PrincipleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /coaching/principles/random`, but is otherwise the
         * same as [PrincipleServiceAsync.getRandom].
         */
        @MustBeClosed
        suspend fun getRandom(
            params: PrincipleGetRandomParams = PrincipleGetRandomParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CoachingPrinciple>

        /** @see getRandom */
        @MustBeClosed
        suspend fun getRandom(requestOptions: RequestOptions): HttpResponseFor<CoachingPrinciple> =
            getRandom(PrincipleGetRandomParams.none(), requestOptions)
    }
}
