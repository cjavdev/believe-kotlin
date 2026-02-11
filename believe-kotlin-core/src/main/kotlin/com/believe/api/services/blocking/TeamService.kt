// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.blocking

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
import com.believe.api.models.teams.TeamListPage
import com.believe.api.models.teams.TeamListParams
import com.believe.api.models.teams.TeamRetrieveParams
import com.believe.api.models.teams.TeamUpdateParams
import com.believe.api.models.teams.logo.FileUpload
import com.believe.api.services.blocking.teams.LogoService
import com.google.errorprone.annotations.MustBeClosed

interface TeamService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TeamService

    fun logo(): LogoService

    /** Add a new team to the league. */
    fun create(
        params: TeamCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Team

    /** Retrieve detailed information about a specific team. */
    fun retrieve(
        teamId: String,
        params: TeamRetrieveParams = TeamRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Team = retrieve(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        params: TeamRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Team

    /** @see retrieve */
    fun retrieve(teamId: String, requestOptions: RequestOptions): Team =
        retrieve(teamId, TeamRetrieveParams.none(), requestOptions)

    /** Update specific fields of an existing team. */
    fun update(
        teamId: String,
        params: TeamUpdateParams = TeamUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Team = update(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see update */
    fun update(
        params: TeamUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Team

    /** @see update */
    fun update(teamId: String, requestOptions: RequestOptions): Team =
        update(teamId, TeamUpdateParams.none(), requestOptions)

    /** Get a paginated list of all teams with optional filtering by league or culture score. */
    fun list(
        params: TeamListParams = TeamListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamListPage

    /** @see list */
    fun list(requestOptions: RequestOptions): TeamListPage =
        list(TeamListParams.none(), requestOptions)

    /** Remove a team from the database (relegation to oblivion). */
    fun delete(
        teamId: String,
        params: TeamDeleteParams = TeamDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see delete */
    fun delete(params: TeamDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(teamId: String, requestOptions: RequestOptions) =
        delete(teamId, TeamDeleteParams.none(), requestOptions)

    /** Get detailed culture and values information for a team. */
    fun getCulture(
        teamId: String,
        params: TeamGetCultureParams = TeamGetCultureParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamGetCultureResponse =
        getCulture(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see getCulture */
    fun getCulture(
        params: TeamGetCultureParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamGetCultureResponse

    /** @see getCulture */
    fun getCulture(teamId: String, requestOptions: RequestOptions): TeamGetCultureResponse =
        getCulture(teamId, TeamGetCultureParams.none(), requestOptions)

    /** Get all rival teams for a specific team. */
    fun getRivals(
        teamId: String,
        params: TeamGetRivalsParams = TeamGetRivalsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Team> = getRivals(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see getRivals */
    fun getRivals(
        params: TeamGetRivalsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Team>

    /** @see getRivals */
    fun getRivals(teamId: String, requestOptions: RequestOptions): List<Team> =
        getRivals(teamId, TeamGetRivalsParams.none(), requestOptions)

    /** List all uploaded logos for a team. */
    fun listLogos(
        teamId: String,
        params: TeamListLogosParams = TeamListLogosParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<FileUpload> = listLogos(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see listLogos */
    fun listLogos(
        params: TeamListLogosParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<FileUpload>

    /** @see listLogos */
    fun listLogos(teamId: String, requestOptions: RequestOptions): List<FileUpload> =
        listLogos(teamId, TeamListLogosParams.none(), requestOptions)

    /** A view of [TeamService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TeamService.WithRawResponse

        fun logo(): LogoService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /teams`, but is otherwise the same as
         * [TeamService.create].
         */
        @MustBeClosed
        fun create(
            params: TeamCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Team>

        /**
         * Returns a raw HTTP response for `get /teams/{team_id}`, but is otherwise the same as
         * [TeamService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            teamId: String,
            params: TeamRetrieveParams = TeamRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Team> =
            retrieve(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: TeamRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Team>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(teamId: String, requestOptions: RequestOptions): HttpResponseFor<Team> =
            retrieve(teamId, TeamRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /teams/{team_id}`, but is otherwise the same as
         * [TeamService.update].
         */
        @MustBeClosed
        fun update(
            teamId: String,
            params: TeamUpdateParams = TeamUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Team> = update(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            params: TeamUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Team>

        /** @see update */
        @MustBeClosed
        fun update(teamId: String, requestOptions: RequestOptions): HttpResponseFor<Team> =
            update(teamId, TeamUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /teams`, but is otherwise the same as
         * [TeamService.list].
         */
        @MustBeClosed
        fun list(
            params: TeamListParams = TeamListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamListPage>

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<TeamListPage> =
            list(TeamListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /teams/{team_id}`, but is otherwise the same as
         * [TeamService.delete].
         */
        @MustBeClosed
        fun delete(
            teamId: String,
            params: TeamDeleteParams = TeamDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: TeamDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(teamId: String, requestOptions: RequestOptions): HttpResponse =
            delete(teamId, TeamDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /teams/{team_id}/culture`, but is otherwise the same
         * as [TeamService.getCulture].
         */
        @MustBeClosed
        fun getCulture(
            teamId: String,
            params: TeamGetCultureParams = TeamGetCultureParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamGetCultureResponse> =
            getCulture(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see getCulture */
        @MustBeClosed
        fun getCulture(
            params: TeamGetCultureParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamGetCultureResponse>

        /** @see getCulture */
        @MustBeClosed
        fun getCulture(
            teamId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TeamGetCultureResponse> =
            getCulture(teamId, TeamGetCultureParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /teams/{team_id}/rivals`, but is otherwise the same
         * as [TeamService.getRivals].
         */
        @MustBeClosed
        fun getRivals(
            teamId: String,
            params: TeamGetRivalsParams = TeamGetRivalsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Team>> =
            getRivals(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see getRivals */
        @MustBeClosed
        fun getRivals(
            params: TeamGetRivalsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Team>>

        /** @see getRivals */
        @MustBeClosed
        fun getRivals(teamId: String, requestOptions: RequestOptions): HttpResponseFor<List<Team>> =
            getRivals(teamId, TeamGetRivalsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /teams/{team_id}/logos`, but is otherwise the same
         * as [TeamService.listLogos].
         */
        @MustBeClosed
        fun listLogos(
            teamId: String,
            params: TeamListLogosParams = TeamListLogosParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<FileUpload>> =
            listLogos(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see listLogos */
        @MustBeClosed
        fun listLogos(
            params: TeamListLogosParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<FileUpload>>

        /** @see listLogos */
        @MustBeClosed
        fun listLogos(
            teamId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<FileUpload>> =
            listLogos(teamId, TeamListLogosParams.none(), requestOptions)
    }
}
