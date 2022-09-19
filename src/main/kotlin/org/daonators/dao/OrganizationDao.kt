package org.daonators.dao

import org.daonators.model.filter.OrganizationListFilter
import org.daonators.model.resource.Organization
import org.daonators.model.rm.OrganizationRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of Organization from table organization
 * @author Simpli CLI generator
 */
class OrganizationDao(val con: AbstractConnector) {
    fun getOne(idOrganizationPk: Long): Organization? {
        // TODO: review generated method
        val query = Query()
                .selectOrganization()
                .from("organization")
                .whereEq("idOrganizationPk", idOrganizationPk)

        return con.getOne(query) {
            OrganizationRM.build(it)
        }
    }

    fun getList(filter: OrganizationListFilter): MutableList<Organization> {
        // TODO: review generated method
        val query = Query()
                .selectOrganization()
                .from("organization")
                .whereOrganizationFilter(filter)
                .orderAndLimitOrganization(filter)

        return con.getList(query) {
            OrganizationRM.build(it)
        }
    }

    fun count(filter: OrganizationListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idOrganizationPk")
                .from("organization")
                .whereOrganizationFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(organization: Organization): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("organization")
                .updateOrganizationSet(organization)
                .whereEq("idOrganizationPk", organization.id)

        return con.execute(query).affectedRows
    }

    fun insert(organization: Organization): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("organization")
                .insertOrganizationValues(organization)

        return con.execute(query).key
    }

    fun exist(idOrganizationPk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idOrganizationPk")
                .from("organization")
                .whereEq("idOrganizationPk", idOrganizationPk)

        return con.exist(query)
    }

    fun softDelete(idOrganizationPk: Long): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("organization")
                .updateSet("active" to false)
                .whereEq("idOrganizationPk", idOrganizationPk)

        return con.execute(query).affectedRows
    }

    private fun Query.selectOrganization() = selectFields(OrganizationRM.selectFields())

    private fun Query.updateOrganizationSet(organization: Organization) = updateSet(OrganizationRM.updateSet(organization))

    private fun Query.insertOrganizationValues(organization: Organization) = insertValues(OrganizationRM.insertValues(organization))

    private fun Query.whereOrganizationFilter(filter: OrganizationListFilter, alias: String = "organization"): Query {
        whereEq("$alias.active", true)

        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(OrganizationRM.fieldsToSearch(alias), "%$it%")
            }
        }

        return this
    }

    private fun Query.orderAndLimitOrganization(filter: OrganizationListFilter, alias: String = "organization"): Query {
        OrganizationRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}
