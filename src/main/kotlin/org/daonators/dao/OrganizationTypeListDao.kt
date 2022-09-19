package org.daonators.dao

import org.daonators.model.resource.Organization
import org.daonators.model.rm.OrganizationRM
import org.daonators.model.resource.OrganizationType
import org.daonators.model.rm.OrganizationTypeRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of OrganizationTypeList from table organization_type_list
 * @author Simpli CLI generator
 */
class OrganizationTypeListDao(val con: AbstractConnector) {

    fun insert(idOrganizationFk: Long, idOrganizationTypeFk: Long): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("organization_type_list")
                .insertValues(
                        "idOrganizationFk" to idOrganizationFk,
                        "idOrganizationTypeFk" to idOrganizationTypeFk
                )

        return con.execute(query).key
    }

    fun removeAllFromOrganizationType(idOrganizationTypeFk: Long): Int {
        // TODO: review generated method
        val query = Query()
                .deleteFrom("organization_type_list")
                .whereEq("idOrganizationTypeFk", idOrganizationTypeFk)

        return con.execute(query).affectedRows
    }

    fun listOrganizationTypeOfOrganization(idOrganizationFk: Long): MutableList<OrganizationType> {
        // TODO: review generated method
        val query = Query()
                .selectFields(OrganizationTypeRM.selectFields())
                .from("organization_type")
                .innerJoin("organization_type_list", "organization_type.idOrganizationTypePk", "organization_type_list.idOrganizationTypeFk")
                .whereEq("organization_type_list.idOrganizationFk", idOrganizationFk)

        return con.getList(query) {
            OrganizationTypeRM.build(it)
        }
    }

    fun removeAllFromOrganization(idOrganizationFk: Long): Int {
        // TODO: review generated method
        val query = Query()
                .deleteFrom("organization_type_list")
                .whereEq("idOrganizationFk", idOrganizationFk)

        return con.execute(query).affectedRows
    }

    fun listOrganizationOfOrganizationType(idOrganizationTypeFk: Long): MutableList<Organization> {
        // TODO: review generated method
        val query = Query()
                .selectFields(OrganizationRM.selectFields())
                .from("organization")
                .innerJoin("organization_type_list", "organization.idOrganizationPk", "organization_type_list.idOrganizationFk")
                .whereEq("organization_type_list.idOrganizationTypeFk", idOrganizationTypeFk)

        return con.getList(query) {
            OrganizationRM.build(it)
        }
    }

}
