package org.daonators.model.rm

import org.daonators.model.resource.Donation
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table donation
 * @author Simpli CLI generator
 */
object DonationRM {
    fun build(rs: ResultSet, alias: String = "donation", allowedColumns: Array<String> = selectFields(alias)) = Donation().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idDonationPk = getLong("idDonationPk")
            idCampaingFk = getLong("idCampaingFk")
            idOrganizationFk = getLong("idOrganizationFk")
            gasAmount = getDouble("gasAmount")
            transactionHash = getString("transactionHash")
        }
    }

    fun selectFields(alias: String = "donation") = arrayOf(
            "$alias.idDonationPk",
            "$alias.idCampaingFk",
            "$alias.idOrganizationFk",
            "$alias.gasAmount",
            "$alias.transactionHash"
    )

    fun fieldsToSearch(alias: String = "donation") = arrayOf(
            "$alias.idDonationPk",
            "$alias.idCampaingFk",
            "$alias.idOrganizationFk",
            "$alias.transactionHash"
    )

    fun orderMap(alias: String = "donation") = mapOf(
            "campaing" to "$alias.idCampaingFk",
            "organization" to "$alias.idOrganizationFk",
            "idDonationPk" to "$alias.idDonationPk",
            "gasAmount" to "$alias.gasAmount",
            "transactionHash" to "$alias.transactionHash"
    )

    fun updateSet(donation: Donation) = mapOf(
            "gasAmount" to donation.gasAmount,
            "transactionHash" to donation.transactionHash
    )

    fun insertValues(donation: Donation) = mapOf(
            "idCampaingFk" to donation.idCampaingFk,
            "idOrganizationFk" to donation.idOrganizationFk,
            "gasAmount" to donation.gasAmount,
            "transactionHash" to donation.transactionHash
    )
}
