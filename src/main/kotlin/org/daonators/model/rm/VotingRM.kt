package org.daonators.model.rm

import org.daonators.model.resource.Voting
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table voting
 * @author Simpli CLI generator
 */
object VotingRM {
    fun build(rs: ResultSet, alias: String = "voting", allowedColumns: Array<String> = selectFields(alias)) = Voting().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idVotingPk = getLong("idVotingPk")
            idOrganizationfk = getLong("idOrganizationfk")
            idCampaingFk = getLongOrNull("idCampaingFk")
            idVotingTypeFk = getLong("idVotingTypeFk")
        }
    }

    fun selectFields(alias: String = "voting") = arrayOf(
            "$alias.idVotingPk",
            "$alias.idOrganizationfk",
            "$alias.idCampaingFk",
            "$alias.idVotingTypeFk"
    )

    fun fieldsToSearch(alias: String = "voting") = arrayOf(
            "$alias.idVotingPk",
            "$alias.idOrganizationfk"
    )

    fun orderMap(alias: String = "voting") = mapOf(
            "campaing" to "$alias.idCampaingFk",
            "organization" to "$alias.idOrganizationfk",
            "votingType" to "$alias.idVotingTypeFk",
            "idVotingPk" to "$alias.idVotingPk"
    )

    fun updateSet(voting: Voting) = mapOf(
            "idCampaingFk" to voting.idCampaingFk,
            "idVotingTypeFk" to voting.idVotingTypeFk
    )

    fun insertValues(voting: Voting) = mapOf(
            "idOrganizationfk" to voting.idOrganizationfk,
            "idCampaingFk" to voting.idCampaingFk,
            "idVotingTypeFk" to voting.idVotingTypeFk
    )
}
