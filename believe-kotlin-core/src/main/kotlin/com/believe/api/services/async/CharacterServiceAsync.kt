// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.characters.CharacterCreateParams
import com.believe.api.models.characters.CharacterDeleteParams
import com.believe.api.models.characters.CharacterGetQuotesParams
import com.believe.api.models.characters.CharacterListPageAsync
import com.believe.api.models.characters.CharacterListParams
import com.believe.api.models.characters.CharacterRetrieveParams
import com.believe.api.models.characters.CharacterUpdateParams
import com.believe.api.models.characters.Characterz
import com.google.errorprone.annotations.MustBeClosed

/** Operations related to Ted Lasso characters */
interface CharacterServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): CharacterServiceAsync

    /** Add a new character to the Ted Lasso universe. */
    suspend fun create(
        params: CharacterCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Characterz

    /** Retrieve detailed information about a specific character. */
    suspend fun retrieve(
        characterId: String,
        params: CharacterRetrieveParams = CharacterRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Characterz = retrieve(params.toBuilder().characterId(characterId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: CharacterRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Characterz

    /** @see retrieve */
    suspend fun retrieve(characterId: String, requestOptions: RequestOptions): Characterz =
        retrieve(characterId, CharacterRetrieveParams.none(), requestOptions)

    /** Update specific fields of an existing character. */
    suspend fun update(
        characterId: String,
        params: CharacterUpdateParams = CharacterUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Characterz = update(params.toBuilder().characterId(characterId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: CharacterUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Characterz

    /** @see update */
    suspend fun update(characterId: String, requestOptions: RequestOptions): Characterz =
        update(characterId, CharacterUpdateParams.none(), requestOptions)

    /** Get a paginated list of Ted Lasso characters. */
    suspend fun list(
        params: CharacterListParams = CharacterListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CharacterListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): CharacterListPageAsync =
        list(CharacterListParams.none(), requestOptions)

    /** Remove a character from the database. */
    suspend fun delete(
        characterId: String,
        params: CharacterDeleteParams = CharacterDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().characterId(characterId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: CharacterDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(characterId: String, requestOptions: RequestOptions) =
        delete(characterId, CharacterDeleteParams.none(), requestOptions)

    /** Get all signature quotes from a specific character. */
    suspend fun getQuotes(
        characterId: String,
        params: CharacterGetQuotesParams = CharacterGetQuotesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<String> = getQuotes(params.toBuilder().characterId(characterId).build(), requestOptions)

    /** @see getQuotes */
    suspend fun getQuotes(
        params: CharacterGetQuotesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<String>

    /** @see getQuotes */
    suspend fun getQuotes(characterId: String, requestOptions: RequestOptions): List<String> =
        getQuotes(characterId, CharacterGetQuotesParams.none(), requestOptions)

    /**
     * A view of [CharacterServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): CharacterServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /characters`, but is otherwise the same as
         * [CharacterServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: CharacterCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Characterz>

        /**
         * Returns a raw HTTP response for `get /characters/{character_id}`, but is otherwise the
         * same as [CharacterServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            characterId: String,
            params: CharacterRetrieveParams = CharacterRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Characterz> =
            retrieve(params.toBuilder().characterId(characterId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: CharacterRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Characterz>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            characterId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Characterz> =
            retrieve(characterId, CharacterRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /characters/{character_id}`, but is otherwise the
         * same as [CharacterServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            characterId: String,
            params: CharacterUpdateParams = CharacterUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Characterz> =
            update(params.toBuilder().characterId(characterId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: CharacterUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Characterz>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            characterId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Characterz> =
            update(characterId, CharacterUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /characters`, but is otherwise the same as
         * [CharacterServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: CharacterListParams = CharacterListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CharacterListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<CharacterListPageAsync> =
            list(CharacterListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /characters/{character_id}`, but is otherwise the
         * same as [CharacterServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            characterId: String,
            params: CharacterDeleteParams = CharacterDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            delete(params.toBuilder().characterId(characterId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: CharacterDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(characterId: String, requestOptions: RequestOptions): HttpResponse =
            delete(characterId, CharacterDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /characters/{character_id}/quotes`, but is otherwise
         * the same as [CharacterServiceAsync.getQuotes].
         */
        @MustBeClosed
        suspend fun getQuotes(
            characterId: String,
            params: CharacterGetQuotesParams = CharacterGetQuotesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<String>> =
            getQuotes(params.toBuilder().characterId(characterId).build(), requestOptions)

        /** @see getQuotes */
        @MustBeClosed
        suspend fun getQuotes(
            params: CharacterGetQuotesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<String>>

        /** @see getQuotes */
        @MustBeClosed
        suspend fun getQuotes(
            characterId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<String>> =
            getQuotes(characterId, CharacterGetQuotesParams.none(), requestOptions)
    }
}
