// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async.teams

import com.believe.api.client.okhttp.BelieveOkHttpClientAsync
import com.believe.api.models.teams.logo.LogoDeleteParams
import com.believe.api.models.teams.logo.LogoDownloadParams
import com.believe.api.models.teams.logo.LogoUploadParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class LogoServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val logoServiceAsync = client.teams().logo()

        logoServiceAsync.delete(
            LogoDeleteParams.builder()
                .teamId("team_id")
                .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        )
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun download() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val logoServiceAsync = client.teams().logo()

        val response =
            logoServiceAsync.download(
                LogoDownloadParams.builder()
                    .teamId("team_id")
                    .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun upload() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val logoServiceAsync = client.teams().logo()

        val fileUpload =
            logoServiceAsync.upload(
                LogoUploadParams.builder()
                    .teamId("team_id")
                    .file("some content".byteInputStream())
                    .build()
            )

        fileUpload.validate()
    }
}
