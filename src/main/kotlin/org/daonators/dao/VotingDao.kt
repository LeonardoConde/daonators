package org.daonators.dao

import org.daonators.model.filter.VotingListFilter
import org.daonators.model.resource.Voting
import org.daonators.model.rm.VotingRM
import org.daonators.model.rm.CampaingRM
import org.daonators.model.rm.OrganizationRM
import org.daonators.model.rm.VotingTypeRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of Voting from table voting
 * @author Simpli CLI generator
 */
class VotingDao(val con: AbstractConnector) {
    fun getOne(idVotingPk: Long, idOrganizationfk: Long): Voting? {
        // TODO: review generated method
        val query = Query()
                .selectVoting()
                .from("voting")
                .whereEq("idVotingPk", idVotingPk)
                .whereEq("idOrganizationfk", idOrganizationfk)

        return con.getOne(query) {
            VotingRM.build(it)
        }
    }

    fun getList(filter: VotingListFilter): MutableList<Voting> {
        // TODO: review generated method
        val query = Query()
                .selectFields(VotingRM.selectFields() + CampaingRM.selectFields() + OrganizationRM.selectFields() + VotingTypeRM.selectFields())
                .from("voting")
                .leftJoin("campaing", "campaing.idCampaingPk", "voting.idCampaingFk")
                .innerJoin("organization", "organization.idOrganizationPk", "voting.idOrganizationfk")
                .innerJoin("voting_type", "voting_type.idVotingTypePk", "voting.idVotingTypeFk")
                .whereVotingFilter(filter)
                .orderAndLimitVoting(filter)

        return con.getList(query) {
            VotingRM.build(it).apply {
                campaing = CampaingRM.build(it)
                organization = OrganizationRM.build(it)
                votingType = VotingTypeRM.build(it)
            }
        }
    }

    fun count(filter: VotingListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idVotingPk")
                .from("voting")
                .whereVotingFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(voting: Voting): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("voting")
                .updateVotingSet(voting)
                .whereEq("idVotingPk", voting.id1)
                .whereEq("idOrganizationfk", voting.id2)

        return con.execute(query).affectedRows
    }

    fun insert(voting: Voting): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("voting")
                .insertVotingValues(voting)

        return con.execute(query).key
    }

    fun exist(idVotingPk: Long, idOrganizationfk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idVotingPk")
                .from("voting")
                .whereEq("idVotingPk", idVotingPk)
                .whereEq("idOrganizationfk", idOrganizationfk)

        return con.exist(query)
    }

    fun existIdCampaingFk(idCampaingFk: Long, idVotingPk: Long, idOrganizationfk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idCampaingFk")
                .from("voting")
                .whereEq("idCampaingFk", idCampaingFk)
                .whereNotEq("idVotingPk", idVotingPk)
                .whereNotEq("idOrganizationfk", idOrganizationfk)

        return con.exist(query)
    }

    private fun Query.selectVoting() = selectFields(VotingRM.selectFields())

    private fun Query.updateVotingSet(voting: Voting) = updateSet(VotingRM.updateSet(voting))

    private fun Query.insertVotingValues(voting: Voting) = insertValues(VotingRM.insertValues(voting))

    private fun Query.whereVotingFilter(filter: VotingListFilter, alias: String = "voting"): Query {
        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(VotingRM.fieldsToSearch(alias), "%$it%")
            }
        }

        filter.idCampaingFk?.also {
            if (it.isNotEmpty()) {
                whereIn("$alias.idCampaingFk", *it.toTypedArray())
            }
        }

        filter.idVotingTypeFk?.also {
            if (it.isNotEmpty()) {
                whereIn("$alias.idVotingTypeFk", *it.toTypedArray())
            }
        }

        return this
    }

    private fun Query.orderAndLimitVoting(filter: VotingListFilter, alias: String = "voting"): Query {
        VotingRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}
