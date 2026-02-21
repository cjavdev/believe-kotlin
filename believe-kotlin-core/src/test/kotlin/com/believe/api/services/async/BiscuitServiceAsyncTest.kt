// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.client.okhttp.BelieveOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class BiscuitServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val biscuitServiceAsync = client.biscuits()

        val biscuit = biscuitServiceAsync.retrieve("biscuit_id")

        biscuit.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val biscuitServiceAsync = client.biscuits()

        val page = biscuitServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun getFresh() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val biscuitServiceAsync = client.biscuits()

        val biscuit = biscuitServiceAsync.getFresh()

        biscuit.validate()
    }
}
