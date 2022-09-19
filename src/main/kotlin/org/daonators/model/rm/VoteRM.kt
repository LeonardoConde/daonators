package org.daonators.model.rm

import org.daonators.model.resource.Vote
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table vote
 * @author Simpli CLI generator
 */
object VoteRM {
    fun build(rs: ResultSet, alias: String = "vote", allowedColumns: Array<String> = selectFields(alias)) = Vote().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idVotePk = getLong("idVotePk")
            lastUpdate = getTimestamp("lastUpdate")
            tokensAmount = getString("tokensAmount")
            idCampaingFk = getLong("idCampaingFk")
            idOrganizationFk = getLong("idOrganizationFk")
            idUserWalletFk = getLong("idUserWalletFk")
        }
    }

    fun selectFields(alias: String = "vote") = arrayOf(
            "$alias.idVotePk",
            "$alias.lastUpdate",
            "$alias.tokensAmount",
            "$alias.idCampaingFk",
            "$alias.idOrganizationFk",
            "$alias.idUserWalletFk"
    )

    fun fieldsToSearch(alias: String = "vote") = arrayOf(
            "$alias.idVotePk",
            "$alias.tokensAmount"
    )

    fun orderMap(alias: String = "vote") = mapOf(
            "campaingOrganization" to "$alias.idCampaingFk",
            "userWallet" to "$alias.idUserWalletFk",
            "idVotePk" to "$alias.idVotePk",
            "lastUpdate" to "$alias.lastUpdate",
            "tokensAmount" to "$alias.tokensAmount",
            "idOrganizationFk" to "$alias.idOrganizationFk"
    )

    fun updateSet(vote: Vote) = mapOf(
            "lastUpdate" to vote.lastUpdate,
            "tokensAmount" to vote.tokensAmount,
            "idCampaingFk" to vote.idCampaingFk,
            "idOrganizationFk" to vote.idOrganizationFk,
            "idUserWalletFk" to vote.idUserWalletFk
    )

    fun insertValues(vote: Vote) = mapOf(
            "lastUpdate" to vote.lastUpdate,
            "tokensAmount" to vote.tokensAmount,
            "idCampaingFk" to vote.idCampaingFk,
            "idOrganizationFk" to vote.idOrganizationFk,
            "idUserWalletFk" to vote.idUserWalletFk
    )
}
