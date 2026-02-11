// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.quotes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QuoteUpdateParamsTest {

    @Test
    fun create() {
        QuoteUpdateParams.builder()
            .quoteId("quote_id")
            .characterId("character_id")
            .context("context")
            .episodeId("episode_id")
            .isFunny(true)
            .isInspirational(true)
            .momentType(QuoteMoment.HALFTIME_SPEECH)
            .popularityScore(0.0)
            .addSecondaryTheme(QuoteTheme.BELIEF)
            .text("x")
            .theme(QuoteTheme.BELIEF)
            .timesShared(0L)
            .build()
    }

    @Test
    fun pathParams() {
        val params = QuoteUpdateParams.builder().quoteId("quote_id").build()

        assertThat(params._pathParam(0)).isEqualTo("quote_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            QuoteUpdateParams.builder()
                .quoteId("quote_id")
                .characterId("character_id")
                .context("context")
                .episodeId("episode_id")
                .isFunny(true)
                .isInspirational(true)
                .momentType(QuoteMoment.HALFTIME_SPEECH)
                .popularityScore(0.0)
                .addSecondaryTheme(QuoteTheme.BELIEF)
                .text("x")
                .theme(QuoteTheme.BELIEF)
                .timesShared(0L)
                .build()

        val body = params._body()

        assertThat(body.characterId()).isEqualTo("character_id")
        assertThat(body.context()).isEqualTo("context")
        assertThat(body.episodeId()).isEqualTo("episode_id")
        assertThat(body.isFunny()).isEqualTo(true)
        assertThat(body.isInspirational()).isEqualTo(true)
        assertThat(body.momentType()).isEqualTo(QuoteMoment.HALFTIME_SPEECH)
        assertThat(body.popularityScore()).isEqualTo(0.0)
        assertThat(body.secondaryThemes()).containsExactly(QuoteTheme.BELIEF)
        assertThat(body.text()).isEqualTo("x")
        assertThat(body.theme()).isEqualTo(QuoteTheme.BELIEF)
        assertThat(body.timesShared()).isEqualTo(0L)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = QuoteUpdateParams.builder().quoteId("quote_id").build()

        val body = params._body()
    }
}
