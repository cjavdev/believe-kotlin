// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.episodes.Episode
import com.believe.api.models.episodes.EpisodeCreateParams
import com.believe.api.models.episodes.EpisodeDeleteParams
import com.believe.api.models.episodes.EpisodeGetWisdomParams
import com.believe.api.models.episodes.EpisodeGetWisdomResponse
import com.believe.api.models.episodes.EpisodeListPageAsync
import com.believe.api.models.episodes.EpisodeListParams
import com.believe.api.models.episodes.EpisodeRetrieveParams
import com.believe.api.models.episodes.EpisodeUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface EpisodeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): EpisodeServiceAsync

    /** Add a new episode to the series. */
    suspend fun create(
        params: EpisodeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Episode

    /** Retrieve detailed information about a specific episode. */
    suspend fun retrieve(
        episodeId: String,
        params: EpisodeRetrieveParams = EpisodeRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Episode = retrieve(params.toBuilder().episodeId(episodeId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: EpisodeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Episode

    /** @see retrieve */
    suspend fun retrieve(episodeId: String, requestOptions: RequestOptions): Episode =
        retrieve(episodeId, EpisodeRetrieveParams.none(), requestOptions)

    /** Update specific fields of an existing episode. */
    suspend fun update(
        episodeId: String,
        params: EpisodeUpdateParams = EpisodeUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Episode = update(params.toBuilder().episodeId(episodeId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: EpisodeUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Episode

    /** @see update */
    suspend fun update(episodeId: String, requestOptions: RequestOptions): Episode =
        update(episodeId, EpisodeUpdateParams.none(), requestOptions)

    /** Get a paginated list of all Ted Lasso episodes with optional filtering by season. */
    suspend fun list(
        params: EpisodeListParams = EpisodeListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EpisodeListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): EpisodeListPageAsync =
        list(EpisodeListParams.none(), requestOptions)

    /** Remove an episode from the database. */
    suspend fun delete(
        episodeId: String,
        params: EpisodeDeleteParams = EpisodeDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().episodeId(episodeId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: EpisodeDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(episodeId: String, requestOptions: RequestOptions) =
        delete(episodeId, EpisodeDeleteParams.none(), requestOptions)

    /** Get Ted's wisdom and memorable moments from a specific episode. */
    suspend fun getWisdom(
        episodeId: String,
        params: EpisodeGetWisdomParams = EpisodeGetWisdomParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EpisodeGetWisdomResponse =
        getWisdom(params.toBuilder().episodeId(episodeId).build(), requestOptions)

    /** @see getWisdom */
    suspend fun getWisdom(
        params: EpisodeGetWisdomParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EpisodeGetWisdomResponse

    /** @see getWisdom */
    suspend fun getWisdom(
        episodeId: String,
        requestOptions: RequestOptions,
    ): EpisodeGetWisdomResponse =
        getWisdom(episodeId, EpisodeGetWisdomParams.none(), requestOptions)

    /**
     * A view of [EpisodeServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): EpisodeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /episodes`, but is otherwise the same as
         * [EpisodeServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: EpisodeCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Episode>

        /**
         * Returns a raw HTTP response for `get /episodes/{episode_id}`, but is otherwise the same
         * as [EpisodeServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            episodeId: String,
            params: EpisodeRetrieveParams = EpisodeRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Episode> =
            retrieve(params.toBuilder().episodeId(episodeId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: EpisodeRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Episode>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            episodeId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Episode> =
            retrieve(episodeId, EpisodeRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /episodes/{episode_id}`, but is otherwise the same
         * as [EpisodeServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            episodeId: String,
            params: EpisodeUpdateParams = EpisodeUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Episode> =
            update(params.toBuilder().episodeId(episodeId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: EpisodeUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Episode>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            episodeId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Episode> = update(episodeId, EpisodeUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /episodes`, but is otherwise the same as
         * [EpisodeServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: EpisodeListParams = EpisodeListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EpisodeListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<EpisodeListPageAsync> =
            list(EpisodeListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /episodes/{episode_id}`, but is otherwise the
         * same as [EpisodeServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            episodeId: String,
            params: EpisodeDeleteParams = EpisodeDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().episodeId(episodeId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: EpisodeDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(episodeId: String, requestOptions: RequestOptions): HttpResponse =
            delete(episodeId, EpisodeDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /episodes/{episode_id}/wisdom`, but is otherwise the
         * same as [EpisodeServiceAsync.getWisdom].
         */
        @MustBeClosed
        suspend fun getWisdom(
            episodeId: String,
            params: EpisodeGetWisdomParams = EpisodeGetWisdomParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EpisodeGetWisdomResponse> =
            getWisdom(params.toBuilder().episodeId(episodeId).build(), requestOptions)

        /** @see getWisdom */
        @MustBeClosed
        suspend fun getWisdom(
            params: EpisodeGetWisdomParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EpisodeGetWisdomResponse>

        /** @see getWisdom */
        @MustBeClosed
        suspend fun getWisdom(
            episodeId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EpisodeGetWisdomResponse> =
            getWisdom(episodeId, EpisodeGetWisdomParams.none(), requestOptions)
    }
}
