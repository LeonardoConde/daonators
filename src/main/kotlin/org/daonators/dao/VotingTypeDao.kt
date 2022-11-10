package org.daonators.dao

import org.daonators.model.filter.VotingTypeListFilter
import org.daonators.model.resource.VotingType
import org.daonators.model.rm.VotingTypeRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of VotingType from table voting_type
 * @author Simpli CLI generator
 */
class VotingTypeDao(val con: AbstractConnector) {
    fun getOne(idVotingTypePk: Long): VotingType? {
        // TODO: review generated method
        val query = Query()
                .selectVotingType()
                .from("voting_type")
                .whereEq("idVotingTypePk", idVotingTypePk)

        return con.getOne(query) {
            VotingTypeRM.build(it)
        }
    }

    fun getList(filter: VotingTypeListFilter): MutableList<VotingType> {
        // TODO: review generated method
        val query = Query()
                .selectVotingType()
                .from("voting_type")
                .whereVotingTypeFilter(filter)
                .orderAndLimitVotingType(filter)

        return con.getList(query) {
            VotingTypeRM.build(it)
        }
    }

    fun count(filter: VotingTypeListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idVotingTypePk")
                .from("voting_type")
                .whereVotingTypeFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(votingType: VotingType): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("voting_type")
                .updateVotingTypeSet(votingType)
                .whereEq("idVotingTypePk", votingType.id)

        return con.execute(query).affectedRows
    }

    fun insert(votingType: VotingType): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("voting_type")
                .insertVotingTypeValues(votingType)

        return con.execute(query).key
    }

    fun exist(idVotingTypePk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idVotingTypePk")
                .from("voting_type")
                .whereEq("idVotingTypePk", idVotingTypePk)

        return con.exist(query)
    }

    fun softDelete(idVotingTypePk: Long): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("voting_type")
                .updateSet("active" to false)
                .whereEq("idVotingTypePk", idVotingTypePk)

        return con.execute(query).affectedRows
    }

    private fun Query.selectVotingType() = selectFields(VotingTypeRM.selectFields())

    private fun Query.updateVotingTypeSet(votingType: VotingType) = updateSet(VotingTypeRM.updateSet(votingType))

    private fun Query.insertVotingTypeValues(votingType: VotingType) = insertValues(VotingTypeRM.insertValues(votingType))

    private fun Query.whereVotingTypeFilter(filter: VotingTypeListFilter, alias: String = "voting_type"): Query {
        whereEq("$alias.active", true)

        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(VotingTypeRM.fieldsToSearch(alias), "%$it%")
            }
        }

        return this
    }

    private fun Query.orderAndLimitVotingType(filter: VotingTypeListFilter, alias: String = "voting_type"): Query {
        VotingTypeRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}
