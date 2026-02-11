// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.teams.Team
import com.believe.api.models.teams.TeamCreateParams
import com.believe.api.models.teams.TeamDeleteParams
import com.believe.api.models.teams.TeamGetCultureParams
import com.believe.api.models.teams.TeamGetCultureResponse
import com.believe.api.models.teams.TeamGetRivalsParams
import com.believe.api.models.teams.TeamListLogosParams
import com.believe.api.models.teams.TeamListPageAsync
import com.believe.api.models.teams.TeamListParams
import com.believe.api.models.teams.TeamRetrieveParams
import com.believe.api.models.teams.TeamUpdateParams
import com.believe.api.models.teams.logo.FileUpload
import com.believe.api.services.async.teams.LogoServiceAsync
import com.google.errorprone.annotations.MustBeClosed

interface TeamServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TeamServiceAsync

    fun logo(): LogoServiceAsync

    /** Add a new team to the league. */
    suspend fun create(
        params: TeamCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Team

    /** Retrieve detailed information about a specific team. */
    suspend fun retrieve(
        teamId: String,
        params: TeamRetrieveParams = TeamRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Team = retrieve(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: TeamRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Team

    /** @see retrieve */
    suspend fun retrieve(teamId: String, requestOptions: RequestOptions): Team =
        retrieve(teamId, TeamRetrieveParams.none(), requestOptions)

    /** Update specific fields of an existing team. */
    suspend fun update(
        teamId: String,
        params: TeamUpdateParams = TeamUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Team = update(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: TeamUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Team

    /** @see update */
    suspend fun update(teamId: String, requestOptions: RequestOptions): Team =
        update(teamId, TeamUpdateParams.none(), requestOptions)

    /** Get a paginated list of all teams with optional filtering by league or culture score. */
    suspend fun list(
        params: TeamListParams = TeamListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): TeamListPageAsync =
        list(TeamListParams.none(), requestOptions)

    /** Remove a team from the database (relegation to oblivion). */
    suspend fun delete(
        teamId: String,
        params: TeamDeleteParams = TeamDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: TeamDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(teamId: String, requestOptions: RequestOptions) =
        delete(teamId, TeamDeleteParams.none(), requestOptions)

    /** Get detailed culture and values information for a team. */
    suspend fun getCulture(
        teamId: String,
        params: TeamGetCultureParams = TeamGetCultureParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamGetCultureResponse =
        getCulture(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see getCulture */
    suspend fun getCulture(
        params: TeamGetCultureParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamGetCultureResponse

    /** @see getCulture */
    suspend fun getCulture(teamId: String, requestOptions: RequestOptions): TeamGetCultureResponse =
        getCulture(teamId, TeamGetCultureParams.none(), requestOptions)

    /** Get all rival teams for a specific team. */
    suspend fun getRivals(
        teamId: String,
        params: TeamGetRivalsParams = TeamGetRivalsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Team> = getRivals(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see getRivals */
    suspend fun getRivals(
        params: TeamGetRivalsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Team>

    /** @see getRivals */
    suspend fun getRivals(teamId: String, requestOptions: RequestOptions): List<Team> =
        getRivals(teamId, TeamGetRivalsParams.none(), requestOptions)

    /** List all uploaded logos for a team. */
    suspend fun listLogos(
        teamId: String,
        params: TeamListLogosParams = TeamListLogosParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<FileUpload> = listLogos(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see listLogos */
    suspend fun listLogos(
        params: TeamListLogosParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<FileUpload>

    /** @see listLogos */
    suspend fun listLogos(teamId: String, requestOptions: RequestOptions): List<FileUpload> =
        listLogos(teamId, TeamListLogosParams.none(), requestOptions)

    /** A view of [TeamServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TeamServiceAsync.WithRawResponse

        fun logo(): LogoServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /teams`, but is otherwise the same as
         * [TeamServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: TeamCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Team>

        /**
         * Returns a raw HTTP response for `get /teams/{team_id}`, but is otherwise the same as
         * [TeamServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            teamId: String,
            params: TeamRetrieveParams = TeamRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Team> =
            retrieve(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: TeamRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Team>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            teamId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Team> = retrieve(teamId, TeamRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /teams/{team_id}`, but is otherwise the same as
         * [TeamServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            teamId: String,
            params: TeamUpdateParams = TeamUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Team> = update(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: TeamUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Team>

        /** @see update */
        @MustBeClosed
        suspend fun update(teamId: String, requestOptions: RequestOptions): HttpResponseFor<Team> =
            update(teamId, TeamUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /teams`, but is otherwise the same as
         * [TeamServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: TeamListParams = TeamListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<TeamListPageAsync> =
            list(TeamListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /teams/{team_id}`, but is otherwise the same as
         * [TeamServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            teamId: String,
            params: TeamDeleteParams = TeamDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: TeamDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(teamId: String, requestOptions: RequestOptions): HttpResponse =
            delete(teamId, TeamDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /teams/{team_id}/culture`, but is otherwise the same
         * as [TeamServiceAsync.getCulture].
         */
        @MustBeClosed
        suspend fun getCulture(
            teamId: String,
            params: TeamGetCultureParams = TeamGetCultureParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamGetCultureResponse> =
            getCulture(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see getCulture */
        @MustBeClosed
        suspend fun getCulture(
            params: TeamGetCultureParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamGetCultureResponse>

        /** @see getCulture */
        @MustBeClosed
        suspend fun getCulture(
            teamId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TeamGetCultureResponse> =
            getCulture(teamId, TeamGetCultureParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /teams/{team_id}/rivals`, but is otherwise the same
         * as [TeamServiceAsync.getRivals].
         */
        @MustBeClosed
        suspend fun getRivals(
            teamId: String,
            params: TeamGetRivalsParams = TeamGetRivalsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Team>> =
            getRivals(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see getRivals */
        @MustBeClosed
        suspend fun getRivals(
            params: TeamGetRivalsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Team>>

        /** @see getRivals */
        @MustBeClosed
        suspend fun getRivals(
            teamId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Team>> =
            getRivals(teamId, TeamGetRivalsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /teams/{team_id}/logos`, but is otherwise the same
         * as [TeamServiceAsync.listLogos].
         */
        @MustBeClosed
        suspend fun listLogos(
            teamId: String,
            params: TeamListLogosParams = TeamListLogosParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<FileUpload>> =
            listLogos(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see listLogos */
        @MustBeClosed
        suspend fun listLogos(
            params: TeamListLogosParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<FileUpload>>

        /** @see listLogos */
        @MustBeClosed
        suspend fun listLogos(
            teamId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<FileUpload>> =
            listLogos(teamId, TeamListLogosParams.none(), requestOptions)
    }
}
