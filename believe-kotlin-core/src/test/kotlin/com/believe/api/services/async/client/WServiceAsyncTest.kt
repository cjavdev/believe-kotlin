// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async.client

import com.believe.api.client.okhttp.BelieveOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun test() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val wServiceAsync = client.client().ws()

        wServiceAsync.test()
    }
}
