// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.teammembers

import com.believe.api.core.BaseDeserializer
import com.believe.api.core.BaseSerializer
import com.believe.api.core.ExcludeMissing
import com.believe.api.core.JsonField
import com.believe.api.core.JsonMissing
import com.believe.api.core.JsonValue
import com.believe.api.core.Params
import com.believe.api.core.allMaxBy
import com.believe.api.core.checkKnown
import com.believe.api.core.checkRequired
import com.believe.api.core.getOrThrow
import com.believe.api.core.http.Headers
import com.believe.api.core.http.QueryParams
import com.believe.api.core.toImmutable
import com.believe.api.errors.BelieveInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Collections
import java.util.Objects

/** Update specific fields of an existing team member. Fields vary by member type. */
class TeamMemberUpdateParams
private constructor(
    private val memberId: String?,
    private val updates: Updates,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun memberId(): String? = memberId

    /** Update model for players. */
    fun updates(): Updates = updates

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TeamMemberUpdateParams].
         *
         * The following fields are required:
         * ```kotlin
         * .updates()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [TeamMemberUpdateParams]. */
    class Builder internal constructor() {

        private var memberId: String? = null
        private var updates: Updates? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        internal fun from(teamMemberUpdateParams: TeamMemberUpdateParams) = apply {
            memberId = teamMemberUpdateParams.memberId
            updates = teamMemberUpdateParams.updates
            additionalHeaders = teamMemberUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = teamMemberUpdateParams.additionalQueryParams.toBuilder()
        }

        fun memberId(memberId: String?) = apply { this.memberId = memberId }

        /** Update model for players. */
        fun updates(updates: Updates) = apply { this.updates = updates }

        /** Alias for calling [updates] with `Updates.ofPlayerUpdate(playerUpdate)`. */
        fun updates(playerUpdate: Updates.PlayerUpdate) =
            updates(Updates.ofPlayerUpdate(playerUpdate))

        /** Alias for calling [updates] with `Updates.ofCoachUpdate(coachUpdate)`. */
        fun updates(coachUpdate: Updates.CoachUpdate) = updates(Updates.ofCoachUpdate(coachUpdate))

        /** Alias for calling [updates] with `Updates.ofMedicalStaffUpdate(medicalStaffUpdate)`. */
        fun updates(medicalStaffUpdate: Updates.MedicalStaffUpdate) =
            updates(Updates.ofMedicalStaffUpdate(medicalStaffUpdate))

        /**
         * Alias for calling [updates] with
         * `Updates.ofEquipmentManagerUpdate(equipmentManagerUpdate)`.
         */
        fun updates(equipmentManagerUpdate: Updates.EquipmentManagerUpdate) =
            updates(Updates.ofEquipmentManagerUpdate(equipmentManagerUpdate))

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
         * Returns an immutable instance of [TeamMemberUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .updates()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TeamMemberUpdateParams =
            TeamMemberUpdateParams(
                memberId,
                checkRequired("updates", updates),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Updates = updates

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> memberId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Update model for players. */
    @JsonDeserialize(using = Updates.Deserializer::class)
    @JsonSerialize(using = Updates.Serializer::class)
    class Updates
    private constructor(
        private val playerUpdate: PlayerUpdate? = null,
        private val coachUpdate: CoachUpdate? = null,
        private val medicalStaffUpdate: MedicalStaffUpdate? = null,
        private val equipmentManagerUpdate: EquipmentManagerUpdate? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Update model for players. */
        fun playerUpdate(): PlayerUpdate? = playerUpdate

        /** Update model for coaches. */
        fun coachUpdate(): CoachUpdate? = coachUpdate

        /** Update model for medical staff. */
        fun medicalStaffUpdate(): MedicalStaffUpdate? = medicalStaffUpdate

        /** Update model for equipment managers. */
        fun equipmentManagerUpdate(): EquipmentManagerUpdate? = equipmentManagerUpdate

        fun isPlayerUpdate(): Boolean = playerUpdate != null

        fun isCoachUpdate(): Boolean = coachUpdate != null

        fun isMedicalStaffUpdate(): Boolean = medicalStaffUpdate != null

        fun isEquipmentManagerUpdate(): Boolean = equipmentManagerUpdate != null

        /** Update model for players. */
        fun asPlayerUpdate(): PlayerUpdate = playerUpdate.getOrThrow("playerUpdate")

        /** Update model for coaches. */
        fun asCoachUpdate(): CoachUpdate = coachUpdate.getOrThrow("coachUpdate")

        /** Update model for medical staff. */
        fun asMedicalStaffUpdate(): MedicalStaffUpdate =
            medicalStaffUpdate.getOrThrow("medicalStaffUpdate")

        /** Update model for equipment managers. */
        fun asEquipmentManagerUpdate(): EquipmentManagerUpdate =
            equipmentManagerUpdate.getOrThrow("equipmentManagerUpdate")

        fun _json(): JsonValue? = _json

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                playerUpdate != null -> visitor.visitPlayerUpdate(playerUpdate)
                coachUpdate != null -> visitor.visitCoachUpdate(coachUpdate)
                medicalStaffUpdate != null -> visitor.visitMedicalStaffUpdate(medicalStaffUpdate)
                equipmentManagerUpdate != null ->
                    visitor.visitEquipmentManagerUpdate(equipmentManagerUpdate)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Updates = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitPlayerUpdate(playerUpdate: PlayerUpdate) {
                        playerUpdate.validate()
                    }

                    override fun visitCoachUpdate(coachUpdate: CoachUpdate) {
                        coachUpdate.validate()
                    }

                    override fun visitMedicalStaffUpdate(medicalStaffUpdate: MedicalStaffUpdate) {
                        medicalStaffUpdate.validate()
                    }

                    override fun visitEquipmentManagerUpdate(
                        equipmentManagerUpdate: EquipmentManagerUpdate
                    ) {
                        equipmentManagerUpdate.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitPlayerUpdate(playerUpdate: PlayerUpdate) =
                        playerUpdate.validity()

                    override fun visitCoachUpdate(coachUpdate: CoachUpdate) = coachUpdate.validity()

                    override fun visitMedicalStaffUpdate(medicalStaffUpdate: MedicalStaffUpdate) =
                        medicalStaffUpdate.validity()

                    override fun visitEquipmentManagerUpdate(
                        equipmentManagerUpdate: EquipmentManagerUpdate
                    ) = equipmentManagerUpdate.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Updates &&
                playerUpdate == other.playerUpdate &&
                coachUpdate == other.coachUpdate &&
                medicalStaffUpdate == other.medicalStaffUpdate &&
                equipmentManagerUpdate == other.equipmentManagerUpdate
        }

        override fun hashCode(): Int =
            Objects.hash(playerUpdate, coachUpdate, medicalStaffUpdate, equipmentManagerUpdate)

        override fun toString(): String =
            when {
                playerUpdate != null -> "Updates{playerUpdate=$playerUpdate}"
                coachUpdate != null -> "Updates{coachUpdate=$coachUpdate}"
                medicalStaffUpdate != null -> "Updates{medicalStaffUpdate=$medicalStaffUpdate}"
                equipmentManagerUpdate != null ->
                    "Updates{equipmentManagerUpdate=$equipmentManagerUpdate}"
                _json != null -> "Updates{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Updates")
            }

        companion object {

            /** Update model for players. */
            fun ofPlayerUpdate(playerUpdate: PlayerUpdate) = Updates(playerUpdate = playerUpdate)

            /** Update model for coaches. */
            fun ofCoachUpdate(coachUpdate: CoachUpdate) = Updates(coachUpdate = coachUpdate)

            /** Update model for medical staff. */
            fun ofMedicalStaffUpdate(medicalStaffUpdate: MedicalStaffUpdate) =
                Updates(medicalStaffUpdate = medicalStaffUpdate)

            /** Update model for equipment managers. */
            fun ofEquipmentManagerUpdate(equipmentManagerUpdate: EquipmentManagerUpdate) =
                Updates(equipmentManagerUpdate = equipmentManagerUpdate)
        }

        /**
         * An interface that defines how to map each variant of [Updates] to a value of type [T].
         */
        interface Visitor<out T> {

            /** Update model for players. */
            fun visitPlayerUpdate(playerUpdate: PlayerUpdate): T

            /** Update model for coaches. */
            fun visitCoachUpdate(coachUpdate: CoachUpdate): T

            /** Update model for medical staff. */
            fun visitMedicalStaffUpdate(medicalStaffUpdate: MedicalStaffUpdate): T

            /** Update model for equipment managers. */
            fun visitEquipmentManagerUpdate(equipmentManagerUpdate: EquipmentManagerUpdate): T

            /**
             * Maps an unknown variant of [Updates] to a value of type [T].
             *
             * An instance of [Updates] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws BelieveInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw BelieveInvalidDataException("Unknown Updates: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Updates>(Updates::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Updates {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<PlayerUpdate>())?.let {
                                Updates(playerUpdate = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<CoachUpdate>())?.let {
                                Updates(coachUpdate = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<MedicalStaffUpdate>())?.let {
                                Updates(medicalStaffUpdate = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<EquipmentManagerUpdate>())?.let {
                                Updates(equipmentManagerUpdate = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Updates(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Updates>(Updates::class) {

            override fun serialize(
                value: Updates,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.playerUpdate != null -> generator.writeObject(value.playerUpdate)
                    value.coachUpdate != null -> generator.writeObject(value.coachUpdate)
                    value.medicalStaffUpdate != null ->
                        generator.writeObject(value.medicalStaffUpdate)
                    value.equipmentManagerUpdate != null ->
                        generator.writeObject(value.equipmentManagerUpdate)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Updates")
                }
            }
        }

        /** Update model for players. */
        class PlayerUpdate
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val assists: JsonField<Long>,
            private val goalsScored: JsonField<Long>,
            private val isCaptain: JsonField<Boolean>,
            private val jerseyNumber: JsonField<Long>,
            private val position: JsonField<Position>,
            private val teamId: JsonField<String>,
            private val yearsWithTeam: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("assists")
                @ExcludeMissing
                assists: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("goals_scored")
                @ExcludeMissing
                goalsScored: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("is_captain")
                @ExcludeMissing
                isCaptain: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("jersey_number")
                @ExcludeMissing
                jerseyNumber: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("position")
                @ExcludeMissing
                position: JsonField<Position> = JsonMissing.of(),
                @JsonProperty("team_id")
                @ExcludeMissing
                teamId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("years_with_team")
                @ExcludeMissing
                yearsWithTeam: JsonField<Long> = JsonMissing.of(),
            ) : this(
                assists,
                goalsScored,
                isCaptain,
                jerseyNumber,
                position,
                teamId,
                yearsWithTeam,
                mutableMapOf(),
            )

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun assists(): Long? = assists.getNullable("assists")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun goalsScored(): Long? = goalsScored.getNullable("goals_scored")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun isCaptain(): Boolean? = isCaptain.getNullable("is_captain")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun jerseyNumber(): Long? = jerseyNumber.getNullable("jersey_number")

            /**
             * Football positions for players.
             *
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun position(): Position? = position.getNullable("position")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun teamId(): String? = teamId.getNullable("team_id")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun yearsWithTeam(): Long? = yearsWithTeam.getNullable("years_with_team")

            /**
             * Returns the raw JSON value of [assists].
             *
             * Unlike [assists], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("assists") @ExcludeMissing fun _assists(): JsonField<Long> = assists

            /**
             * Returns the raw JSON value of [goalsScored].
             *
             * Unlike [goalsScored], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("goals_scored")
            @ExcludeMissing
            fun _goalsScored(): JsonField<Long> = goalsScored

            /**
             * Returns the raw JSON value of [isCaptain].
             *
             * Unlike [isCaptain], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("is_captain")
            @ExcludeMissing
            fun _isCaptain(): JsonField<Boolean> = isCaptain

            /**
             * Returns the raw JSON value of [jerseyNumber].
             *
             * Unlike [jerseyNumber], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("jersey_number")
            @ExcludeMissing
            fun _jerseyNumber(): JsonField<Long> = jerseyNumber

            /**
             * Returns the raw JSON value of [position].
             *
             * Unlike [position], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("position")
            @ExcludeMissing
            fun _position(): JsonField<Position> = position

            /**
             * Returns the raw JSON value of [teamId].
             *
             * Unlike [teamId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("team_id") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

            /**
             * Returns the raw JSON value of [yearsWithTeam].
             *
             * Unlike [yearsWithTeam], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("years_with_team")
            @ExcludeMissing
            fun _yearsWithTeam(): JsonField<Long> = yearsWithTeam

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

                /** Returns a mutable builder for constructing an instance of [PlayerUpdate]. */
                fun builder() = Builder()
            }

            /** A builder for [PlayerUpdate]. */
            class Builder internal constructor() {

                private var assists: JsonField<Long> = JsonMissing.of()
                private var goalsScored: JsonField<Long> = JsonMissing.of()
                private var isCaptain: JsonField<Boolean> = JsonMissing.of()
                private var jerseyNumber: JsonField<Long> = JsonMissing.of()
                private var position: JsonField<Position> = JsonMissing.of()
                private var teamId: JsonField<String> = JsonMissing.of()
                private var yearsWithTeam: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(playerUpdate: PlayerUpdate) = apply {
                    assists = playerUpdate.assists
                    goalsScored = playerUpdate.goalsScored
                    isCaptain = playerUpdate.isCaptain
                    jerseyNumber = playerUpdate.jerseyNumber
                    position = playerUpdate.position
                    teamId = playerUpdate.teamId
                    yearsWithTeam = playerUpdate.yearsWithTeam
                    additionalProperties = playerUpdate.additionalProperties.toMutableMap()
                }

                fun assists(assists: Long?) = assists(JsonField.ofNullable(assists))

                /**
                 * Alias for [Builder.assists].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun assists(assists: Long) = assists(assists as Long?)

                /**
                 * Sets [Builder.assists] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.assists] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun assists(assists: JsonField<Long>) = apply { this.assists = assists }

                fun goalsScored(goalsScored: Long?) = goalsScored(JsonField.ofNullable(goalsScored))

                /**
                 * Alias for [Builder.goalsScored].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun goalsScored(goalsScored: Long) = goalsScored(goalsScored as Long?)

                /**
                 * Sets [Builder.goalsScored] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.goalsScored] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun goalsScored(goalsScored: JsonField<Long>) = apply {
                    this.goalsScored = goalsScored
                }

                fun isCaptain(isCaptain: Boolean?) = isCaptain(JsonField.ofNullable(isCaptain))

                /**
                 * Alias for [Builder.isCaptain].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun isCaptain(isCaptain: Boolean) = isCaptain(isCaptain as Boolean?)

                /**
                 * Sets [Builder.isCaptain] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.isCaptain] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun isCaptain(isCaptain: JsonField<Boolean>) = apply { this.isCaptain = isCaptain }

                fun jerseyNumber(jerseyNumber: Long?) =
                    jerseyNumber(JsonField.ofNullable(jerseyNumber))

                /**
                 * Alias for [Builder.jerseyNumber].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun jerseyNumber(jerseyNumber: Long) = jerseyNumber(jerseyNumber as Long?)

                /**
                 * Sets [Builder.jerseyNumber] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.jerseyNumber] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun jerseyNumber(jerseyNumber: JsonField<Long>) = apply {
                    this.jerseyNumber = jerseyNumber
                }

                /** Football positions for players. */
                fun position(position: Position?) = position(JsonField.ofNullable(position))

                /**
                 * Sets [Builder.position] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.position] with a well-typed [Position] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun position(position: JsonField<Position>) = apply { this.position = position }

                fun teamId(teamId: String?) = teamId(JsonField.ofNullable(teamId))

                /**
                 * Sets [Builder.teamId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.teamId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun teamId(teamId: JsonField<String>) = apply { this.teamId = teamId }

                fun yearsWithTeam(yearsWithTeam: Long?) =
                    yearsWithTeam(JsonField.ofNullable(yearsWithTeam))

                /**
                 * Alias for [Builder.yearsWithTeam].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun yearsWithTeam(yearsWithTeam: Long) = yearsWithTeam(yearsWithTeam as Long?)

                /**
                 * Sets [Builder.yearsWithTeam] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.yearsWithTeam] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun yearsWithTeam(yearsWithTeam: JsonField<Long>) = apply {
                    this.yearsWithTeam = yearsWithTeam
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [PlayerUpdate].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): PlayerUpdate =
                    PlayerUpdate(
                        assists,
                        goalsScored,
                        isCaptain,
                        jerseyNumber,
                        position,
                        teamId,
                        yearsWithTeam,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): PlayerUpdate = apply {
                if (validated) {
                    return@apply
                }

                assists()
                goalsScored()
                isCaptain()
                jerseyNumber()
                position()?.validate()
                teamId()
                yearsWithTeam()
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
                (if (assists.asKnown() == null) 0 else 1) +
                    (if (goalsScored.asKnown() == null) 0 else 1) +
                    (if (isCaptain.asKnown() == null) 0 else 1) +
                    (if (jerseyNumber.asKnown() == null) 0 else 1) +
                    (position.asKnown()?.validity() ?: 0) +
                    (if (teamId.asKnown() == null) 0 else 1) +
                    (if (yearsWithTeam.asKnown() == null) 0 else 1)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is PlayerUpdate &&
                    assists == other.assists &&
                    goalsScored == other.goalsScored &&
                    isCaptain == other.isCaptain &&
                    jerseyNumber == other.jerseyNumber &&
                    position == other.position &&
                    teamId == other.teamId &&
                    yearsWithTeam == other.yearsWithTeam &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    assists,
                    goalsScored,
                    isCaptain,
                    jerseyNumber,
                    position,
                    teamId,
                    yearsWithTeam,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "PlayerUpdate{assists=$assists, goalsScored=$goalsScored, isCaptain=$isCaptain, jerseyNumber=$jerseyNumber, position=$position, teamId=$teamId, yearsWithTeam=$yearsWithTeam, additionalProperties=$additionalProperties}"
        }

        /** Update model for coaches. */
        class CoachUpdate
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val certifications: JsonField<List<String>>,
            private val specialty: JsonField<CoachSpecialty>,
            private val teamId: JsonField<String>,
            private val winRate: JsonField<Double>,
            private val yearsWithTeam: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("certifications")
                @ExcludeMissing
                certifications: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("specialty")
                @ExcludeMissing
                specialty: JsonField<CoachSpecialty> = JsonMissing.of(),
                @JsonProperty("team_id")
                @ExcludeMissing
                teamId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("win_rate")
                @ExcludeMissing
                winRate: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("years_with_team")
                @ExcludeMissing
                yearsWithTeam: JsonField<Long> = JsonMissing.of(),
            ) : this(certifications, specialty, teamId, winRate, yearsWithTeam, mutableMapOf())

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun certifications(): List<String>? = certifications.getNullable("certifications")

            /**
             * Coaching specialties.
             *
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun specialty(): CoachSpecialty? = specialty.getNullable("specialty")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun teamId(): String? = teamId.getNullable("team_id")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun winRate(): Double? = winRate.getNullable("win_rate")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun yearsWithTeam(): Long? = yearsWithTeam.getNullable("years_with_team")

            /**
             * Returns the raw JSON value of [certifications].
             *
             * Unlike [certifications], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("certifications")
            @ExcludeMissing
            fun _certifications(): JsonField<List<String>> = certifications

            /**
             * Returns the raw JSON value of [specialty].
             *
             * Unlike [specialty], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("specialty")
            @ExcludeMissing
            fun _specialty(): JsonField<CoachSpecialty> = specialty

            /**
             * Returns the raw JSON value of [teamId].
             *
             * Unlike [teamId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("team_id") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

            /**
             * Returns the raw JSON value of [winRate].
             *
             * Unlike [winRate], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("win_rate") @ExcludeMissing fun _winRate(): JsonField<Double> = winRate

            /**
             * Returns the raw JSON value of [yearsWithTeam].
             *
             * Unlike [yearsWithTeam], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("years_with_team")
            @ExcludeMissing
            fun _yearsWithTeam(): JsonField<Long> = yearsWithTeam

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

                /** Returns a mutable builder for constructing an instance of [CoachUpdate]. */
                fun builder() = Builder()
            }

            /** A builder for [CoachUpdate]. */
            class Builder internal constructor() {

                private var certifications: JsonField<MutableList<String>>? = null
                private var specialty: JsonField<CoachSpecialty> = JsonMissing.of()
                private var teamId: JsonField<String> = JsonMissing.of()
                private var winRate: JsonField<Double> = JsonMissing.of()
                private var yearsWithTeam: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(coachUpdate: CoachUpdate) = apply {
                    certifications = coachUpdate.certifications.map { it.toMutableList() }
                    specialty = coachUpdate.specialty
                    teamId = coachUpdate.teamId
                    winRate = coachUpdate.winRate
                    yearsWithTeam = coachUpdate.yearsWithTeam
                    additionalProperties = coachUpdate.additionalProperties.toMutableMap()
                }

                fun certifications(certifications: List<String>?) =
                    certifications(JsonField.ofNullable(certifications))

                /**
                 * Sets [Builder.certifications] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.certifications] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun certifications(certifications: JsonField<List<String>>) = apply {
                    this.certifications = certifications.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [certifications].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addCertification(certification: String) = apply {
                    certifications =
                        (certifications ?: JsonField.of(mutableListOf())).also {
                            checkKnown("certifications", it).add(certification)
                        }
                }

                /** Coaching specialties. */
                fun specialty(specialty: CoachSpecialty?) =
                    specialty(JsonField.ofNullable(specialty))

                /**
                 * Sets [Builder.specialty] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.specialty] with a well-typed [CoachSpecialty]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun specialty(specialty: JsonField<CoachSpecialty>) = apply {
                    this.specialty = specialty
                }

                fun teamId(teamId: String?) = teamId(JsonField.ofNullable(teamId))

                /**
                 * Sets [Builder.teamId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.teamId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun teamId(teamId: JsonField<String>) = apply { this.teamId = teamId }

                fun winRate(winRate: Double?) = winRate(JsonField.ofNullable(winRate))

                /**
                 * Alias for [Builder.winRate].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun winRate(winRate: Double) = winRate(winRate as Double?)

                /**
                 * Sets [Builder.winRate] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.winRate] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun winRate(winRate: JsonField<Double>) = apply { this.winRate = winRate }

                fun yearsWithTeam(yearsWithTeam: Long?) =
                    yearsWithTeam(JsonField.ofNullable(yearsWithTeam))

                /**
                 * Alias for [Builder.yearsWithTeam].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun yearsWithTeam(yearsWithTeam: Long) = yearsWithTeam(yearsWithTeam as Long?)

                /**
                 * Sets [Builder.yearsWithTeam] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.yearsWithTeam] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun yearsWithTeam(yearsWithTeam: JsonField<Long>) = apply {
                    this.yearsWithTeam = yearsWithTeam
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [CoachUpdate].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): CoachUpdate =
                    CoachUpdate(
                        (certifications ?: JsonMissing.of()).map { it.toImmutable() },
                        specialty,
                        teamId,
                        winRate,
                        yearsWithTeam,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): CoachUpdate = apply {
                if (validated) {
                    return@apply
                }

                certifications()
                specialty()?.validate()
                teamId()
                winRate()
                yearsWithTeam()
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
                (certifications.asKnown()?.size ?: 0) +
                    (specialty.asKnown()?.validity() ?: 0) +
                    (if (teamId.asKnown() == null) 0 else 1) +
                    (if (winRate.asKnown() == null) 0 else 1) +
                    (if (yearsWithTeam.asKnown() == null) 0 else 1)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CoachUpdate &&
                    certifications == other.certifications &&
                    specialty == other.specialty &&
                    teamId == other.teamId &&
                    winRate == other.winRate &&
                    yearsWithTeam == other.yearsWithTeam &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    certifications,
                    specialty,
                    teamId,
                    winRate,
                    yearsWithTeam,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CoachUpdate{certifications=$certifications, specialty=$specialty, teamId=$teamId, winRate=$winRate, yearsWithTeam=$yearsWithTeam, additionalProperties=$additionalProperties}"
        }

        /** Update model for medical staff. */
        class MedicalStaffUpdate
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val licenseNumber: JsonField<String>,
            private val qualifications: JsonField<List<String>>,
            private val specialty: JsonField<MedicalSpecialty>,
            private val teamId: JsonField<String>,
            private val yearsWithTeam: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("license_number")
                @ExcludeMissing
                licenseNumber: JsonField<String> = JsonMissing.of(),
                @JsonProperty("qualifications")
                @ExcludeMissing
                qualifications: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("specialty")
                @ExcludeMissing
                specialty: JsonField<MedicalSpecialty> = JsonMissing.of(),
                @JsonProperty("team_id")
                @ExcludeMissing
                teamId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("years_with_team")
                @ExcludeMissing
                yearsWithTeam: JsonField<Long> = JsonMissing.of(),
            ) : this(
                licenseNumber,
                qualifications,
                specialty,
                teamId,
                yearsWithTeam,
                mutableMapOf(),
            )

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun licenseNumber(): String? = licenseNumber.getNullable("license_number")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun qualifications(): List<String>? = qualifications.getNullable("qualifications")

            /**
             * Medical staff specialties.
             *
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun specialty(): MedicalSpecialty? = specialty.getNullable("specialty")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun teamId(): String? = teamId.getNullable("team_id")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun yearsWithTeam(): Long? = yearsWithTeam.getNullable("years_with_team")

            /**
             * Returns the raw JSON value of [licenseNumber].
             *
             * Unlike [licenseNumber], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("license_number")
            @ExcludeMissing
            fun _licenseNumber(): JsonField<String> = licenseNumber

            /**
             * Returns the raw JSON value of [qualifications].
             *
             * Unlike [qualifications], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("qualifications")
            @ExcludeMissing
            fun _qualifications(): JsonField<List<String>> = qualifications

            /**
             * Returns the raw JSON value of [specialty].
             *
             * Unlike [specialty], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("specialty")
            @ExcludeMissing
            fun _specialty(): JsonField<MedicalSpecialty> = specialty

            /**
             * Returns the raw JSON value of [teamId].
             *
             * Unlike [teamId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("team_id") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

            /**
             * Returns the raw JSON value of [yearsWithTeam].
             *
             * Unlike [yearsWithTeam], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("years_with_team")
            @ExcludeMissing
            fun _yearsWithTeam(): JsonField<Long> = yearsWithTeam

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

                /**
                 * Returns a mutable builder for constructing an instance of [MedicalStaffUpdate].
                 */
                fun builder() = Builder()
            }

            /** A builder for [MedicalStaffUpdate]. */
            class Builder internal constructor() {

                private var licenseNumber: JsonField<String> = JsonMissing.of()
                private var qualifications: JsonField<MutableList<String>>? = null
                private var specialty: JsonField<MedicalSpecialty> = JsonMissing.of()
                private var teamId: JsonField<String> = JsonMissing.of()
                private var yearsWithTeam: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(medicalStaffUpdate: MedicalStaffUpdate) = apply {
                    licenseNumber = medicalStaffUpdate.licenseNumber
                    qualifications = medicalStaffUpdate.qualifications.map { it.toMutableList() }
                    specialty = medicalStaffUpdate.specialty
                    teamId = medicalStaffUpdate.teamId
                    yearsWithTeam = medicalStaffUpdate.yearsWithTeam
                    additionalProperties = medicalStaffUpdate.additionalProperties.toMutableMap()
                }

                fun licenseNumber(licenseNumber: String?) =
                    licenseNumber(JsonField.ofNullable(licenseNumber))

                /**
                 * Sets [Builder.licenseNumber] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.licenseNumber] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun licenseNumber(licenseNumber: JsonField<String>) = apply {
                    this.licenseNumber = licenseNumber
                }

                fun qualifications(qualifications: List<String>?) =
                    qualifications(JsonField.ofNullable(qualifications))

                /**
                 * Sets [Builder.qualifications] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.qualifications] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun qualifications(qualifications: JsonField<List<String>>) = apply {
                    this.qualifications = qualifications.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [qualifications].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addQualification(qualification: String) = apply {
                    qualifications =
                        (qualifications ?: JsonField.of(mutableListOf())).also {
                            checkKnown("qualifications", it).add(qualification)
                        }
                }

                /** Medical staff specialties. */
                fun specialty(specialty: MedicalSpecialty?) =
                    specialty(JsonField.ofNullable(specialty))

                /**
                 * Sets [Builder.specialty] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.specialty] with a well-typed [MedicalSpecialty]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun specialty(specialty: JsonField<MedicalSpecialty>) = apply {
                    this.specialty = specialty
                }

                fun teamId(teamId: String?) = teamId(JsonField.ofNullable(teamId))

                /**
                 * Sets [Builder.teamId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.teamId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun teamId(teamId: JsonField<String>) = apply { this.teamId = teamId }

                fun yearsWithTeam(yearsWithTeam: Long?) =
                    yearsWithTeam(JsonField.ofNullable(yearsWithTeam))

                /**
                 * Alias for [Builder.yearsWithTeam].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun yearsWithTeam(yearsWithTeam: Long) = yearsWithTeam(yearsWithTeam as Long?)

                /**
                 * Sets [Builder.yearsWithTeam] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.yearsWithTeam] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun yearsWithTeam(yearsWithTeam: JsonField<Long>) = apply {
                    this.yearsWithTeam = yearsWithTeam
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [MedicalStaffUpdate].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): MedicalStaffUpdate =
                    MedicalStaffUpdate(
                        licenseNumber,
                        (qualifications ?: JsonMissing.of()).map { it.toImmutable() },
                        specialty,
                        teamId,
                        yearsWithTeam,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): MedicalStaffUpdate = apply {
                if (validated) {
                    return@apply
                }

                licenseNumber()
                qualifications()
                specialty()?.validate()
                teamId()
                yearsWithTeam()
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
                (if (licenseNumber.asKnown() == null) 0 else 1) +
                    (qualifications.asKnown()?.size ?: 0) +
                    (specialty.asKnown()?.validity() ?: 0) +
                    (if (teamId.asKnown() == null) 0 else 1) +
                    (if (yearsWithTeam.asKnown() == null) 0 else 1)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is MedicalStaffUpdate &&
                    licenseNumber == other.licenseNumber &&
                    qualifications == other.qualifications &&
                    specialty == other.specialty &&
                    teamId == other.teamId &&
                    yearsWithTeam == other.yearsWithTeam &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    licenseNumber,
                    qualifications,
                    specialty,
                    teamId,
                    yearsWithTeam,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "MedicalStaffUpdate{licenseNumber=$licenseNumber, qualifications=$qualifications, specialty=$specialty, teamId=$teamId, yearsWithTeam=$yearsWithTeam, additionalProperties=$additionalProperties}"
        }

        /** Update model for equipment managers. */
        class EquipmentManagerUpdate
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val isHeadKitman: JsonField<Boolean>,
            private val responsibilities: JsonField<List<String>>,
            private val teamId: JsonField<String>,
            private val yearsWithTeam: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("is_head_kitman")
                @ExcludeMissing
                isHeadKitman: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("responsibilities")
                @ExcludeMissing
                responsibilities: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("team_id")
                @ExcludeMissing
                teamId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("years_with_team")
                @ExcludeMissing
                yearsWithTeam: JsonField<Long> = JsonMissing.of(),
            ) : this(isHeadKitman, responsibilities, teamId, yearsWithTeam, mutableMapOf())

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun isHeadKitman(): Boolean? = isHeadKitman.getNullable("is_head_kitman")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun responsibilities(): List<String>? = responsibilities.getNullable("responsibilities")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun teamId(): String? = teamId.getNullable("team_id")

            /**
             * @throws BelieveInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun yearsWithTeam(): Long? = yearsWithTeam.getNullable("years_with_team")

            /**
             * Returns the raw JSON value of [isHeadKitman].
             *
             * Unlike [isHeadKitman], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("is_head_kitman")
            @ExcludeMissing
            fun _isHeadKitman(): JsonField<Boolean> = isHeadKitman

            /**
             * Returns the raw JSON value of [responsibilities].
             *
             * Unlike [responsibilities], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("responsibilities")
            @ExcludeMissing
            fun _responsibilities(): JsonField<List<String>> = responsibilities

            /**
             * Returns the raw JSON value of [teamId].
             *
             * Unlike [teamId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("team_id") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

            /**
             * Returns the raw JSON value of [yearsWithTeam].
             *
             * Unlike [yearsWithTeam], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("years_with_team")
            @ExcludeMissing
            fun _yearsWithTeam(): JsonField<Long> = yearsWithTeam

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

                /**
                 * Returns a mutable builder for constructing an instance of
                 * [EquipmentManagerUpdate].
                 */
                fun builder() = Builder()
            }

            /** A builder for [EquipmentManagerUpdate]. */
            class Builder internal constructor() {

                private var isHeadKitman: JsonField<Boolean> = JsonMissing.of()
                private var responsibilities: JsonField<MutableList<String>>? = null
                private var teamId: JsonField<String> = JsonMissing.of()
                private var yearsWithTeam: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(equipmentManagerUpdate: EquipmentManagerUpdate) = apply {
                    isHeadKitman = equipmentManagerUpdate.isHeadKitman
                    responsibilities =
                        equipmentManagerUpdate.responsibilities.map { it.toMutableList() }
                    teamId = equipmentManagerUpdate.teamId
                    yearsWithTeam = equipmentManagerUpdate.yearsWithTeam
                    additionalProperties =
                        equipmentManagerUpdate.additionalProperties.toMutableMap()
                }

                fun isHeadKitman(isHeadKitman: Boolean?) =
                    isHeadKitman(JsonField.ofNullable(isHeadKitman))

                /**
                 * Alias for [Builder.isHeadKitman].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun isHeadKitman(isHeadKitman: Boolean) = isHeadKitman(isHeadKitman as Boolean?)

                /**
                 * Sets [Builder.isHeadKitman] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.isHeadKitman] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun isHeadKitman(isHeadKitman: JsonField<Boolean>) = apply {
                    this.isHeadKitman = isHeadKitman
                }

                fun responsibilities(responsibilities: List<String>?) =
                    responsibilities(JsonField.ofNullable(responsibilities))

                /**
                 * Sets [Builder.responsibilities] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.responsibilities] with a well-typed
                 * `List<String>` value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun responsibilities(responsibilities: JsonField<List<String>>) = apply {
                    this.responsibilities = responsibilities.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [responsibilities].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addResponsibility(responsibility: String) = apply {
                    responsibilities =
                        (responsibilities ?: JsonField.of(mutableListOf())).also {
                            checkKnown("responsibilities", it).add(responsibility)
                        }
                }

                fun teamId(teamId: String?) = teamId(JsonField.ofNullable(teamId))

                /**
                 * Sets [Builder.teamId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.teamId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun teamId(teamId: JsonField<String>) = apply { this.teamId = teamId }

                fun yearsWithTeam(yearsWithTeam: Long?) =
                    yearsWithTeam(JsonField.ofNullable(yearsWithTeam))

                /**
                 * Alias for [Builder.yearsWithTeam].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun yearsWithTeam(yearsWithTeam: Long) = yearsWithTeam(yearsWithTeam as Long?)

                /**
                 * Sets [Builder.yearsWithTeam] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.yearsWithTeam] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun yearsWithTeam(yearsWithTeam: JsonField<Long>) = apply {
                    this.yearsWithTeam = yearsWithTeam
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [EquipmentManagerUpdate].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): EquipmentManagerUpdate =
                    EquipmentManagerUpdate(
                        isHeadKitman,
                        (responsibilities ?: JsonMissing.of()).map { it.toImmutable() },
                        teamId,
                        yearsWithTeam,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): EquipmentManagerUpdate = apply {
                if (validated) {
                    return@apply
                }

                isHeadKitman()
                responsibilities()
                teamId()
                yearsWithTeam()
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
                (if (isHeadKitman.asKnown() == null) 0 else 1) +
                    (responsibilities.asKnown()?.size ?: 0) +
                    (if (teamId.asKnown() == null) 0 else 1) +
                    (if (yearsWithTeam.asKnown() == null) 0 else 1)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EquipmentManagerUpdate &&
                    isHeadKitman == other.isHeadKitman &&
                    responsibilities == other.responsibilities &&
                    teamId == other.teamId &&
                    yearsWithTeam == other.yearsWithTeam &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    isHeadKitman,
                    responsibilities,
                    teamId,
                    yearsWithTeam,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "EquipmentManagerUpdate{isHeadKitman=$isHeadKitman, responsibilities=$responsibilities, teamId=$teamId, yearsWithTeam=$yearsWithTeam, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TeamMemberUpdateParams &&
            memberId == other.memberId &&
            updates == other.updates &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(memberId, updates, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "TeamMemberUpdateParams{memberId=$memberId, updates=$updates, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
