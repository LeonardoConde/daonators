package org.daonators.dao

import org.daonators.model.filter.OrganizationTypeListFilter
import org.daonators.model.resource.OrganizationType
import org.daonators.model.rm.OrganizationTypeRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of OrganizationType from table organization_type
 * @author Simpli CLI generator
 */
class OrganizationTypeDao(val con: AbstractConnector) {
    fun getOne(idOrganizationTypePk: Long): OrganizationType? {
        // TODO: review generated method
        val query = Query()
                .selectOrganizationType()
                .from("organization_type")
                .whereEq("idOrganizationTypePk", idOrganizationTypePk)

        return con.getOne(query) {
            OrganizationTypeRM.build(it)
        }
    }

    fun getList(filter: OrganizationTypeListFilter): MutableList<OrganizationType> {
        // TODO: review generated method
        val query = Query()
                .selectOrganizationType()
                .from("organization_type")
                .whereOrganizationTypeFilter(filter)
                .orderAndLimitOrganizationType(filter)

        return con.getList(query) {
            OrganizationTypeRM.build(it)
        }
    }

    fun count(filter: OrganizationTypeListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idOrganizationTypePk")
                .from("organization_type")
                .whereOrganizationTypeFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(organizationType: OrganizationType): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("organization_type")
                .updateOrganizationTypeSet(organizationType)
                .whereEq("idOrganizationTypePk", organizationType.id)

        return con.execute(query).affectedRows
    }

    fun insert(organizationType: OrganizationType): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("organization_type")
                .insertOrganizationTypeValues(organizationType)

        return con.execute(query).key
    }

    fun exist(idOrganizationTypePk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idOrganizationTypePk")
                .from("organization_type")
                .whereEq("idOrganizationTypePk", idOrganizationTypePk)

        return con.exist(query)
    }

    fun softDelete(idOrganizationTypePk: Long): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("organization_type")
                .updateSet("active" to false)
                .whereEq("idOrganizationTypePk", idOrganizationTypePk)

        return con.execute(query).affectedRows
    }

    private fun Query.selectOrganizationType() = selectFields(OrganizationTypeRM.selectFields())

    private fun Query.updateOrganizationTypeSet(organizationType: OrganizationType) = updateSet(OrganizationTypeRM.updateSet(organizationType))

    private fun Query.insertOrganizationTypeValues(organizationType: OrganizationType) = insertValues(OrganizationTypeRM.insertValues(organizationType))

    private fun Query.whereOrganizationTypeFilter(filter: OrganizationTypeListFilter, alias: String = "organization_type"): Query {
        whereEq("$alias.active", true)

        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(OrganizationTypeRM.fieldsToSearch(alias), "%$it%")
            }
        }

        return this
    }

    private fun Query.orderAndLimitOrganizationType(filter: OrganizationTypeListFilter, alias: String = "organization_type"): Query {
        OrganizationTypeRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}
