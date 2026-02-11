// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.episodes

import com.believe.api.core.ExcludeMissing
import com.believe.api.core.JsonField
import com.believe.api.core.JsonMissing
import com.believe.api.core.JsonValue
import com.believe.api.core.Params
import com.believe.api.core.checkKnown
import com.believe.api.core.http.Headers
import com.believe.api.core.http.QueryParams
import com.believe.api.core.toImmutable
import com.believe.api.errors.BelieveInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.Collections
import java.util.Objects

/** Update specific fields of an existing episode. */
class EpisodeUpdateParams
private constructor(
    private val episodeId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun episodeId(): String? = episodeId

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun airDate(): LocalDate? = body.airDate()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun biscuitsWithBossMoment(): String? = body.biscuitsWithBossMoment()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun characterFocus(): List<String>? = body.characterFocus()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun director(): String? = body.director()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun episodeNumber(): Long? = body.episodeNumber()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mainTheme(): String? = body.mainTheme()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun memorableMoments(): List<String>? = body.memorableMoments()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun runtimeMinutes(): Long? = body.runtimeMinutes()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun season(): Long? = body.season()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun synopsis(): String? = body.synopsis()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tedWisdom(): String? = body.tedWisdom()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun title(): String? = body.title()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usViewersMillions(): Double? = body.usViewersMillions()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun viewerRating(): Double? = body.viewerRating()

    /**
     * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun writer(): String? = body.writer()

    /**
     * Returns the raw JSON value of [airDate].
     *
     * Unlike [airDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _airDate(): JsonField<LocalDate> = body._airDate()

    /**
     * Returns the raw JSON value of [biscuitsWithBossMoment].
     *
     * Unlike [biscuitsWithBossMoment], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _biscuitsWithBossMoment(): JsonField<String> = body._biscuitsWithBossMoment()

    /**
     * Returns the raw JSON value of [characterFocus].
     *
     * Unlike [characterFocus], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _characterFocus(): JsonField<List<String>> = body._characterFocus()

    /**
     * Returns the raw JSON value of [director].
     *
     * Unlike [director], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _director(): JsonField<String> = body._director()

    /**
     * Returns the raw JSON value of [episodeNumber].
     *
     * Unlike [episodeNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _episodeNumber(): JsonField<Long> = body._episodeNumber()

    /**
     * Returns the raw JSON value of [mainTheme].
     *
     * Unlike [mainTheme], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _mainTheme(): JsonField<String> = body._mainTheme()

    /**
     * Returns the raw JSON value of [memorableMoments].
     *
     * Unlike [memorableMoments], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _memorableMoments(): JsonField<List<String>> = body._memorableMoments()

    /**
     * Returns the raw JSON value of [runtimeMinutes].
     *
     * Unlike [runtimeMinutes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _runtimeMinutes(): JsonField<Long> = body._runtimeMinutes()

    /**
     * Returns the raw JSON value of [season].
     *
     * Unlike [season], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _season(): JsonField<Long> = body._season()

    /**
     * Returns the raw JSON value of [synopsis].
     *
     * Unlike [synopsis], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _synopsis(): JsonField<String> = body._synopsis()

    /**
     * Returns the raw JSON value of [tedWisdom].
     *
     * Unlike [tedWisdom], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tedWisdom(): JsonField<String> = body._tedWisdom()

    /**
     * Returns the raw JSON value of [title].
     *
     * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _title(): JsonField<String> = body._title()

    /**
     * Returns the raw JSON value of [usViewersMillions].
     *
     * Unlike [usViewersMillions], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _usViewersMillions(): JsonField<Double> = body._usViewersMillions()

    /**
     * Returns the raw JSON value of [viewerRating].
     *
     * Unlike [viewerRating], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _viewerRating(): JsonField<Double> = body._viewerRating()

    /**
     * Returns the raw JSON value of [writer].
     *
     * Unlike [writer], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _writer(): JsonField<String> = body._writer()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        fun none(): EpisodeUpdateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [EpisodeUpdateParams]. */
        fun builder() = Builder()
    }

    /** A builder for [EpisodeUpdateParams]. */
    class Builder internal constructor() {

        private var episodeId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        internal fun from(episodeUpdateParams: EpisodeUpdateParams) = apply {
            episodeId = episodeUpdateParams.episodeId
            body = episodeUpdateParams.body.toBuilder()
            additionalHeaders = episodeUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = episodeUpdateParams.additionalQueryParams.toBuilder()
        }

        fun episodeId(episodeId: String?) = apply { this.episodeId = episodeId }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [airDate]
         * - [biscuitsWithBossMoment]
         * - [characterFocus]
         * - [director]
         * - [episodeNumber]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun airDate(airDate: LocalDate?) = apply { body.airDate(airDate) }

        /**
         * Sets [Builder.airDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.airDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun airDate(airDate: JsonField<LocalDate>) = apply { body.airDate(airDate) }

        fun biscuitsWithBossMoment(biscuitsWithBossMoment: String?) = apply {
            body.biscuitsWithBossMoment(biscuitsWithBossMoment)
        }

        /**
         * Sets [Builder.biscuitsWithBossMoment] to an arbitrary JSON value.
         *
         * You should usually call [Builder.biscuitsWithBossMoment] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun biscuitsWithBossMoment(biscuitsWithBossMoment: JsonField<String>) = apply {
            body.biscuitsWithBossMoment(biscuitsWithBossMoment)
        }

        fun characterFocus(characterFocus: List<String>?) = apply {
            body.characterFocus(characterFocus)
        }

        /**
         * Sets [Builder.characterFocus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.characterFocus] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun characterFocus(characterFocus: JsonField<List<String>>) = apply {
            body.characterFocus(characterFocus)
        }

        /**
         * Adds a single [String] to [Builder.characterFocus].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCharacterFocus(characterFocus: String) = apply {
            body.addCharacterFocus(characterFocus)
        }

        fun director(director: String?) = apply { body.director(director) }

        /**
         * Sets [Builder.director] to an arbitrary JSON value.
         *
         * You should usually call [Builder.director] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun director(director: JsonField<String>) = apply { body.director(director) }

        fun episodeNumber(episodeNumber: Long?) = apply { body.episodeNumber(episodeNumber) }

        /**
         * Alias for [Builder.episodeNumber].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun episodeNumber(episodeNumber: Long) = episodeNumber(episodeNumber as Long?)

        /**
         * Sets [Builder.episodeNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.episodeNumber] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun episodeNumber(episodeNumber: JsonField<Long>) = apply {
            body.episodeNumber(episodeNumber)
        }

        fun mainTheme(mainTheme: String?) = apply { body.mainTheme(mainTheme) }

        /**
         * Sets [Builder.mainTheme] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mainTheme] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun mainTheme(mainTheme: JsonField<String>) = apply { body.mainTheme(mainTheme) }

        fun memorableMoments(memorableMoments: List<String>?) = apply {
            body.memorableMoments(memorableMoments)
        }

        /**
         * Sets [Builder.memorableMoments] to an arbitrary JSON value.
         *
         * You should usually call [Builder.memorableMoments] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun memorableMoments(memorableMoments: JsonField<List<String>>) = apply {
            body.memorableMoments(memorableMoments)
        }

        /**
         * Adds a single [String] to [memorableMoments].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMemorableMoment(memorableMoment: String) = apply {
            body.addMemorableMoment(memorableMoment)
        }

        fun runtimeMinutes(runtimeMinutes: Long?) = apply { body.runtimeMinutes(runtimeMinutes) }

        /**
         * Alias for [Builder.runtimeMinutes].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun runtimeMinutes(runtimeMinutes: Long) = runtimeMinutes(runtimeMinutes as Long?)

        /**
         * Sets [Builder.runtimeMinutes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.runtimeMinutes] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun runtimeMinutes(runtimeMinutes: JsonField<Long>) = apply {
            body.runtimeMinutes(runtimeMinutes)
        }

        fun season(season: Long?) = apply { body.season(season) }

        /**
         * Alias for [Builder.season].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun season(season: Long) = season(season as Long?)

        /**
         * Sets [Builder.season] to an arbitrary JSON value.
         *
         * You should usually call [Builder.season] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun season(season: JsonField<Long>) = apply { body.season(season) }

        fun synopsis(synopsis: String?) = apply { body.synopsis(synopsis) }

        /**
         * Sets [Builder.synopsis] to an arbitrary JSON value.
         *
         * You should usually call [Builder.synopsis] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun synopsis(synopsis: JsonField<String>) = apply { body.synopsis(synopsis) }

        fun tedWisdom(tedWisdom: String?) = apply { body.tedWisdom(tedWisdom) }

        /**
         * Sets [Builder.tedWisdom] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tedWisdom] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tedWisdom(tedWisdom: JsonField<String>) = apply { body.tedWisdom(tedWisdom) }

        fun title(title: String?) = apply { body.title(title) }

        /**
         * Sets [Builder.title] to an arbitrary JSON value.
         *
         * You should usually call [Builder.title] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun title(title: JsonField<String>) = apply { body.title(title) }

        fun usViewersMillions(usViewersMillions: Double?) = apply {
            body.usViewersMillions(usViewersMillions)
        }

        /**
         * Alias for [Builder.usViewersMillions].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun usViewersMillions(usViewersMillions: Double) =
            usViewersMillions(usViewersMillions as Double?)

        /**
         * Sets [Builder.usViewersMillions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usViewersMillions] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun usViewersMillions(usViewersMillions: JsonField<Double>) = apply {
            body.usViewersMillions(usViewersMillions)
        }

        fun viewerRating(viewerRating: Double?) = apply { body.viewerRating(viewerRating) }

        /**
         * Alias for [Builder.viewerRating].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun viewerRating(viewerRating: Double) = viewerRating(viewerRating as Double?)

        /**
         * Sets [Builder.viewerRating] to an arbitrary JSON value.
         *
         * You should usually call [Builder.viewerRating] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun viewerRating(viewerRating: JsonField<Double>) = apply {
            body.viewerRating(viewerRating)
        }

        fun writer(writer: String?) = apply { body.writer(writer) }

        /**
         * Sets [Builder.writer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.writer] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun writer(writer: JsonField<String>) = apply { body.writer(writer) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [EpisodeUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): EpisodeUpdateParams =
            EpisodeUpdateParams(
                episodeId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> episodeId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Model for updating an episode (all fields optional). */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val airDate: JsonField<LocalDate>,
        private val biscuitsWithBossMoment: JsonField<String>,
        private val characterFocus: JsonField<List<String>>,
        private val director: JsonField<String>,
        private val episodeNumber: JsonField<Long>,
        private val mainTheme: JsonField<String>,
        private val memorableMoments: JsonField<List<String>>,
        private val runtimeMinutes: JsonField<Long>,
        private val season: JsonField<Long>,
        private val synopsis: JsonField<String>,
        private val tedWisdom: JsonField<String>,
        private val title: JsonField<String>,
        private val usViewersMillions: JsonField<Double>,
        private val viewerRating: JsonField<Double>,
        private val writer: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("air_date")
            @ExcludeMissing
            airDate: JsonField<LocalDate> = JsonMissing.of(),
            @JsonProperty("biscuits_with_boss_moment")
            @ExcludeMissing
            biscuitsWithBossMoment: JsonField<String> = JsonMissing.of(),
            @JsonProperty("character_focus")
            @ExcludeMissing
            characterFocus: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("director")
            @ExcludeMissing
            director: JsonField<String> = JsonMissing.of(),
            @JsonProperty("episode_number")
            @ExcludeMissing
            episodeNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("main_theme")
            @ExcludeMissing
            mainTheme: JsonField<String> = JsonMissing.of(),
            @JsonProperty("memorable_moments")
            @ExcludeMissing
            memorableMoments: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("runtime_minutes")
            @ExcludeMissing
            runtimeMinutes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("season") @ExcludeMissing season: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("synopsis")
            @ExcludeMissing
            synopsis: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ted_wisdom")
            @ExcludeMissing
            tedWisdom: JsonField<String> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("us_viewers_millions")
            @ExcludeMissing
            usViewersMillions: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("viewer_rating")
            @ExcludeMissing
            viewerRating: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("writer") @ExcludeMissing writer: JsonField<String> = JsonMissing.of(),
        ) : this(
            airDate,
            biscuitsWithBossMoment,
            characterFocus,
            director,
            episodeNumber,
            mainTheme,
            memorableMoments,
            runtimeMinutes,
            season,
            synopsis,
            tedWisdom,
            title,
            usViewersMillions,
            viewerRating,
            writer,
            mutableMapOf(),
        )

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun airDate(): LocalDate? = airDate.getNullable("air_date")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun biscuitsWithBossMoment(): String? =
            biscuitsWithBossMoment.getNullable("biscuits_with_boss_moment")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun characterFocus(): List<String>? = characterFocus.getNullable("character_focus")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun director(): String? = director.getNullable("director")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun episodeNumber(): Long? = episodeNumber.getNullable("episode_number")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mainTheme(): String? = mainTheme.getNullable("main_theme")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun memorableMoments(): List<String>? = memorableMoments.getNullable("memorable_moments")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun runtimeMinutes(): Long? = runtimeMinutes.getNullable("runtime_minutes")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun season(): Long? = season.getNullable("season")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun synopsis(): String? = synopsis.getNullable("synopsis")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tedWisdom(): String? = tedWisdom.getNullable("ted_wisdom")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun title(): String? = title.getNullable("title")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun usViewersMillions(): Double? = usViewersMillions.getNullable("us_viewers_millions")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun viewerRating(): Double? = viewerRating.getNullable("viewer_rating")

        /**
         * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun writer(): String? = writer.getNullable("writer")

        /**
         * Returns the raw JSON value of [airDate].
         *
         * Unlike [airDate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("air_date") @ExcludeMissing fun _airDate(): JsonField<LocalDate> = airDate

        /**
         * Returns the raw JSON value of [biscuitsWithBossMoment].
         *
         * Unlike [biscuitsWithBossMoment], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("biscuits_with_boss_moment")
        @ExcludeMissing
        fun _biscuitsWithBossMoment(): JsonField<String> = biscuitsWithBossMoment

        /**
         * Returns the raw JSON value of [characterFocus].
         *
         * Unlike [characterFocus], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("character_focus")
        @ExcludeMissing
        fun _characterFocus(): JsonField<List<String>> = characterFocus

        /**
         * Returns the raw JSON value of [director].
         *
         * Unlike [director], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("director") @ExcludeMissing fun _director(): JsonField<String> = director

        /**
         * Returns the raw JSON value of [episodeNumber].
         *
         * Unlike [episodeNumber], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("episode_number")
        @ExcludeMissing
        fun _episodeNumber(): JsonField<Long> = episodeNumber

        /**
         * Returns the raw JSON value of [mainTheme].
         *
         * Unlike [mainTheme], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("main_theme") @ExcludeMissing fun _mainTheme(): JsonField<String> = mainTheme

        /**
         * Returns the raw JSON value of [memorableMoments].
         *
         * Unlike [memorableMoments], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("memorable_moments")
        @ExcludeMissing
        fun _memorableMoments(): JsonField<List<String>> = memorableMoments

        /**
         * Returns the raw JSON value of [runtimeMinutes].
         *
         * Unlike [runtimeMinutes], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("runtime_minutes")
        @ExcludeMissing
        fun _runtimeMinutes(): JsonField<Long> = runtimeMinutes

        /**
         * Returns the raw JSON value of [season].
         *
         * Unlike [season], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("season") @ExcludeMissing fun _season(): JsonField<Long> = season

        /**
         * Returns the raw JSON value of [synopsis].
         *
         * Unlike [synopsis], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("synopsis") @ExcludeMissing fun _synopsis(): JsonField<String> = synopsis

        /**
         * Returns the raw JSON value of [tedWisdom].
         *
         * Unlike [tedWisdom], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ted_wisdom") @ExcludeMissing fun _tedWisdom(): JsonField<String> = tedWisdom

        /**
         * Returns the raw JSON value of [title].
         *
         * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

        /**
         * Returns the raw JSON value of [usViewersMillions].
         *
         * Unlike [usViewersMillions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("us_viewers_millions")
        @ExcludeMissing
        fun _usViewersMillions(): JsonField<Double> = usViewersMillions

        /**
         * Returns the raw JSON value of [viewerRating].
         *
         * Unlike [viewerRating], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("viewer_rating")
        @ExcludeMissing
        fun _viewerRating(): JsonField<Double> = viewerRating

        /**
         * Returns the raw JSON value of [writer].
         *
         * Unlike [writer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("writer") @ExcludeMissing fun _writer(): JsonField<String> = writer

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Body]. */
            fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var airDate: JsonField<LocalDate> = JsonMissing.of()
            private var biscuitsWithBossMoment: JsonField<String> = JsonMissing.of()
            private var characterFocus: JsonField<MutableList<String>>? = null
            private var director: JsonField<String> = JsonMissing.of()
            private var episodeNumber: JsonField<Long> = JsonMissing.of()
            private var mainTheme: JsonField<String> = JsonMissing.of()
            private var memorableMoments: JsonField<MutableList<String>>? = null
            private var runtimeMinutes: JsonField<Long> = JsonMissing.of()
            private var season: JsonField<Long> = JsonMissing.of()
            private var synopsis: JsonField<String> = JsonMissing.of()
            private var tedWisdom: JsonField<String> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var usViewersMillions: JsonField<Double> = JsonMissing.of()
            private var viewerRating: JsonField<Double> = JsonMissing.of()
            private var writer: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(body: Body) = apply {
                airDate = body.airDate
                biscuitsWithBossMoment = body.biscuitsWithBossMoment
                characterFocus = body.characterFocus.map { it.toMutableList() }
                director = body.director
                episodeNumber = body.episodeNumber
                mainTheme = body.mainTheme
                memorableMoments = body.memorableMoments.map { it.toMutableList() }
                runtimeMinutes = body.runtimeMinutes
                season = body.season
                synopsis = body.synopsis
                tedWisdom = body.tedWisdom
                title = body.title
                usViewersMillions = body.usViewersMillions
                viewerRating = body.viewerRating
                writer = body.writer
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun airDate(airDate: LocalDate?) = airDate(JsonField.ofNullable(airDate))

            /**
             * Sets [Builder.airDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.airDate] with a well-typed [LocalDate] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun airDate(airDate: JsonField<LocalDate>) = apply { this.airDate = airDate }

            fun biscuitsWithBossMoment(biscuitsWithBossMoment: String?) =
                biscuitsWithBossMoment(JsonField.ofNullable(biscuitsWithBossMoment))

            /**
             * Sets [Builder.biscuitsWithBossMoment] to an arbitrary JSON value.
             *
             * You should usually call [Builder.biscuitsWithBossMoment] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun biscuitsWithBossMoment(biscuitsWithBossMoment: JsonField<String>) = apply {
                this.biscuitsWithBossMoment = biscuitsWithBossMoment
            }

            fun characterFocus(characterFocus: List<String>?) =
                characterFocus(JsonField.ofNullable(characterFocus))

            /**
             * Sets [Builder.characterFocus] to an arbitrary JSON value.
             *
             * You should usually call [Builder.characterFocus] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun characterFocus(characterFocus: JsonField<List<String>>) = apply {
                this.characterFocus = characterFocus.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.characterFocus].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCharacterFocus(characterFocus: String) = apply {
                this.characterFocus =
                    (this.characterFocus ?: JsonField.of(mutableListOf())).also {
                        checkKnown("characterFocus", it).add(characterFocus)
                    }
            }

            fun director(director: String?) = director(JsonField.ofNullable(director))

            /**
             * Sets [Builder.director] to an arbitrary JSON value.
             *
             * You should usually call [Builder.director] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun director(director: JsonField<String>) = apply { this.director = director }

            fun episodeNumber(episodeNumber: Long?) =
                episodeNumber(JsonField.ofNullable(episodeNumber))

            /**
             * Alias for [Builder.episodeNumber].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun episodeNumber(episodeNumber: Long) = episodeNumber(episodeNumber as Long?)

            /**
             * Sets [Builder.episodeNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.episodeNumber] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun episodeNumber(episodeNumber: JsonField<Long>) = apply {
                this.episodeNumber = episodeNumber
            }

            fun mainTheme(mainTheme: String?) = mainTheme(JsonField.ofNullable(mainTheme))

            /**
             * Sets [Builder.mainTheme] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mainTheme] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mainTheme(mainTheme: JsonField<String>) = apply { this.mainTheme = mainTheme }

            fun memorableMoments(memorableMoments: List<String>?) =
                memorableMoments(JsonField.ofNullable(memorableMoments))

            /**
             * Sets [Builder.memorableMoments] to an arbitrary JSON value.
             *
             * You should usually call [Builder.memorableMoments] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun memorableMoments(memorableMoments: JsonField<List<String>>) = apply {
                this.memorableMoments = memorableMoments.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [memorableMoments].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMemorableMoment(memorableMoment: String) = apply {
                memorableMoments =
                    (memorableMoments ?: JsonField.of(mutableListOf())).also {
                        checkKnown("memorableMoments", it).add(memorableMoment)
                    }
            }

            fun runtimeMinutes(runtimeMinutes: Long?) =
                runtimeMinutes(JsonField.ofNullable(runtimeMinutes))

            /**
             * Alias for [Builder.runtimeMinutes].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun runtimeMinutes(runtimeMinutes: Long) = runtimeMinutes(runtimeMinutes as Long?)

            /**
             * Sets [Builder.runtimeMinutes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.runtimeMinutes] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun runtimeMinutes(runtimeMinutes: JsonField<Long>) = apply {
                this.runtimeMinutes = runtimeMinutes
            }

            fun season(season: Long?) = season(JsonField.ofNullable(season))

            /**
             * Alias for [Builder.season].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun season(season: Long) = season(season as Long?)

            /**
             * Sets [Builder.season] to an arbitrary JSON value.
             *
             * You should usually call [Builder.season] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun season(season: JsonField<Long>) = apply { this.season = season }

            fun synopsis(synopsis: String?) = synopsis(JsonField.ofNullable(synopsis))

            /**
             * Sets [Builder.synopsis] to an arbitrary JSON value.
             *
             * You should usually call [Builder.synopsis] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun synopsis(synopsis: JsonField<String>) = apply { this.synopsis = synopsis }

            fun tedWisdom(tedWisdom: String?) = tedWisdom(JsonField.ofNullable(tedWisdom))

            /**
             * Sets [Builder.tedWisdom] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tedWisdom] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tedWisdom(tedWisdom: JsonField<String>) = apply { this.tedWisdom = tedWisdom }

            fun title(title: String?) = title(JsonField.ofNullable(title))

            /**
             * Sets [Builder.title] to an arbitrary JSON value.
             *
             * You should usually call [Builder.title] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun title(title: JsonField<String>) = apply { this.title = title }

            fun usViewersMillions(usViewersMillions: Double?) =
                usViewersMillions(JsonField.ofNullable(usViewersMillions))

            /**
             * Alias for [Builder.usViewersMillions].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun usViewersMillions(usViewersMillions: Double) =
                usViewersMillions(usViewersMillions as Double?)

            /**
             * Sets [Builder.usViewersMillions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.usViewersMillions] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun usViewersMillions(usViewersMillions: JsonField<Double>) = apply {
                this.usViewersMillions = usViewersMillions
            }

            fun viewerRating(viewerRating: Double?) =
                viewerRating(JsonField.ofNullable(viewerRating))

            /**
             * Alias for [Builder.viewerRating].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun viewerRating(viewerRating: Double) = viewerRating(viewerRating as Double?)

            /**
             * Sets [Builder.viewerRating] to an arbitrary JSON value.
             *
             * You should usually call [Builder.viewerRating] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun viewerRating(viewerRating: JsonField<Double>) = apply {
                this.viewerRating = viewerRating
            }

            fun writer(writer: String?) = writer(JsonField.ofNullable(writer))

            /**
             * Sets [Builder.writer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.writer] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun writer(writer: JsonField<String>) = apply { this.writer = writer }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    airDate,
                    biscuitsWithBossMoment,
                    (characterFocus ?: JsonMissing.of()).map { it.toImmutable() },
                    director,
                    episodeNumber,
                    mainTheme,
                    (memorableMoments ?: JsonMissing.of()).map { it.toImmutable() },
                    runtimeMinutes,
                    season,
                    synopsis,
                    tedWisdom,
                    title,
                    usViewersMillions,
                    viewerRating,
                    writer,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            airDate()
            biscuitsWithBossMoment()
            characterFocus()
            director()
            episodeNumber()
            mainTheme()
            memorableMoments()
            runtimeMinutes()
            season()
            synopsis()
            tedWisdom()
            title()
            usViewersMillions()
            viewerRating()
            writer()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: BelieveInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        internal fun validity(): Int =
            (if (airDate.asKnown() == null) 0 else 1) +
                (if (biscuitsWithBossMoment.asKnown() == null) 0 else 1) +
                (characterFocus.asKnown()?.size ?: 0) +
                (if (director.asKnown() == null) 0 else 1) +
                (if (episodeNumber.asKnown() == null) 0 else 1) +
                (if (mainTheme.asKnown() == null) 0 else 1) +
                (memorableMoments.asKnown()?.size ?: 0) +
                (if (runtimeMinutes.asKnown() == null) 0 else 1) +
                (if (season.asKnown() == null) 0 else 1) +
                (if (synopsis.asKnown() == null) 0 else 1) +
                (if (tedWisdom.asKnown() == null) 0 else 1) +
                (if (title.asKnown() == null) 0 else 1) +
                (if (usViewersMillions.asKnown() == null) 0 else 1) +
                (if (viewerRating.asKnown() == null) 0 else 1) +
                (if (writer.asKnown() == null) 0 else 1)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                airDate == other.airDate &&
                biscuitsWithBossMoment == other.biscuitsWithBossMoment &&
                characterFocus == other.characterFocus &&
                director == other.director &&
                episodeNumber == other.episodeNumber &&
                mainTheme == other.mainTheme &&
                memorableMoments == other.memorableMoments &&
                runtimeMinutes == other.runtimeMinutes &&
                season == other.season &&
                synopsis == other.synopsis &&
                tedWisdom == other.tedWisdom &&
                title == other.title &&
                usViewersMillions == other.usViewersMillions &&
                viewerRating == other.viewerRating &&
                writer == other.writer &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                airDate,
                biscuitsWithBossMoment,
                characterFocus,
                director,
                episodeNumber,
                mainTheme,
                memorableMoments,
                runtimeMinutes,
                season,
                synopsis,
                tedWisdom,
                title,
                usViewersMillions,
                viewerRating,
                writer,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{airDate=$airDate, biscuitsWithBossMoment=$biscuitsWithBossMoment, characterFocus=$characterFocus, director=$director, episodeNumber=$episodeNumber, mainTheme=$mainTheme, memorableMoments=$memorableMoments, runtimeMinutes=$runtimeMinutes, season=$season, synopsis=$synopsis, tedWisdom=$tedWisdom, title=$title, usViewersMillions=$usViewersMillions, viewerRating=$viewerRating, writer=$writer, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EpisodeUpdateParams &&
            episodeId == other.episodeId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(episodeId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "EpisodeUpdateParams{episodeId=$episodeId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
