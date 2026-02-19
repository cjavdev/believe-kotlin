// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.teammembers.TeamMemberCreateParams
import com.believe.api.models.teammembers.TeamMemberCreateResponse
import com.believe.api.models.teammembers.TeamMemberDeleteParams
import com.believe.api.models.teammembers.TeamMemberListCoachesPageAsync
import com.believe.api.models.teammembers.TeamMemberListCoachesParams
import com.believe.api.models.teammembers.TeamMemberListPageAsync
import com.believe.api.models.teammembers.TeamMemberListParams
import com.believe.api.models.teammembers.TeamMemberListPlayersPageAsync
import com.believe.api.models.teammembers.TeamMemberListPlayersParams
import com.believe.api.models.teammembers.TeamMemberListStaffPageAsync
import com.believe.api.models.teammembers.TeamMemberListStaffParams
import com.believe.api.models.teammembers.TeamMemberRetrieveParams
import com.believe.api.models.teammembers.TeamMemberRetrieveResponse
import com.believe.api.models.teammembers.TeamMemberUpdateParams
import com.believe.api.models.teammembers.TeamMemberUpdateResponse
import com.google.errorprone.annotations.MustBeClosed

interface TeamMemberServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TeamMemberServiceAsync

    /**
     * Add a new team member to a team.
     *
     * The request body is a **union type (oneOf)** - you must include the `member_type`
     * discriminator field:
     * - `"member_type": "player"` - Creates a player (requires position, jersey_number, etc.)
     * - `"member_type": "coach"` - Creates a coach (requires specialty, etc.)
     * - `"member_type": "medical_staff"` - Creates medical staff (requires medical specialty, etc.)
     * - `"member_type": "equipment_manager"` - Creates equipment manager (requires
     *   responsibilities, etc.)
     *
     * The `character_id` field references an existing character from `/characters/{id}`.
     *
     * **Example for creating a player:**
     *
     * ```json
     * {
     *   "member_type": "player",
     *   "character_id": "sam-obisanya",
     *   "team_id": "afc-richmond",
     *   "years_with_team": 2,
     *   "position": "midfielder",
     *   "jersey_number": 24,
     *   "goals_scored": 12,
     *   "assists": 15
     * }
     * ```
     */
    suspend fun create(
        params: TeamMemberCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberCreateResponse

    /** @see create */
    suspend fun create(
        member: TeamMemberCreateParams.Member,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberCreateResponse =
        create(TeamMemberCreateParams.builder().member(member).build(), requestOptions)

    /** @see create */
    suspend fun create(
        player: TeamMemberCreateParams.Member.Player,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberCreateResponse =
        create(TeamMemberCreateParams.Member.ofPlayer(player), requestOptions)

    /** @see create */
    suspend fun create(
        coach: TeamMemberCreateParams.Member.Coach,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberCreateResponse =
        create(TeamMemberCreateParams.Member.ofCoach(coach), requestOptions)

    /** @see create */
    suspend fun create(
        medicalStaff: TeamMemberCreateParams.Member.MedicalStaff,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberCreateResponse =
        create(TeamMemberCreateParams.Member.ofMedicalStaff(medicalStaff), requestOptions)

    /** @see create */
    suspend fun create(
        equipmentManager: TeamMemberCreateParams.Member.EquipmentManager,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberCreateResponse =
        create(TeamMemberCreateParams.Member.ofEquipmentManager(equipmentManager), requestOptions)

    /**
     * Retrieve detailed information about a specific team member.
     *
     * The response is a **union type (oneOf)** - the actual shape depends on the member's type:
     * - **player**: Includes position, jersey_number, goals_scored, assists, is_captain
     * - **coach**: Includes specialty, certifications, win_rate
     * - **medical_staff**: Includes specialty, qualifications, license_number
     * - **equipment_manager**: Includes responsibilities, is_head_kitman
     *
     * Use `character_id` to fetch full character details from `/characters/{character_id}`.
     */
    suspend fun retrieve(
        memberId: String,
        params: TeamMemberRetrieveParams = TeamMemberRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberRetrieveResponse =
        retrieve(params.toBuilder().memberId(memberId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: TeamMemberRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(
        memberId: String,
        requestOptions: RequestOptions,
    ): TeamMemberRetrieveResponse =
        retrieve(memberId, TeamMemberRetrieveParams.none(), requestOptions)

    /** Update specific fields of an existing team member. Fields vary by member type. */
    suspend fun update(
        memberId: String,
        params: TeamMemberUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberUpdateResponse =
        update(params.toBuilder().memberId(memberId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: TeamMemberUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberUpdateResponse

    /**
     * Get a paginated list of all team members.
     *
     * This endpoint demonstrates **union types (oneOf)** in the response. Each team member can be
     * one of: Player, Coach, MedicalStaff, or EquipmentManager. The `member_type` field acts as a
     * discriminator to determine the shape of each object.
     */
    suspend fun list(
        params: TeamMemberListParams = TeamMemberListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): TeamMemberListPageAsync =
        list(TeamMemberListParams.none(), requestOptions)

    /** Remove a team member from the roster. */
    suspend fun delete(
        memberId: String,
        params: TeamMemberDeleteParams = TeamMemberDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().memberId(memberId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: TeamMemberDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(memberId: String, requestOptions: RequestOptions) =
        delete(memberId, TeamMemberDeleteParams.none(), requestOptions)

    /** Get only coaches (filtered subset of team members). */
    suspend fun listCoaches(
        params: TeamMemberListCoachesParams = TeamMemberListCoachesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberListCoachesPageAsync

    /** @see listCoaches */
    suspend fun listCoaches(requestOptions: RequestOptions): TeamMemberListCoachesPageAsync =
        listCoaches(TeamMemberListCoachesParams.none(), requestOptions)

    /** Get only players (filtered subset of team members). */
    suspend fun listPlayers(
        params: TeamMemberListPlayersParams = TeamMemberListPlayersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberListPlayersPageAsync

    /** @see listPlayers */
    suspend fun listPlayers(requestOptions: RequestOptions): TeamMemberListPlayersPageAsync =
        listPlayers(TeamMemberListPlayersParams.none(), requestOptions)

    /**
     * Get all staff members (medical staff and equipment managers).
     *
     * This demonstrates a **narrower union type** - the response is oneOf MedicalStaff or
     * EquipmentManager.
     */
    suspend fun listStaff(
        params: TeamMemberListStaffParams = TeamMemberListStaffParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TeamMemberListStaffPageAsync

    /** @see listStaff */
    suspend fun listStaff(requestOptions: RequestOptions): TeamMemberListStaffPageAsync =
        listStaff(TeamMemberListStaffParams.none(), requestOptions)

    /**
     * A view of [TeamMemberServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): TeamMemberServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /team-members`, but is otherwise the same as
         * [TeamMemberServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: TeamMemberCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberCreateResponse>

        /** @see create */
        @MustBeClosed
        suspend fun create(
            member: TeamMemberCreateParams.Member,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberCreateResponse> =
            create(TeamMemberCreateParams.builder().member(member).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        suspend fun create(
            player: TeamMemberCreateParams.Member.Player,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberCreateResponse> =
            create(TeamMemberCreateParams.Member.ofPlayer(player), requestOptions)

        /** @see create */
        @MustBeClosed
        suspend fun create(
            coach: TeamMemberCreateParams.Member.Coach,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberCreateResponse> =
            create(TeamMemberCreateParams.Member.ofCoach(coach), requestOptions)

        /** @see create */
        @MustBeClosed
        suspend fun create(
            medicalStaff: TeamMemberCreateParams.Member.MedicalStaff,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberCreateResponse> =
            create(TeamMemberCreateParams.Member.ofMedicalStaff(medicalStaff), requestOptions)

        /** @see create */
        @MustBeClosed
        suspend fun create(
            equipmentManager: TeamMemberCreateParams.Member.EquipmentManager,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberCreateResponse> =
            create(
                TeamMemberCreateParams.Member.ofEquipmentManager(equipmentManager),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /team-members/{member_id}`, but is otherwise the
         * same as [TeamMemberServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            memberId: String,
            params: TeamMemberRetrieveParams = TeamMemberRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberRetrieveResponse> =
            retrieve(params.toBuilder().memberId(memberId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: TeamMemberRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            memberId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TeamMemberRetrieveResponse> =
            retrieve(memberId, TeamMemberRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /team-members/{member_id}`, but is otherwise the
         * same as [TeamMemberServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            memberId: String,
            params: TeamMemberUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberUpdateResponse> =
            update(params.toBuilder().memberId(memberId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: TeamMemberUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberUpdateResponse>

        /**
         * Returns a raw HTTP response for `get /team-members`, but is otherwise the same as
         * [TeamMemberServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: TeamMemberListParams = TeamMemberListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<TeamMemberListPageAsync> =
            list(TeamMemberListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /team-members/{member_id}`, but is otherwise the
         * same as [TeamMemberServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            memberId: String,
            params: TeamMemberDeleteParams = TeamMemberDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().memberId(memberId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: TeamMemberDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(memberId: String, requestOptions: RequestOptions): HttpResponse =
            delete(memberId, TeamMemberDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /team-members/coaches/`, but is otherwise the same
         * as [TeamMemberServiceAsync.listCoaches].
         */
        @MustBeClosed
        suspend fun listCoaches(
            params: TeamMemberListCoachesParams = TeamMemberListCoachesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberListCoachesPageAsync>

        /** @see listCoaches */
        @MustBeClosed
        suspend fun listCoaches(
            requestOptions: RequestOptions
        ): HttpResponseFor<TeamMemberListCoachesPageAsync> =
            listCoaches(TeamMemberListCoachesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /team-members/players/`, but is otherwise the same
         * as [TeamMemberServiceAsync.listPlayers].
         */
        @MustBeClosed
        suspend fun listPlayers(
            params: TeamMemberListPlayersParams = TeamMemberListPlayersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberListPlayersPageAsync>

        /** @see listPlayers */
        @MustBeClosed
        suspend fun listPlayers(
            requestOptions: RequestOptions
        ): HttpResponseFor<TeamMemberListPlayersPageAsync> =
            listPlayers(TeamMemberListPlayersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /team-members/staff/`, but is otherwise the same as
         * [TeamMemberServiceAsync.listStaff].
         */
        @MustBeClosed
        suspend fun listStaff(
            params: TeamMemberListStaffParams = TeamMemberListStaffParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TeamMemberListStaffPageAsync>

        /** @see listStaff */
        @MustBeClosed
        suspend fun listStaff(
            requestOptions: RequestOptions
        ): HttpResponseFor<TeamMemberListStaffPageAsync> =
            listStaff(TeamMemberListStaffParams.none(), requestOptions)
    }
}
