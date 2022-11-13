package org.daonators.dao

import org.daonators.model.filter.VoteListFilter
import org.daonators.model.resource.Vote
import org.daonators.model.rm.VoteRM
import org.daonators.model.rm.UserWalletRM
import org.daonators.model.rm.VotingRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of Vote from table vote
 * @author Simpli CLI generator
 */
class VoteDao(val con: AbstractConnector) {
    fun getOne(idVotingFk: Long, idUserWalletFk: Long): Vote? {
        // TODO: review generated method
        val query = Query()
                .selectVote()
                .from("vote")
                .whereEq("idVotingFk", idVotingFk)
                .whereEq("idUserWalletFk", idUserWalletFk)

        return con.getOne(query) {
            VoteRM.build(it)
        }
    }

    fun getList(filter: VoteListFilter): MutableList<Vote> {
        // TODO: review generated method
        val query = Query()
                .selectFields(VoteRM.selectFields() + UserWalletRM.selectFields() + VotingRM.selectFields())
                .from("vote")
                .innerJoin("user_wallet", "user_wallet.idUserWalletPk", "vote.idUserWalletFk")
                .innerJoin("voting", "voting.idVotingPk", "vote.idVotingFk")
                .whereVoteFilter(filter)
                .orderAndLimitVote(filter)

        return con.getList(query) {
            VoteRM.build(it).apply {
                userWallet = UserWalletRM.build(it)
                voting = VotingRM.build(it)
            }
        }
    }

    fun count(filter: VoteListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idVotingFk")
                .from("vote")
                .whereVoteFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(vote: Vote): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("vote")
                .updateVoteSet(vote)
                .whereEq("idVotingFk", vote.id1)
                .whereEq("idUserWalletFk", vote.id2)

        return con.execute(query).affectedRows
    }

    fun insert(vote: Vote): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("vote")
                .insertVoteValues(vote)

        return con.execute(query).key
    }

    fun exist(idVotingFk: Long, idUserWalletFk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idVotingFk")
                .from("vote")
                .whereEq("idVotingFk", idVotingFk)
                .whereEq("idUserWalletFk", idUserWalletFk)

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

        filter.minTokenAmount?.also {
            whereGtEq("$alias.tokenAmount", it)
        }
        filter.maxTokenAmount?.also {
            whereLtEq("$alias.tokenAmount", it)
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
