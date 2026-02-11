// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.teammembers

import com.believe.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EquipmentManagerTest {

    @Test
    fun create() {
        val equipmentManager =
            EquipmentManager.builder()
                .id("nate-kitman-richmond")
                .characterId("nathan-shelley")
                .teamId("afc-richmond")
                .yearsWithTeam(5L)
                .isHeadKitman(true)
                .memberType(EquipmentManager.MemberType.EQUIPMENT_MANAGER)
                .addResponsibility("Kit preparation")
                .addResponsibility("Equipment maintenance")
                .build()

        assertThat(equipmentManager.id()).isEqualTo("nate-kitman-richmond")
        assertThat(equipmentManager.characterId()).isEqualTo("nathan-shelley")
        assertThat(equipmentManager.teamId()).isEqualTo("afc-richmond")
        assertThat(equipmentManager.yearsWithTeam()).isEqualTo(5L)
        assertThat(equipmentManager.isHeadKitman()).isEqualTo(true)
        assertThat(equipmentManager.memberType())
            .isEqualTo(EquipmentManager.MemberType.EQUIPMENT_MANAGER)
        assertThat(equipmentManager.responsibilities())
            .containsExactly("Kit preparation", "Equipment maintenance")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val equipmentManager =
            EquipmentManager.builder()
                .id("nate-kitman-richmond")
                .characterId("nathan-shelley")
                .teamId("afc-richmond")
                .yearsWithTeam(5L)
                .isHeadKitman(true)
                .memberType(EquipmentManager.MemberType.EQUIPMENT_MANAGER)
                .addResponsibility("Kit preparation")
                .addResponsibility("Equipment maintenance")
                .build()

        val roundtrippedEquipmentManager =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(equipmentManager),
                jacksonTypeRef<EquipmentManager>(),
            )

        assertThat(roundtrippedEquipmentManager).isEqualTo(equipmentManager)
    }
}
