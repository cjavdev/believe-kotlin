// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.TestServerExtension
import com.believe.api.client.okhttp.BelieveOkHttpClientAsync
import com.believe.api.models.quotes.QuoteCreateParams
import com.believe.api.models.quotes.QuoteGetRandomParams
import com.believe.api.models.quotes.QuoteMoment
import com.believe.api.models.quotes.QuoteTheme
import com.believe.api.models.quotes.QuoteUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class QuoteServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun create() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val quoteServiceAsync = client.quotes()

        val quote =
            quoteServiceAsync.create(
                QuoteCreateParams.builder()
                    .characterId("ted-lasso")
                    .context("Ted's first team meeting, revealing his coaching philosophy")
                    .momentType(QuoteMoment.LOCKER_ROOM)
                    .text("I believe in believe.")
                    .theme(QuoteTheme.BELIEF)
                    .episodeId("s01e01")
                    .isFunny(false)
                    .isInspirational(true)
                    .popularityScore(98.5)
                    .addSecondaryTheme(QuoteTheme.LEADERSHIP)
                    .addSecondaryTheme(QuoteTheme.TEAMWORK)
                    .timesShared(250000L)
                    .build()
            )

        quote.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun retrieve() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val quoteServiceAsync = client.quotes()

        val quote = quoteServiceAsync.retrieve("quote_id")

        quote.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun update() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val quoteServiceAsync = client.quotes()

        val quote =
            quoteServiceAsync.update(
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
            )

        quote.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun list() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val quoteServiceAsync = client.quotes()

        val page = quoteServiceAsync.list()

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
        val quoteServiceAsync = client.quotes()

        quoteServiceAsync.delete("quote_id")
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun getRandom() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val quoteServiceAsync = client.quotes()

        val quote =
            quoteServiceAsync.getRandom(
                QuoteGetRandomParams.builder()
                    .characterId("character_id")
                    .inspirational(true)
                    .theme(QuoteTheme.BELIEF)
                    .build()
            )

        quote.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun listByCharacter() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val quoteServiceAsync = client.quotes()

        val page = quoteServiceAsync.listByCharacter("character_id")

        page.response().validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun listByTheme() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val quoteServiceAsync = client.quotes()

        val page = quoteServiceAsync.listByTheme(QuoteTheme.BELIEF)

        page.response().validate()
    }
}
