// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.core.ClientOptions
import com.believe.api.core.RequestOptions
import com.believe.api.core.http.HttpResponse
import com.believe.api.core.http.HttpResponseFor
import com.believe.api.models.quotes.Quote
import com.believe.api.models.quotes.QuoteCreateParams
import com.believe.api.models.quotes.QuoteDeleteParams
import com.believe.api.models.quotes.QuoteGetRandomParams
import com.believe.api.models.quotes.QuoteListByCharacterPageAsync
import com.believe.api.models.quotes.QuoteListByCharacterParams
import com.believe.api.models.quotes.QuoteListByThemePageAsync
import com.believe.api.models.quotes.QuoteListByThemeParams
import com.believe.api.models.quotes.QuoteListPageAsync
import com.believe.api.models.quotes.QuoteListParams
import com.believe.api.models.quotes.QuoteRetrieveParams
import com.believe.api.models.quotes.QuoteTheme
import com.believe.api.models.quotes.QuoteUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface QuoteServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): QuoteServiceAsync

    /** Add a new memorable quote to the collection. */
    suspend fun create(
        params: QuoteCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Quote

    /** Retrieve a specific quote by its ID. */
    suspend fun retrieve(
        quoteId: String,
        params: QuoteRetrieveParams = QuoteRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Quote = retrieve(params.toBuilder().quoteId(quoteId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: QuoteRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Quote

    /** @see retrieve */
    suspend fun retrieve(quoteId: String, requestOptions: RequestOptions): Quote =
        retrieve(quoteId, QuoteRetrieveParams.none(), requestOptions)

    /** Update specific fields of an existing quote. */
    suspend fun update(
        quoteId: String,
        params: QuoteUpdateParams = QuoteUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Quote = update(params.toBuilder().quoteId(quoteId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: QuoteUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Quote

    /** @see update */
    suspend fun update(quoteId: String, requestOptions: RequestOptions): Quote =
        update(quoteId, QuoteUpdateParams.none(), requestOptions)

    /** Get a paginated list of all memorable Ted Lasso quotes with optional filtering. */
    suspend fun list(
        params: QuoteListParams = QuoteListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): QuoteListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): QuoteListPageAsync =
        list(QuoteListParams.none(), requestOptions)

    /** Remove a quote from the collection. */
    suspend fun delete(
        quoteId: String,
        params: QuoteDeleteParams = QuoteDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().quoteId(quoteId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: QuoteDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(quoteId: String, requestOptions: RequestOptions) =
        delete(quoteId, QuoteDeleteParams.none(), requestOptions)

    /** Get a random Ted Lasso quote, optionally filtered. */
    suspend fun getRandom(
        params: QuoteGetRandomParams = QuoteGetRandomParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Quote

    /** @see getRandom */
    suspend fun getRandom(requestOptions: RequestOptions): Quote =
        getRandom(QuoteGetRandomParams.none(), requestOptions)

    /** Get a paginated list of quotes from a specific character. */
    suspend fun listByCharacter(
        characterId: String,
        params: QuoteListByCharacterParams = QuoteListByCharacterParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): QuoteListByCharacterPageAsync =
        listByCharacter(params.toBuilder().characterId(characterId).build(), requestOptions)

    /** @see listByCharacter */
    suspend fun listByCharacter(
        params: QuoteListByCharacterParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): QuoteListByCharacterPageAsync

    /** @see listByCharacter */
    suspend fun listByCharacter(
        characterId: String,
        requestOptions: RequestOptions,
    ): QuoteListByCharacterPageAsync =
        listByCharacter(characterId, QuoteListByCharacterParams.none(), requestOptions)

    /** Get a paginated list of quotes related to a specific theme. */
    suspend fun listByTheme(
        theme: QuoteTheme,
        params: QuoteListByThemeParams = QuoteListByThemeParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): QuoteListByThemePageAsync =
        listByTheme(params.toBuilder().theme(theme).build(), requestOptions)

    /** @see listByTheme */
    suspend fun listByTheme(
        params: QuoteListByThemeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): QuoteListByThemePageAsync

    /** @see listByTheme */
    suspend fun listByTheme(
        theme: QuoteTheme,
        requestOptions: RequestOptions,
    ): QuoteListByThemePageAsync = listByTheme(theme, QuoteListByThemeParams.none(), requestOptions)

    /** A view of [QuoteServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): QuoteServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /quotes`, but is otherwise the same as
         * [QuoteServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: QuoteCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Quote>

        /**
         * Returns a raw HTTP response for `get /quotes/{quote_id}`, but is otherwise the same as
         * [QuoteServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            quoteId: String,
            params: QuoteRetrieveParams = QuoteRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Quote> =
            retrieve(params.toBuilder().quoteId(quoteId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: QuoteRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Quote>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            quoteId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Quote> = retrieve(quoteId, QuoteRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /quotes/{quote_id}`, but is otherwise the same as
         * [QuoteServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            quoteId: String,
            params: QuoteUpdateParams = QuoteUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Quote> =
            update(params.toBuilder().quoteId(quoteId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: QuoteUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Quote>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            quoteId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Quote> = update(quoteId, QuoteUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /quotes`, but is otherwise the same as
         * [QuoteServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: QuoteListParams = QuoteListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<QuoteListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<QuoteListPageAsync> =
            list(QuoteListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /quotes/{quote_id}`, but is otherwise the same as
         * [QuoteServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            quoteId: String,
            params: QuoteDeleteParams = QuoteDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().quoteId(quoteId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: QuoteDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(quoteId: String, requestOptions: RequestOptions): HttpResponse =
            delete(quoteId, QuoteDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /quotes/random`, but is otherwise the same as
         * [QuoteServiceAsync.getRandom].
         */
        @MustBeClosed
        suspend fun getRandom(
            params: QuoteGetRandomParams = QuoteGetRandomParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Quote>

        /** @see getRandom */
        @MustBeClosed
        suspend fun getRandom(requestOptions: RequestOptions): HttpResponseFor<Quote> =
            getRandom(QuoteGetRandomParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /quotes/characters/{character_id}`, but is otherwise
         * the same as [QuoteServiceAsync.listByCharacter].
         */
        @MustBeClosed
        suspend fun listByCharacter(
            characterId: String,
            params: QuoteListByCharacterParams = QuoteListByCharacterParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<QuoteListByCharacterPageAsync> =
            listByCharacter(params.toBuilder().characterId(characterId).build(), requestOptions)

        /** @see listByCharacter */
        @MustBeClosed
        suspend fun listByCharacter(
            params: QuoteListByCharacterParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<QuoteListByCharacterPageAsync>

        /** @see listByCharacter */
        @MustBeClosed
        suspend fun listByCharacter(
            characterId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<QuoteListByCharacterPageAsync> =
            listByCharacter(characterId, QuoteListByCharacterParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /quotes/themes/{theme}`, but is otherwise the same
         * as [QuoteServiceAsync.listByTheme].
         */
        @MustBeClosed
        suspend fun listByTheme(
            theme: QuoteTheme,
            params: QuoteListByThemeParams = QuoteListByThemeParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<QuoteListByThemePageAsync> =
            listByTheme(params.toBuilder().theme(theme).build(), requestOptions)

        /** @see listByTheme */
        @MustBeClosed
        suspend fun listByTheme(
            params: QuoteListByThemeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<QuoteListByThemePageAsync>

        /** @see listByTheme */
        @MustBeClosed
        suspend fun listByTheme(
            theme: QuoteTheme,
            requestOptions: RequestOptions,
        ): HttpResponseFor<QuoteListByThemePageAsync> =
            listByTheme(theme, QuoteListByThemeParams.none(), requestOptions)
    }
}
