package org.daonators.model.rm

import org.daonators.model.resource.VotingType
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table voting_type
 * @author Simpli CLI generator
 */
object VotingTypeRM {
    fun build(rs: ResultSet, alias: String = "voting_type", allowedColumns: Array<String> = selectFields(alias)) = VotingType().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idVotingTypePk = getLong("idVotingTypePk")
            name = getString("name")
            active = getBoolean("active")
        }
    }

    fun selectFields(alias: String = "voting_type") = arrayOf(
            "$alias.idVotingTypePk",
            "$alias.name",
            "$alias.active"
    )

    fun fieldsToSearch(alias: String = "voting_type") = arrayOf(
            "$alias.idVotingTypePk",
            "$alias.name"
    )

    fun orderMap(alias: String = "voting_type") = mapOf(
            "idVotingTypePk" to "$alias.idVotingTypePk",
            "name" to "$alias.name",
            "active" to "$alias.active"
    )

    fun updateSet(votingType: VotingType) = mapOf(
            "name" to votingType.name,
            "active" to votingType.active
    )

    fun insertValues(votingType: VotingType) = mapOf(
            "name" to votingType.name,
            "active" to votingType.active
    )
}
