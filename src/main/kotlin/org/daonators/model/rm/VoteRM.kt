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
            idVotingFk = getLong("idVotingFk")
            idUserWalletFk = getLong("idUserWalletFk")
            tokenAmount = getDouble("tokenAmount")
        }
    }

    fun selectFields(alias: String = "vote") = arrayOf(
            "$alias.idVotingFk",
            "$alias.idUserWalletFk",
            "$alias.tokenAmount"
    )

    fun fieldsToSearch(alias: String = "vote") = arrayOf(
            "$alias.idVotingFk",
            "$alias.idUserWalletFk"
    )

    fun orderMap(alias: String = "vote") = mapOf(
            "userWallet" to "$alias.idUserWalletFk",
            "voting" to "$alias.idVotingFk",
            "tokenAmount" to "$alias.tokenAmount"
    )

    fun updateSet(vote: Vote) = mapOf(
            "tokenAmount" to vote.tokenAmount
    )

    fun insertValues(vote: Vote) = mapOf(
            "idVotingFk" to vote.idVotingFk,
            "idUserWalletFk" to vote.idUserWalletFk,
            "tokenAmount" to vote.tokenAmount
    )
}
