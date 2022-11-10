package org.daonators.model.rm

import org.daonators.model.resource.Campaing
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table campaing
 * @author Simpli CLI generator
 */
object CampaingRM {
    fun build(rs: ResultSet, alias: String = "campaing", allowedColumns: Array<String> = selectFields(alias)) = Campaing().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idCampaingPk = getLong("idCampaingPk")
            name = getString("name")
            socialCause = getString("socialCause")
            beginDate = getTimestamp("beginDate")
            endDate = getTimestamp("endDate")
        }
    }

    fun selectFields(alias: String = "campaing") = arrayOf(
            "$alias.idCampaingPk",
            "$alias.name",
            "$alias.socialCause",
            "$alias.beginDate",
            "$alias.endDate"
    )

    fun fieldsToSearch(alias: String = "campaing") = arrayOf(
            "$alias.idCampaingPk",
            "$alias.name",
            "$alias.socialCause"
    )

    fun orderMap(alias: String = "campaing") = mapOf(
            "idCampaingPk" to "$alias.idCampaingPk",
            "name" to "$alias.name",
            "socialCause" to "$alias.socialCause",
            "beginDate" to "$alias.beginDate",
            "endDate" to "$alias.endDate"
    )

    fun updateSet(campaing: Campaing) = mapOf(
            "name" to campaing.name,
            "socialCause" to campaing.socialCause,
            "beginDate" to campaing.beginDate,
            "endDate" to campaing.endDate
    )

    fun insertValues(campaing: Campaing) = mapOf(
            "name" to campaing.name,
            "socialCause" to campaing.socialCause,
            "beginDate" to campaing.beginDate,
            "endDate" to campaing.endDate
    )
}
