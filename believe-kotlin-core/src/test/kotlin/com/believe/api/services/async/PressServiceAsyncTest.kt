// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.client.okhttp.BelieveOkHttpClientAsync
import com.believe.api.models.press.PressSimulateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PressServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun simulate() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val pressServiceAsync = client.press()

        val response =
            pressServiceAsync.simulate(
                PressSimulateParams.builder()
                    .question(
                        "Ted, your team just lost 5-0. How do you explain this embarrassing defeat?"
                    )
                    .hostile(true)
                    .topic("match_result")
                    .build()
            )

        response.validate()
    }
}
