package org.daonators.model.rm

import org.daonators.model.resource.CampaingType
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table campaing_type
 * @author Simpli CLI generator
 */
object CampaingTypeRM {
    fun build(rs: ResultSet, alias: String = "campaing_type", allowedColumns: Array<String> = selectFields(alias)) = CampaingType().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idCampaingTypePk = getLong("idCampaingTypePk")
            name = getString("name")
            active = getBoolean("active")
        }
    }

    fun selectFields(alias: String = "campaing_type") = arrayOf(
            "$alias.idCampaingTypePk",
            "$alias.name",
            "$alias.active"
    )

    fun fieldsToSearch(alias: String = "campaing_type") = arrayOf(
            "$alias.idCampaingTypePk",
            "$alias.name"
    )

    fun orderMap(alias: String = "campaing_type") = mapOf(
            "idCampaingTypePk" to "$alias.idCampaingTypePk",
            "name" to "$alias.name",
            "active" to "$alias.active"
    )

    fun updateSet(campaingType: CampaingType) = mapOf(
            "name" to campaingType.name,
            "active" to campaingType.active
    )

    fun insertValues(campaingType: CampaingType) = mapOf(
            "name" to campaingType.name,
            "active" to campaingType.active
    )
}
