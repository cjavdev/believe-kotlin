// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.client.okhttp.BelieveOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class HealthServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun check() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val healthServiceAsync = client.health()

        val response = healthServiceAsync.check()

        response.validate()
    }
}
