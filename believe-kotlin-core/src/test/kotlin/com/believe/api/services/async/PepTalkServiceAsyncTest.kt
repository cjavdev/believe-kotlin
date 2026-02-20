// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.client.okhttp.BelieveOkHttpClientAsync
import com.believe.api.models.peptalk.PepTalkRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PepTalkServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val pepTalkServiceAsync = client.pepTalk()

        val pepTalk =
            pepTalkServiceAsync.retrieve(PepTalkRetrieveParams.builder().stream(true).build())

        pepTalk.validate()
    }
}
