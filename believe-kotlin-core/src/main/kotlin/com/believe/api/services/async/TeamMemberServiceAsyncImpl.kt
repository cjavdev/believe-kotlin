// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

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
import com.believe.api.core.http.parseable
import com.believe.api.core.prepareAsync
import com.believe.api.models.teammembers.TeamMemberCreateParams
import com.believe.api.models.teammembers.TeamMemberCreateResponse
import com.believe.api.models.teammembers.TeamMemberDeleteParams
import com.believe.api.models.teammembers.TeamMemberListCoachesPageAsync
import com.believe.api.models.teammembers.TeamMemberListCoachesPageResponse
import com.believe.api.models.teammembers.TeamMemberListCoachesParams
import com.believe.api.models.teammembers.TeamMemberListPageAsync
import com.believe.api.models.teammembers.TeamMemberListPageResponse
import com.believe.api.models.teammembers.TeamMemberListParams
import com.believe.api.models.teammembers.TeamMemberListPlayersPageAsync
import com.believe.api.models.teammembers.TeamMemberListPlayersPageResponse
import com.believe.api.models.teammembers.TeamMemberListPlayersParams
import com.believe.api.models.teammembers.TeamMemberListStaffPageAsync
import com.believe.api.models.teammembers.TeamMemberListStaffPageResponse
import com.believe.api.models.teammembers.TeamMemberListStaffParams
import com.believe.api.models.teammembers.TeamMemberRetrieveParams
import com.believe.api.models.teammembers.TeamMemberRetrieveResponse
import com.believe.api.models.teammembers.TeamMemberUpdateParams
import com.believe.api.models.teammembers.TeamMemberUpdateResponse

class TeamMemberServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TeamMemberServiceAsync {

    private val withRawResponse: TeamMemberServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TeamMemberServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TeamMemberServiceAsync =
        TeamMemberServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(
        params: TeamMemberCreateParams,
        requestOptions: RequestOptions,
    ): TeamMemberCreateResponse =
        // post /team-members
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: TeamMemberRetrieveParams,
        requestOptions: RequestOptions,
    ): TeamMemberRetrieveResponse =
        // get /team-members/{member_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: TeamMemberUpdateParams,
        requestOptions: RequestOptions,
    ): TeamMemberUpdateResponse =
        // patch /team-members/{member_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: TeamMemberListParams,
        requestOptions: RequestOptions,
    ): TeamMemberListPageAsync =
        // get /team-members
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: TeamMemberDeleteParams, requestOptions: RequestOptions) {
        // delete /team-members/{member_id}
        withRawResponse().delete(params, requestOptions)
    }

    override suspend fun listCoaches(
        params: TeamMemberListCoachesParams,
        requestOptions: RequestOptions,
    ): TeamMemberListCoachesPageAsync =
        // get /team-members/coaches/
        withRawResponse().listCoaches(params, requestOptions).parse()

    override suspend fun listPlayers(
        params: TeamMemberListPlayersParams,
        requestOptions: RequestOptions,
    ): TeamMemberListPlayersPageAsync =
        // get /team-members/players/
        withRawResponse().listPlayers(params, requestOptions).parse()

    override suspend fun listStaff(
        params: TeamMemberListStaffParams,
        requestOptions: RequestOptions,
    ): TeamMemberListStaffPageAsync =
        // get /team-members/staff/
        withRawResponse().listStaff(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TeamMemberServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): TeamMemberServiceAsync.WithRawResponse =
            TeamMemberServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createHandler: Handler<TeamMemberCreateResponse> =
            jsonHandler<TeamMemberCreateResponse>(clientOptions.jsonMapper)

        override suspend fun create(
            params: TeamMemberCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TeamMemberCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("team-members")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<TeamMemberRetrieveResponse> =
            jsonHandler<TeamMemberRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: TeamMemberRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TeamMemberRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("memberId", params.memberId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("team-members", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<TeamMemberUpdateResponse> =
            jsonHandler<TeamMemberUpdateResponse>(clientOptions.jsonMapper)

        override suspend fun update(
            params: TeamMemberUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TeamMemberUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("memberId", params.memberId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("team-members", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<TeamMemberListPageResponse> =
            jsonHandler<TeamMemberListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: TeamMemberListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TeamMemberListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("team-members")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        TeamMemberListPageAsync.builder()
                            .service(TeamMemberServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: TeamMemberDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("memberId", params.memberId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("team-members", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val listCoachesHandler: Handler<TeamMemberListCoachesPageResponse> =
            jsonHandler<TeamMemberListCoachesPageResponse>(clientOptions.jsonMapper)

        override suspend fun listCoaches(
            params: TeamMemberListCoachesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TeamMemberListCoachesPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("team-members", "coaches", "")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listCoachesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        TeamMemberListCoachesPageAsync.builder()
                            .service(TeamMemberServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val listPlayersHandler: Handler<TeamMemberListPlayersPageResponse> =
            jsonHandler<TeamMemberListPlayersPageResponse>(clientOptions.jsonMapper)

        override suspend fun listPlayers(
            params: TeamMemberListPlayersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TeamMemberListPlayersPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("team-members", "players", "")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listPlayersHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        TeamMemberListPlayersPageAsync.builder()
                            .service(TeamMemberServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val listStaffHandler: Handler<TeamMemberListStaffPageResponse> =
            jsonHandler<TeamMemberListStaffPageResponse>(clientOptions.jsonMapper)

        override suspend fun listStaff(
            params: TeamMemberListStaffParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TeamMemberListStaffPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("team-members", "staff", "")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listStaffHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        TeamMemberListStaffPageAsync.builder()
                            .service(TeamMemberServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
