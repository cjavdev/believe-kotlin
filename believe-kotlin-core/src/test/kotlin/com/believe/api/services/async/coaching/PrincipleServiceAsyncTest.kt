// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async.coaching

import com.believe.api.TestServerExtension
import com.believe.api.client.okhttp.BelieveOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class PrincipleServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun retrieve() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val principleServiceAsync = client.coaching().principles()

        val coachingPrinciple = principleServiceAsync.retrieve("principle_id")

        coachingPrinciple.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun list() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val principleServiceAsync = client.coaching().principles()

        val page = principleServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    suspend fun getRandom() {
        val client =
            BelieveOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val principleServiceAsync = client.coaching().principles()

        val coachingPrinciple = principleServiceAsync.getRandom()

        coachingPrinciple.validate()
    }
}
