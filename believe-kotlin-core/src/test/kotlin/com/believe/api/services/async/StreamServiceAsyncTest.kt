// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.TestServerExtension
import com.believe.api.client.okhttp.BelieveOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StreamServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun testConnection() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val streamServiceAsync = client.stream()

        val response = streamServiceAsync.testConnection()

        response.validate()
    }
}
