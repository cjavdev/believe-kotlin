// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.teams

import com.believe.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TeamTest {

    @Test
    fun create() {
        val team =
            Team.builder()
                .id("afc-richmond")
                .cultureScore(85L)
                .foundedYear(1897L)
                .league(League.PREMIER_LEAGUE)
                .name("AFC Richmond")
                .stadium("Nelson Road")
                .values(
                    TeamValues.builder()
                        .primaryValue("Believe")
                        .secondaryValues(listOf("Family", "Resilience", "Joy"))
                        .teamMotto("Football is life!")
                        .build()
                )
                .annualBudgetGbp("50000000.00")
                .averageAttendance(24500.5)
                .contactEmail("info@afcrichmond.com")
                .isActive(true)
                .nickname("The Greyhounds")
                .primaryColor("#0033A0")
                .addRivalTeam("west-ham")
                .addRivalTeam("rupert-fc")
                .secondaryColor("#FFFFFF")
                .stadiumLocation(GeoLocation.builder().latitude(51.4816).longitude(-0.191).build())
                .website("https://www.afcrichmond.com")
                .winPercentage(45.5)
                .build()

        assertThat(team.id()).isEqualTo("afc-richmond")
        assertThat(team.cultureScore()).isEqualTo(85L)
        assertThat(team.foundedYear()).isEqualTo(1897L)
        assertThat(team.league()).isEqualTo(League.PREMIER_LEAGUE)
        assertThat(team.name()).isEqualTo("AFC Richmond")
        assertThat(team.stadium()).isEqualTo("Nelson Road")
        assertThat(team.values())
            .isEqualTo(
                TeamValues.builder()
                    .primaryValue("Believe")
                    .secondaryValues(listOf("Family", "Resilience", "Joy"))
                    .teamMotto("Football is life!")
                    .build()
            )
        assertThat(team.annualBudgetGbp()).isEqualTo("50000000.00")
        assertThat(team.averageAttendance()).isEqualTo(24500.5)
        assertThat(team.contactEmail()).isEqualTo("info@afcrichmond.com")
        assertThat(team.isActive()).isEqualTo(true)
        assertThat(team.nickname()).isEqualTo("The Greyhounds")
        assertThat(team.primaryColor()).isEqualTo("#0033A0")
        assertThat(team.rivalTeams()).containsExactly("west-ham", "rupert-fc")
        assertThat(team.secondaryColor()).isEqualTo("#FFFFFF")
        assertThat(team.stadiumLocation())
            .isEqualTo(GeoLocation.builder().latitude(51.4816).longitude(-0.191).build())
        assertThat(team.website()).isEqualTo("https://www.afcrichmond.com")
        assertThat(team.winPercentage()).isEqualTo(45.5)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val team =
            Team.builder()
                .id("afc-richmond")
                .cultureScore(85L)
                .foundedYear(1897L)
                .league(League.PREMIER_LEAGUE)
                .name("AFC Richmond")
                .stadium("Nelson Road")
                .values(
                    TeamValues.builder()
                        .primaryValue("Believe")
                        .secondaryValues(listOf("Family", "Resilience", "Joy"))
                        .teamMotto("Football is life!")
                        .build()
                )
                .annualBudgetGbp("50000000.00")
                .averageAttendance(24500.5)
                .contactEmail("info@afcrichmond.com")
                .isActive(true)
                .nickname("The Greyhounds")
                .primaryColor("#0033A0")
                .addRivalTeam("west-ham")
                .addRivalTeam("rupert-fc")
                .secondaryColor("#FFFFFF")
                .stadiumLocation(GeoLocation.builder().latitude(51.4816).longitude(-0.191).build())
                .website("https://www.afcrichmond.com")
                .winPercentage(45.5)
                .build()

        val roundtrippedTeam =
            jsonMapper.readValue(jsonMapper.writeValueAsString(team), jacksonTypeRef<Team>())

        assertThat(roundtrippedTeam).isEqualTo(team)
    }
}
