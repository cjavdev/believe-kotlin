// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.characters

import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CharacterUpdateParamsTest {

    @Test
    fun create() {
        CharacterUpdateParams.builder()
            .characterId("character_id")
            .background("background")
            .dateOfBirth(LocalDate.parse("2019-12-27"))
            .email("dev@stainless.com")
            .emotionalStats(
                EmotionalStats.builder()
                    .curiosity(99L)
                    .empathy(100L)
                    .optimism(95L)
                    .resilience(90L)
                    .vulnerability(80L)
                    .build()
            )
            .addGrowthArc(
                GrowthArc.builder()
                    .breakthrough("breakthrough")
                    .challenge("challenge")
                    .endingPoint("ending_point")
                    .season(1L)
                    .startingPoint("starting_point")
                    .build()
            )
            .heightMeters(1.0)
            .name("x")
            .addPersonalityTrait("string")
            .profileImageUrl("https://example.com")
            .role(CharacterRole.COACH)
            .salaryGbp(0.0)
            .addSignatureQuote("string")
            .teamId("team_id")
            .build()
    }

    @Test
    fun pathParams() {
        val params = CharacterUpdateParams.builder().characterId("character_id").build()

        assertThat(params._pathParam(0)).isEqualTo("character_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            CharacterUpdateParams.builder()
                .characterId("character_id")
                .background("background")
                .dateOfBirth(LocalDate.parse("2019-12-27"))
                .email("dev@stainless.com")
                .emotionalStats(
                    EmotionalStats.builder()
                        .curiosity(99L)
                        .empathy(100L)
                        .optimism(95L)
                        .resilience(90L)
                        .vulnerability(80L)
                        .build()
                )
                .addGrowthArc(
                    GrowthArc.builder()
                        .breakthrough("breakthrough")
                        .challenge("challenge")
                        .endingPoint("ending_point")
                        .season(1L)
                        .startingPoint("starting_point")
                        .build()
                )
                .heightMeters(1.0)
                .name("x")
                .addPersonalityTrait("string")
                .profileImageUrl("https://example.com")
                .role(CharacterRole.COACH)
                .salaryGbp(0.0)
                .addSignatureQuote("string")
                .teamId("team_id")
                .build()

        val body = params._body()

        assertThat(body.background()).isEqualTo("background")
        assertThat(body.dateOfBirth()).isEqualTo(LocalDate.parse("2019-12-27"))
        assertThat(body.email()).isEqualTo("dev@stainless.com")
        assertThat(body.emotionalStats())
            .isEqualTo(
                EmotionalStats.builder()
                    .curiosity(99L)
                    .empathy(100L)
                    .optimism(95L)
                    .resilience(90L)
                    .vulnerability(80L)
                    .build()
            )
        assertThat(body.growthArcs())
            .containsExactly(
                GrowthArc.builder()
                    .breakthrough("breakthrough")
                    .challenge("challenge")
                    .endingPoint("ending_point")
                    .season(1L)
                    .startingPoint("starting_point")
                    .build()
            )
        assertThat(body.heightMeters()).isEqualTo(1.0)
        assertThat(body.name()).isEqualTo("x")
        assertThat(body.personalityTraits()).containsExactly("string")
        assertThat(body.profileImageUrl()).isEqualTo("https://example.com")
        assertThat(body.role()).isEqualTo(CharacterRole.COACH)
        assertThat(body.salaryGbp()).isEqualTo(CharacterUpdateParams.SalaryGbp.ofDouble(0.0))
        assertThat(body.signatureQuotes()).containsExactly("string")
        assertThat(body.teamId()).isEqualTo("team_id")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = CharacterUpdateParams.builder().characterId("character_id").build()

        val body = params._body()
    }
}
