// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.matches.Match
import com.believe.api.models.matches.MatchCreateParams
import com.believe.api.models.matches.MatchDeleteParams
import com.believe.api.models.matches.MatchGetLessonParams
import com.believe.api.models.matches.MatchGetLessonResponse
import com.believe.api.models.matches.MatchGetTurningPointsParams
import com.believe.api.models.matches.MatchGetTurningPointsResponse
import com.believe.api.models.matches.MatchListPageAsync
import com.believe.api.models.matches.MatchListParams
import com.believe.api.models.matches.MatchRetrieveParams
import com.believe.api.models.matches.MatchStreamLiveParams
import com.believe.api.models.matches.MatchUpdateParams
import com.believe.api.services.async.matches.CommentaryServiceAsync
import com.google.errorprone.annotations.MustBeClosed

interface MatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): MatchServiceAsync

    fun commentary(): CommentaryServiceAsync

    /** Schedule a new match. */
    suspend fun create(
        params: MatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Match

    /** Retrieve detailed information about a specific match. */
    suspend fun retrieve(
        matchId: String,
        params: MatchRetrieveParams = MatchRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Match = retrieve(params.toBuilder().matchId(matchId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: MatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Match

    /** @see retrieve */
    suspend fun retrieve(matchId: String, requestOptions: RequestOptions): Match =
        retrieve(matchId, MatchRetrieveParams.none(), requestOptions)

    /** Update specific fields of an existing match (e.g., update score). */
    suspend fun update(
        matchId: String,
        params: MatchUpdateParams = MatchUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Match = update(params.toBuilder().matchId(matchId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: MatchUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Match

    /** @see update */
    suspend fun update(matchId: String, requestOptions: RequestOptions): Match =
        update(matchId, MatchUpdateParams.none(), requestOptions)

    /** Get a paginated list of all matches with optional filtering. */
    suspend fun list(
        params: MatchListParams = MatchListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MatchListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): MatchListPageAsync =
        list(MatchListParams.none(), requestOptions)

    /** Remove a match from the database. */
    suspend fun delete(
        matchId: String,
        params: MatchDeleteParams = MatchDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().matchId(matchId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: MatchDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(matchId: String, requestOptions: RequestOptions) =
        delete(matchId, MatchDeleteParams.none(), requestOptions)

    /** Get the life lesson learned from a specific match. */
    suspend fun getLesson(
        matchId: String,
        params: MatchGetLessonParams = MatchGetLessonParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MatchGetLessonResponse =
        getLesson(params.toBuilder().matchId(matchId).build(), requestOptions)

    /** @see getLesson */
    suspend fun getLesson(
        params: MatchGetLessonParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MatchGetLessonResponse

    /** @see getLesson */
    suspend fun getLesson(matchId: String, requestOptions: RequestOptions): MatchGetLessonResponse =
        getLesson(matchId, MatchGetLessonParams.none(), requestOptions)

    /** Get all turning points from a specific match. */
    suspend fun getTurningPoints(
        matchId: String,
        params: MatchGetTurningPointsParams = MatchGetTurningPointsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<MatchGetTurningPointsResponse> =
        getTurningPoints(params.toBuilder().matchId(matchId).build(), requestOptions)

    /** @see getTurningPoints */
    suspend fun getTurningPoints(
        params: MatchGetTurningPointsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<MatchGetTurningPointsResponse>

    /** @see getTurningPoints */
    suspend fun getTurningPoints(
        matchId: String,
        requestOptions: RequestOptions,
    ): List<MatchGetTurningPointsResponse> =
        getTurningPoints(matchId, MatchGetTurningPointsParams.none(), requestOptions)

    /**
     * WebSocket endpoint for real-time live match simulation.
     *
     * Connect to receive a stream of match events as they happen in a simulated football match.
     *
     * ## Connection
     *
     * Connect via WebSocket with optional query parameters to customize the simulation.
     *
     * ## Example WebSocket URL
     *
     * ```
     * ws://localhost:8000/matches/live?home_team=AFC%20Richmond&away_team=Manchester%20City&speed=2.0&excitement_level=7
     * ```
     *
     * ## Server Messages
     *
     * The server sends JSON messages with these types:
     * - `match_start` - When the match begins
     * - `match_event` - For each match event (goals, fouls, cards, etc.)
     * - `match_end` - When the match concludes
     * - `error` - If an error occurs
     * - `pong` - Response to client ping
     *
     * ## Client Messages
     *
     * Send JSON to control the simulation:
     * - `{"action": "ping"}` - Keep-alive, server responds with `{"type": "pong"}`
     * - `{"action": "pause"}` - Pause the simulation
     * - `{"action": "resume"}` - Resume a paused simulation
     * - `{"action": "set_speed", "speed": 2.0}` - Change playback speed (0.1-10.0)
     * - `{"action": "get_status"}` - Request current match status
     */
    suspend fun streamLive(
        params: MatchStreamLiveParams = MatchStreamLiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see streamLive */
    suspend fun streamLive(requestOptions: RequestOptions) =
        streamLive(MatchStreamLiveParams.none(), requestOptions)

    /** A view of [MatchServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): MatchServiceAsync.WithRawResponse

        fun commentary(): CommentaryServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /matches`, but is otherwise the same as
         * [MatchServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: MatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Match>

        /**
         * Returns a raw HTTP response for `get /matches/{match_id}`, but is otherwise the same as
         * [MatchServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            matchId: String,
            params: MatchRetrieveParams = MatchRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Match> =
            retrieve(params.toBuilder().matchId(matchId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: MatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Match>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            matchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Match> = retrieve(matchId, MatchRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /matches/{match_id}`, but is otherwise the same as
         * [MatchServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            matchId: String,
            params: MatchUpdateParams = MatchUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Match> =
            update(params.toBuilder().matchId(matchId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: MatchUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Match>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            matchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Match> = update(matchId, MatchUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /matches`, but is otherwise the same as
         * [MatchServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: MatchListParams = MatchListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MatchListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<MatchListPageAsync> =
            list(MatchListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /matches/{match_id}`, but is otherwise the same
         * as [MatchServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            matchId: String,
            params: MatchDeleteParams = MatchDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().matchId(matchId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: MatchDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(matchId: String, requestOptions: RequestOptions): HttpResponse =
            delete(matchId, MatchDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /matches/{match_id}/lesson`, but is otherwise the
         * same as [MatchServiceAsync.getLesson].
         */
        @MustBeClosed
        suspend fun getLesson(
            matchId: String,
            params: MatchGetLessonParams = MatchGetLessonParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MatchGetLessonResponse> =
            getLesson(params.toBuilder().matchId(matchId).build(), requestOptions)

        /** @see getLesson */
        @MustBeClosed
        suspend fun getLesson(
            params: MatchGetLessonParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MatchGetLessonResponse>

        /** @see getLesson */
        @MustBeClosed
        suspend fun getLesson(
            matchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MatchGetLessonResponse> =
            getLesson(matchId, MatchGetLessonParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /matches/{match_id}/turning-points`, but is
         * otherwise the same as [MatchServiceAsync.getTurningPoints].
         */
        @MustBeClosed
        suspend fun getTurningPoints(
            matchId: String,
            params: MatchGetTurningPointsParams = MatchGetTurningPointsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<MatchGetTurningPointsResponse>> =
            getTurningPoints(params.toBuilder().matchId(matchId).build(), requestOptions)

        /** @see getTurningPoints */
        @MustBeClosed
        suspend fun getTurningPoints(
            params: MatchGetTurningPointsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<MatchGetTurningPointsResponse>>

        /** @see getTurningPoints */
        @MustBeClosed
        suspend fun getTurningPoints(
            matchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<MatchGetTurningPointsResponse>> =
            getTurningPoints(matchId, MatchGetTurningPointsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /matches/live`, but is otherwise the same as
         * [MatchServiceAsync.streamLive].
         */
        @MustBeClosed
        suspend fun streamLive(
            params: MatchStreamLiveParams = MatchStreamLiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see streamLive */
        @MustBeClosed
        suspend fun streamLive(requestOptions: RequestOptions): HttpResponse =
            streamLive(MatchStreamLiveParams.none(), requestOptions)
    }
}
