// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.blocking

import com.believe.api.core.ClientOptions
import com.believe.api.services.blocking.client.WService
import com.believe.api.services.blocking.client.WServiceImpl

class ClientServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ClientService {

    private val withRawResponse: ClientService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val ws: WService by lazy { WServiceImpl(clientOptions) }

    override fun withRawResponse(): ClientService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ClientService =
        ClientServiceImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun ws(): WService = ws

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ClientService.WithRawResponse {

        private val ws: WService.WithRawResponse by lazy {
            WServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ClientService.WithRawResponse =
            ClientServiceImpl.WithRawResponseImpl(clientOptions.toBuilder().apply(modifier).build())

        override fun ws(): WService.WithRawResponse = ws
    }
}
