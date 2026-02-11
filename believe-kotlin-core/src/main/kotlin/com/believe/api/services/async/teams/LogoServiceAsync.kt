// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async.teams

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.teams.logo.FileUpload
import com.believe.api.models.teams.logo.LogoDeleteParams
import com.believe.api.models.teams.logo.LogoDownloadParams
import com.believe.api.models.teams.logo.LogoDownloadResponse
import com.believe.api.models.teams.logo.LogoUploadParams
import com.google.errorprone.annotations.MustBeClosed

interface LogoServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): LogoServiceAsync

    /** Delete a team's logo. */
    suspend fun delete(
        fileId: String,
        params: LogoDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: LogoDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** Download a team's logo by file ID. */
    suspend fun download(
        fileId: String,
        params: LogoDownloadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LogoDownloadResponse = download(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see download */
    suspend fun download(
        params: LogoDownloadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LogoDownloadResponse

    /** Upload a logo image for a team. Accepts image files (jpg, png, gif, webp). */
    suspend fun upload(
        teamId: String,
        params: LogoUploadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileUpload = upload(params.toBuilder().teamId(teamId).build(), requestOptions)

    /** @see upload */
    suspend fun upload(
        params: LogoUploadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileUpload

    /** A view of [LogoServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): LogoServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `delete /teams/{team_id}/logo/{file_id}`, but is
         * otherwise the same as [LogoServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            fileId: String,
            params: LogoDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: LogoDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `get /teams/{team_id}/logo/{file_id}`, but is otherwise
         * the same as [LogoServiceAsync.download].
         */
        @MustBeClosed
        suspend fun download(
            fileId: String,
            params: LogoDownloadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LogoDownloadResponse> =
            download(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see download */
        @MustBeClosed
        suspend fun download(
            params: LogoDownloadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LogoDownloadResponse>

        /**
         * Returns a raw HTTP response for `post /teams/{team_id}/logo`, but is otherwise the same
         * as [LogoServiceAsync.upload].
         */
        @MustBeClosed
        suspend fun upload(
            teamId: String,
            params: LogoUploadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileUpload> =
            upload(params.toBuilder().teamId(teamId).build(), requestOptions)

        /** @see upload */
        @MustBeClosed
        suspend fun upload(
            params: LogoUploadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileUpload>
    }
}
