package org.daonators.dao

import org.daonators.model.filter.DonationListFilter
import org.daonators.model.resource.Donation
import org.daonators.model.rm.DonationRM
import org.daonators.model.rm.CampaingRM
import org.daonators.model.rm.OrganizationRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of Donation from table donation
 * @author Simpli CLI generator
 */
class DonationDao(val con: AbstractConnector) {
    fun getOne(idDonationPk: Long): Donation? {
        // TODO: review generated method
        val query = Query()
                .selectDonation()
                .from("donation")
                .whereEq("idDonationPk", idDonationPk)

        return con.getOne(query) {
            DonationRM.build(it)
        }
    }

    fun getOne(idCampaingFk: Long, idOrganizationFk: Long): Donation? {
        // TODO: review generated method
        val query = Query()
            .selectDonation()
            .from("donation")
            .whereEq("idCampaingFk", idCampaingFk)
            .whereEq("idOrganizationFk", idOrganizationFk)

        return con.getOne(query) {
            DonationRM.build(it)
        }
    }

    fun getList(filter: DonationListFilter): MutableList<Donation> {
        // TODO: review generated method
        val query = Query()
                .selectFields(DonationRM.selectFields() + CampaingRM.selectFields() + OrganizationRM.selectFields())
                .from("donation")
                .innerJoin("campaing", "campaing.idCampaingPk", "donation.idCampaingFk")
                .innerJoin("organization", "organization.idOrganizationPk", "donation.idOrganizationFk")
                .whereDonationFilter(filter)
                .orderAndLimitDonation(filter)

        return con.getList(query) {
            DonationRM.build(it).apply {
                campaing = CampaingRM.build(it)
                organization = OrganizationRM.build(it)
            }
        }
    }

    fun count(filter: DonationListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idDonationPk")
                .from("donation")
                .whereDonationFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(donation: Donation): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("donation")
                .updateDonationSet(donation)
                .whereEq("idDonationPk", donation.id1)
                .whereEq("idCampaingFk", donation.id2)
                .whereEq("idOrganizationFk", donation.id3)

        return con.execute(query).affectedRows
    }

    fun insert(donation: Donation): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("donation")
                .insertDonationValues(donation)

        return con.execute(query).key
    }

    fun exist(idDonationPk: Long, idCampaingFk: Long, idOrganizationFk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idDonationPk")
                .from("donation")
                .whereEq("idDonationPk", idDonationPk)
                .whereEq("idCampaingFk", idCampaingFk)
                .whereEq("idOrganizationFk", idOrganizationFk)

        return con.exist(query)
    }

    private fun Query.selectDonation() = selectFields(DonationRM.selectFields())

    private fun Query.updateDonationSet(donation: Donation) = updateSet(DonationRM.updateSet(donation))

    private fun Query.insertDonationValues(donation: Donation) = insertValues(DonationRM.insertValues(donation))

    private fun Query.whereDonationFilter(filter: DonationListFilter, alias: String = "donation"): Query {
        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(DonationRM.fieldsToSearch(alias), "%$it%")
            }
        }

        filter.minGasAmount?.also {
            whereGtEq("$alias.gasAmount", it)
        }
        filter.maxGasAmount?.also {
            whereLtEq("$alias.gasAmount", it)
        }

        return this
    }

    private fun Query.orderAndLimitDonation(filter: DonationListFilter, alias: String = "donation"): Query {
        DonationRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}
