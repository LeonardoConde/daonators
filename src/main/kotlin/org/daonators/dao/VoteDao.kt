package org.daonators.dao

import org.daonators.model.filter.VoteListFilter
import org.daonators.model.resource.Vote
import org.daonators.model.rm.VoteRM
import org.daonators.model.rm.CampaingOrganizationRM
import org.daonators.model.rm.UserWalletRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of Vote from table vote
 * @author Simpli CLI generator
 */
class VoteDao(val con: AbstractConnector) {
    fun getOne(idVotePk: Long): Vote? {
        // TODO: review generated method
        val query = Query()
                .selectVote()
                .from("vote")
                .whereEq("idVotePk", idVotePk)

        return con.getOne(query) {
            VoteRM.build(it)
        }
    }

    fun getList(filter: VoteListFilter): MutableList<Vote> {
        // TODO: review generated method
        val query = Query()
                .selectFields(VoteRM.selectFields() + CampaingOrganizationRM.selectFields() + UserWalletRM.selectFields())
                .from("vote")
                .innerJoin("campaing_organization", "campaing_organization.idCampaingFk", "vote.idCampaingFk")
                .innerJoin("user_wallet", "user_wallet.idUserWalletPk", "vote.idUserWalletFk")
                .whereVoteFilter(filter)
                .orderAndLimitVote(filter)

        return con.getList(query) {
            VoteRM.build(it).apply {
                campaingOrganization = CampaingOrganizationRM.build(it)
                userWallet = UserWalletRM.build(it)
            }
        }
    }

    fun count(filter: VoteListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idVotePk")
                .from("vote")
                .whereVoteFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(vote: Vote): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("vote")
                .updateVoteSet(vote)
                .whereEq("idVotePk", vote.id)

        return con.execute(query).affectedRows
    }

    fun insert(vote: Vote): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("vote")
                .insertVoteValues(vote)

        return con.execute(query).key
    }

    fun exist(idVotePk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idVotePk")
                .from("vote")
                .whereEq("idVotePk", idVotePk)

        return con.exist(query)
    }

    private fun Query.selectVote() = selectFields(VoteRM.selectFields())

    private fun Query.updateVoteSet(vote: Vote) = updateSet(VoteRM.updateSet(vote))

    private fun Query.insertVoteValues(vote: Vote) = insertValues(VoteRM.insertValues(vote))

    private fun Query.whereVoteFilter(filter: VoteListFilter, alias: String = "vote"): Query {
        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(VoteRM.fieldsToSearch(alias), "%$it%")
            }
        }

        filter.idCampaingFk?.also {
            if (it.isNotEmpty()) {
                whereIn("$alias.idCampaingFk", *it.toTypedArray())
            }
        }

        filter.idUserWalletFk?.also {
            if (it.isNotEmpty()) {
                whereIn("$alias.idUserWalletFk", *it.toTypedArray())
            }
        }

        filter.startLastUpdate?.also {
            where("DATE($alias.lastUpdate) >= DATE(?)", it)
        }
        filter.endLastUpdate?.also {
            where("DATE($alias.lastUpdate) <= DATE(?)", it)
        }

        filter.minIdOrganizationFk?.also {
            whereGtEq("$alias.idOrganizationFk", it)
        }
        filter.maxIdOrganizationFk?.also {
            whereLtEq("$alias.idOrganizationFk", it)
        }

        return this
    }

    private fun Query.orderAndLimitVote(filter: VoteListFilter, alias: String = "vote"): Query {
        VoteRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}
