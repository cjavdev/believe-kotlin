// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.blocking.coaching

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.coaching.principles.CoachingPrinciple
import com.believe.api.models.coaching.principles.PrincipleGetRandomParams
import com.believe.api.models.coaching.principles.PrincipleListPage
import com.believe.api.models.coaching.principles.PrincipleListParams
import com.believe.api.models.coaching.principles.PrincipleRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface PrincipleService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PrincipleService

    /** Get details about a specific coaching principle. */
    fun retrieve(
        principleId: String,
        params: PrincipleRetrieveParams = PrincipleRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CoachingPrinciple =
        retrieve(params.toBuilder().principleId(principleId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        params: PrincipleRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CoachingPrinciple

    /** @see retrieve */
    fun retrieve(principleId: String, requestOptions: RequestOptions): CoachingPrinciple =
        retrieve(principleId, PrincipleRetrieveParams.none(), requestOptions)

    /** Get a paginated list of Ted Lasso's core coaching principles and philosophy. */
    fun list(
        params: PrincipleListParams = PrincipleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PrincipleListPage

    /** @see list */
    fun list(requestOptions: RequestOptions): PrincipleListPage =
        list(PrincipleListParams.none(), requestOptions)

    /** Get a random coaching principle to inspire your day. */
    fun getRandom(
        params: PrincipleGetRandomParams = PrincipleGetRandomParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CoachingPrinciple

    /** @see getRandom */
    fun getRandom(requestOptions: RequestOptions): CoachingPrinciple =
        getRandom(PrincipleGetRandomParams.none(), requestOptions)

    /** A view of [PrincipleService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PrincipleService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /coaching/principles/{principle_id}`, but is
         * otherwise the same as [PrincipleService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            principleId: String,
            params: PrincipleRetrieveParams = PrincipleRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CoachingPrinciple> =
            retrieve(params.toBuilder().principleId(principleId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: PrincipleRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CoachingPrinciple>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            principleId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CoachingPrinciple> =
            retrieve(principleId, PrincipleRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /coaching/principles`, but is otherwise the same as
         * [PrincipleService.list].
         */
        @MustBeClosed
        fun list(
            params: PrincipleListParams = PrincipleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PrincipleListPage>

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<PrincipleListPage> =
            list(PrincipleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /coaching/principles/random`, but is otherwise the
         * same as [PrincipleService.getRandom].
         */
        @MustBeClosed
        fun getRandom(
            params: PrincipleGetRandomParams = PrincipleGetRandomParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CoachingPrinciple>

        /** @see getRandom */
        @MustBeClosed
        fun getRandom(requestOptions: RequestOptions): HttpResponseFor<CoachingPrinciple> =
            getRandom(PrincipleGetRandomParams.none(), requestOptions)
    }
}
