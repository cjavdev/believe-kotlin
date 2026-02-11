// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.teammembers

import com.believe.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CoachTest {

    @Test
    fun create() {
        val coach =
            Coach.builder()
                .id("ted-lasso-richmond")
                .characterId("ted-lasso")
                .specialty(CoachSpecialty.HEAD_COACH)
                .teamId("afc-richmond")
                .yearsWithTeam(2L)
                .addCertification("NCAA Division II")
                .memberType(Coach.MemberType.COACH)
                .winRate(0.55)
                .build()

        assertThat(coach.id()).isEqualTo("ted-lasso-richmond")
        assertThat(coach.characterId()).isEqualTo("ted-lasso")
        assertThat(coach.specialty()).isEqualTo(CoachSpecialty.HEAD_COACH)
        assertThat(coach.teamId()).isEqualTo("afc-richmond")
        assertThat(coach.yearsWithTeam()).isEqualTo(2L)
        assertThat(coach.certifications()).containsExactly("NCAA Division II")
        assertThat(coach.memberType()).isEqualTo(Coach.MemberType.COACH)
        assertThat(coach.winRate()).isEqualTo(0.55)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val coach =
            Coach.builder()
                .id("ted-lasso-richmond")
                .characterId("ted-lasso")
                .specialty(CoachSpecialty.HEAD_COACH)
                .teamId("afc-richmond")
                .yearsWithTeam(2L)
                .addCertification("NCAA Division II")
                .memberType(Coach.MemberType.COACH)
                .winRate(0.55)
                .build()

        val roundtrippedCoach =
            jsonMapper.readValue(jsonMapper.writeValueAsString(coach), jacksonTypeRef<Coach>())

        assertThat(roundtrippedCoach).isEqualTo(coach)
    }
}
