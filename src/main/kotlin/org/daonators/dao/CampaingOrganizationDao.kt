package org.daonators.dao

import org.daonators.model.filter.CampaingOrganizationListFilter
import org.daonators.model.resource.CampaingOrganization
import org.daonators.model.rm.CampaingOrganizationRM
import org.daonators.model.rm.CampaingRM
import org.daonators.model.rm.OrganizationRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of CampaingOrganization from table campaing_organization
 * @author Simpli CLI generator
 */
class CampaingOrganizationDao(val con: AbstractConnector) {
    fun getOne(idCampaingFk: Long, idOrganizationFk: Long): CampaingOrganization? {
        // TODO: review generated method
        val query = Query()
                .selectCampaingOrganization()
                .from("campaing_organization")
                .whereEq("idCampaingFk", idCampaingFk)
                .whereEq("idOrganizationFk", idOrganizationFk)

        return con.getOne(query) {
            CampaingOrganizationRM.build(it)
        }
    }

    fun getList(filter: CampaingOrganizationListFilter): MutableList<CampaingOrganization> {
        // TODO: review generated method
        val query = Query()
                .selectFields(CampaingOrganizationRM.selectFields() + CampaingRM.selectFields() + OrganizationRM.selectFields())
                .from("campaing_organization")
                .innerJoin("campaing", "campaing.idCampaingPk", "campaing_organization.idCampaingFk")
                .innerJoin("organization", "organization.idOrganizationPk", "campaing_organization.idOrganizationFk")
                .whereCampaingOrganizationFilter(filter)
                .orderAndLimitCampaingOrganization(filter)

        return con.getList(query) {
            CampaingOrganizationRM.build(it).apply {
                campaing = CampaingRM.build(it)
                organization = OrganizationRM.build(it)
            }
        }
    }

    fun count(filter: CampaingOrganizationListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idCampaingFk")
                .from("campaing_organization")
                .whereCampaingOrganizationFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(campaingOrganization: CampaingOrganization): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("campaing_organization")
                .updateCampaingOrganizationSet(campaingOrganization)
                .whereEq("idCampaingFk", campaingOrganization.id1)
                .whereEq("idOrganizationFk", campaingOrganization.id2)

        return con.execute(query).affectedRows
    }

    fun insert(campaingOrganization: CampaingOrganization): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("campaing_organization")
                .insertCampaingOrganizationValues(campaingOrganization)

        return con.execute(query).key
    }

    fun exist(idCampaingFk: Long, idOrganizationFk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idCampaingFk")
                .from("campaing_organization")
                .whereEq("idCampaingFk", idCampaingFk)
                .whereEq("idOrganizationFk", idOrganizationFk)

        return con.exist(query)
    }

    private fun Query.selectCampaingOrganization() = selectFields(CampaingOrganizationRM.selectFields())

    private fun Query.updateCampaingOrganizationSet(campaingOrganization: CampaingOrganization) = updateSet(CampaingOrganizationRM.updateSet(campaingOrganization))

    private fun Query.insertCampaingOrganizationValues(campaingOrganization: CampaingOrganization) = insertValues(CampaingOrganizationRM.insertValues(campaingOrganization))

    private fun Query.whereCampaingOrganizationFilter(filter: CampaingOrganizationListFilter, alias: String = "campaing_organization"): Query {
        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(CampaingOrganizationRM.fieldsToSearch(alias), "%$it%")
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

    private fun Query.orderAndLimitCampaingOrganization(filter: CampaingOrganizationListFilter, alias: String = "campaing_organization"): Query {
        CampaingOrganizationRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}
