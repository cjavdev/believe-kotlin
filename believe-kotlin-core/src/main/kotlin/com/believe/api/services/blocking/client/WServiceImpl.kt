// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.blocking.client

import com.believe.api.core.ClientOptions

class WServiceImpl internal constructor(private val clientOptions: ClientOptions) : WService {

    private val withRawResponse: WService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): WService =
        WServiceImpl(clientOptions.toBuilder().apply(modifier).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WService.WithRawResponse {

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): WService.WithRawResponse =
            WServiceImpl.WithRawResponseImpl(clientOptions.toBuilder().apply(modifier).build())
    }
}
