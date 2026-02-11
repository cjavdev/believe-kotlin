// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.TestServerExtension
import com.believe.api.client.okhttp.BelieveOkHttpClientAsync
import com.believe.api.models.teammembers.Position
import com.believe.api.models.teammembers.TeamMemberCreateParams
import com.believe.api.models.teammembers.TeamMemberUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TeamMemberServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun create() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val teamMemberServiceAsync = client.teamMembers()

        val teamMember =
            teamMemberServiceAsync.create(
                TeamMemberCreateParams.builder()
                    .member(
                        TeamMemberCreateParams.Member.Player.builder()
                            .characterId("jamie-tartt")
                            .jerseyNumber(9L)
                            .position(Position.FORWARD)
                            .teamId("afc-richmond")
                            .yearsWithTeam(3L)
                            .assists(23L)
                            .goalsScored(47L)
                            .isCaptain(false)
                            .memberType(TeamMemberCreateParams.Member.Player.MemberType.PLAYER)
                            .build()
                    )
                    .build()
            )

        teamMember.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun retrieve() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val teamMemberServiceAsync = client.teamMembers()

        val teamMember = teamMemberServiceAsync.retrieve("member_id")

        teamMember.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun update() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val teamMemberServiceAsync = client.teamMembers()

        val teamMember =
            teamMemberServiceAsync.update(
                TeamMemberUpdateParams.builder()
                    .memberId("member_id")
                    .updates(
                        TeamMemberUpdateParams.Updates.PlayerUpdate.builder()
                            .assists(0L)
                            .goalsScored(0L)
                            .isCaptain(true)
                            .jerseyNumber(1L)
                            .position(Position.GOALKEEPER)
                            .teamId("team_id")
                            .yearsWithTeam(0L)
                            .build()
                    )
                    .build()
            )

        teamMember.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun list() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val teamMemberServiceAsync = client.teamMembers()

        val page = teamMemberServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun delete() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val teamMemberServiceAsync = client.teamMembers()

        teamMemberServiceAsync.delete("member_id")
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun listCoaches() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val teamMemberServiceAsync = client.teamMembers()

        val page = teamMemberServiceAsync.listCoaches()

        page.response().validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun listPlayers() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val teamMemberServiceAsync = client.teamMembers()

        val page = teamMemberServiceAsync.listPlayers()

        page.response().validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun listStaff() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val teamMemberServiceAsync = client.teamMembers()

        val page = teamMemberServiceAsync.listStaff()

        page.response().validate()
    }
}
