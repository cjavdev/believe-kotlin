// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.teams

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TeamUpdateParamsTest {

    @Test
    fun create() {
        TeamUpdateParams.builder()
            .teamId("team_id")
            .annualBudgetGbp(0.0)
            .averageAttendance(0.0)
            .contactEmail("dev@stainless.com")
            .cultureScore(0L)
            .foundedYear(1800L)
            .isActive(true)
            .league(League.PREMIER_LEAGUE)
            .name("x")
            .nickname("nickname")
            .primaryColor("primary_color")
            .addRivalTeam("string")
            .secondaryColor("secondary_color")
            .stadium("stadium")
            .stadiumLocation(GeoLocation.builder().latitude(51.4816).longitude(-0.191).build())
            .values(
                TeamValues.builder()
                    .primaryValue("Believe")
                    .secondaryValues(listOf("Family", "Resilience", "Joy"))
                    .teamMotto("Football is life!")
                    .build()
            )
            .website("https://example.com")
            .winPercentage(0.0)
            .build()
    }

    @Test
    fun pathParams() {
        val params = TeamUpdateParams.builder().teamId("team_id").build()

        assertThat(params._pathParam(0)).isEqualTo("team_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            TeamUpdateParams.builder()
                .teamId("team_id")
                .annualBudgetGbp(0.0)
                .averageAttendance(0.0)
                .contactEmail("dev@stainless.com")
                .cultureScore(0L)
                .foundedYear(1800L)
                .isActive(true)
                .league(League.PREMIER_LEAGUE)
                .name("x")
                .nickname("nickname")
                .primaryColor("primary_color")
                .addRivalTeam("string")
                .secondaryColor("secondary_color")
                .stadium("stadium")
                .stadiumLocation(GeoLocation.builder().latitude(51.4816).longitude(-0.191).build())
                .values(
                    TeamValues.builder()
                        .primaryValue("Believe")
                        .secondaryValues(listOf("Family", "Resilience", "Joy"))
                        .teamMotto("Football is life!")
                        .build()
                )
                .website("https://example.com")
                .winPercentage(0.0)
                .build()

        val body = params._body()

        assertThat(body.annualBudgetGbp()).isEqualTo(TeamUpdateParams.AnnualBudgetGbp.ofDouble(0.0))
        assertThat(body.averageAttendance()).isEqualTo(0.0)
        assertThat(body.contactEmail()).isEqualTo("dev@stainless.com")
        assertThat(body.cultureScore()).isEqualTo(0L)
        assertThat(body.foundedYear()).isEqualTo(1800L)
        assertThat(body.isActive()).isEqualTo(true)
        assertThat(body.league()).isEqualTo(League.PREMIER_LEAGUE)
        assertThat(body.name()).isEqualTo("x")
        assertThat(body.nickname()).isEqualTo("nickname")
        assertThat(body.primaryColor()).isEqualTo("primary_color")
        assertThat(body.rivalTeams()).containsExactly("string")
        assertThat(body.secondaryColor()).isEqualTo("secondary_color")
        assertThat(body.stadium()).isEqualTo("stadium")
        assertThat(body.stadiumLocation())
            .isEqualTo(GeoLocation.builder().latitude(51.4816).longitude(-0.191).build())
        assertThat(body.values())
            .isEqualTo(
                TeamValues.builder()
                    .primaryValue("Believe")
                    .secondaryValues(listOf("Family", "Resilience", "Joy"))
                    .teamMotto("Football is life!")
                    .build()
            )
        assertThat(body.website()).isEqualTo("https://example.com")
        assertThat(body.winPercentage()).isEqualTo(0.0)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = TeamUpdateParams.builder().teamId("team_id").build()

        val body = params._body()
    }
}
