// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async.teams

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.checkRequired
import com.believe.api.core.handlers.emptyHandler
import com.believe.api.core.handlers.errorBodyHandler
import com.believe.api.core.handlers.errorHandler
import com.believe.api.core.handlers.jsonHandler
import com.believe.api.core.http.HttpMethod
import com.believe.api.core.http.HttpRequest
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponse.Handler
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.core.http.json
import com.believe.api.core.http.multipartFormData
import com.believe.api.core.http.parseable
import com.believe.api.core.prepareAsync
import com.believe.api.models.teams.logo.FileUpload
import com.believe.api.models.teams.logo.LogoDeleteParams
import com.believe.api.models.teams.logo.LogoDownloadParams
import com.believe.api.models.teams.logo.LogoDownloadResponse
import com.believe.api.models.teams.logo.LogoUploadParams

class LogoServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    LogoServiceAsync {

    private val withRawResponse: LogoServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): LogoServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): LogoServiceAsync =
        LogoServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun delete(params: LogoDeleteParams, requestOptions: RequestOptions) {
        // delete /teams/{team_id}/logo/{file_id}
        withRawResponse().delete(params, requestOptions)
    }

    override suspend fun download(
        params: LogoDownloadParams,
        requestOptions: RequestOptions,
    ): LogoDownloadResponse =
        // get /teams/{team_id}/logo/{file_id}
        withRawResponse().download(params, requestOptions).parse()

    override suspend fun upload(
        params: LogoUploadParams,
        requestOptions: RequestOptions,
    ): FileUpload =
        // post /teams/{team_id}/logo
        withRawResponse().upload(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        LogoServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): LogoServiceAsync.WithRawResponse =
            LogoServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: LogoDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("teams", params._pathParam(0), "logo", params._pathParam(1))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val downloadHandler: Handler<LogoDownloadResponse> =
            jsonHandler<LogoDownloadResponse>(clientOptions.jsonMapper)

        override suspend fun download(
            params: LogoDownloadParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<LogoDownloadResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("teams", params._pathParam(0), "logo", params._pathParam(1))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { downloadHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val uploadHandler: Handler<FileUpload> =
            jsonHandler<FileUpload>(clientOptions.jsonMapper)

        override suspend fun upload(
            params: LogoUploadParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileUpload> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("teamId", params.teamId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("teams", params._pathParam(0), "logo")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { uploadHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
