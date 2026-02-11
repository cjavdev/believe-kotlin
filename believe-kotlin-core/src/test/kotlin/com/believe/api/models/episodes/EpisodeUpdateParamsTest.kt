// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.episodes

import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EpisodeUpdateParamsTest {

    @Test
    fun create() {
        EpisodeUpdateParams.builder()
            .episodeId("episode_id")
            .airDate(LocalDate.parse("2019-12-27"))
            .biscuitsWithBossMoment("biscuits_with_boss_moment")
            .addCharacterFocus("string")
            .director("director")
            .episodeNumber(1L)
            .mainTheme("main_theme")
            .addMemorableMoment("string")
            .runtimeMinutes(20L)
            .season(1L)
            .synopsis("synopsis")
            .tedWisdom("ted_wisdom")
            .title("x")
            .usViewersMillions(0.0)
            .viewerRating(0.0)
            .writer("writer")
            .build()
    }

    @Test
    fun pathParams() {
        val params = EpisodeUpdateParams.builder().episodeId("episode_id").build()

        assertThat(params._pathParam(0)).isEqualTo("episode_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            EpisodeUpdateParams.builder()
                .episodeId("episode_id")
                .airDate(LocalDate.parse("2019-12-27"))
                .biscuitsWithBossMoment("biscuits_with_boss_moment")
                .addCharacterFocus("string")
                .director("director")
                .episodeNumber(1L)
                .mainTheme("main_theme")
                .addMemorableMoment("string")
                .runtimeMinutes(20L)
                .season(1L)
                .synopsis("synopsis")
                .tedWisdom("ted_wisdom")
                .title("x")
                .usViewersMillions(0.0)
                .viewerRating(0.0)
                .writer("writer")
                .build()

        val body = params._body()

        assertThat(body.airDate()).isEqualTo(LocalDate.parse("2019-12-27"))
        assertThat(body.biscuitsWithBossMoment()).isEqualTo("biscuits_with_boss_moment")
        assertThat(body.characterFocus()).containsExactly("string")
        assertThat(body.director()).isEqualTo("director")
        assertThat(body.episodeNumber()).isEqualTo(1L)
        assertThat(body.mainTheme()).isEqualTo("main_theme")
        assertThat(body.memorableMoments()).containsExactly("string")
        assertThat(body.runtimeMinutes()).isEqualTo(20L)
        assertThat(body.season()).isEqualTo(1L)
        assertThat(body.synopsis()).isEqualTo("synopsis")
        assertThat(body.tedWisdom()).isEqualTo("ted_wisdom")
        assertThat(body.title()).isEqualTo("x")
        assertThat(body.usViewersMillions()).isEqualTo(0.0)
        assertThat(body.viewerRating()).isEqualTo(0.0)
        assertThat(body.writer()).isEqualTo("writer")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = EpisodeUpdateParams.builder().episodeId("episode_id").build()

        val body = params._body()
    }
}
