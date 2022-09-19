package org.daonators.model.rm

import org.daonators.model.resource.CampaingOrganization
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table campaing_organization
 * @author Simpli CLI generator
 */
object CampaingOrganizationRM {
    fun build(rs: ResultSet, alias: String = "campaing_organization", allowedColumns: Array<String> = selectFields(alias)) = CampaingOrganization().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idCampaingFk = getLong("idCampaingFk")
            idOrganizationFk = getLong("idOrganizationFk")
            transactionHash = getString("transactionHash")
            gasAmount = getDoubleOrNull("gasAmount")
        }
    }

    fun selectFields(alias: String = "campaing_organization") = arrayOf(
            "$alias.idCampaingFk",
            "$alias.idOrganizationFk",
            "$alias.transactionHash",
            "$alias.gasAmount"
    )

    fun fieldsToSearch(alias: String = "campaing_organization") = arrayOf(
            "$alias.idCampaingFk",
            "$alias.idOrganizationFk",
            "$alias.transactionHash"
    )

    fun orderMap(alias: String = "campaing_organization") = mapOf(
            "campaing" to "$alias.idCampaingFk",
            "organization" to "$alias.idOrganizationFk",
            "transactionHash" to "$alias.transactionHash",
            "gasAmount" to "$alias.gasAmount"
    )

    fun updateSet(campaingOrganization: CampaingOrganization) = mapOf(
            "transactionHash" to campaingOrganization.transactionHash,
            "gasAmount" to campaingOrganization.gasAmount
    )

    fun insertValues(campaingOrganization: CampaingOrganization) = mapOf(
            "idCampaingFk" to campaingOrganization.idCampaingFk,
            "idOrganizationFk" to campaingOrganization.idOrganizationFk,
            "transactionHash" to campaingOrganization.transactionHash,
            "gasAmount" to campaingOrganization.gasAmount
    )
}
