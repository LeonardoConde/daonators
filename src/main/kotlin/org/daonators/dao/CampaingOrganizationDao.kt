package org.daonators.dao

import org.daonators.model.resource.Organization
import org.daonators.model.rm.OrganizationRM
import org.daonators.model.resource.Campaing
import org.daonators.model.rm.CampaingRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of CampaingOrganization from table campaing_organization
 * @author Simpli CLI generator
 */
class CampaingOrganizationDao(val con: AbstractConnector) {

    fun insert(idOrganizationPk: Long, idCampaingPk: Long): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("campaing_organization")
                .insertValues(
                        "idOrganizationPk" to idOrganizationPk,
                        "idCampaingPk" to idCampaingPk
                )

        return con.execute(query).key
    }

    fun removeAllFromCampaing(idCampaingPk: Long): Int {
        // TODO: review generated method
        val query = Query()
                .deleteFrom("campaing_organization")
                .whereEq("idCampaingPk", idCampaingPk)

        return con.execute(query).affectedRows
    }

    fun listCampaingOfOrganization(idOrganizationPk: Long): MutableList<Campaing> {
        // TODO: review generated method
        val query = Query()
                .selectFields(CampaingRM.selectFields())
                .from("campaing")
                .innerJoin("campaing_organization", "campaing.idCampaingPk", "campaing_organization.idCampaingPk")
                .whereEq("campaing_organization.idOrganizationPk", idOrganizationPk)

        return con.getList(query) {
            CampaingRM.build(it)
        }
    }

    fun removeAllFromOrganization(idOrganizationPk: Long): Int {
        // TODO: review generated method
        val query = Query()
                .deleteFrom("campaing_organization")
                .whereEq("idOrganizationPk", idOrganizationPk)

        return con.execute(query).affectedRows
    }

    fun listOrganizationOfCampaing(idCampaingPk: Long): MutableList<Organization> {
        // TODO: review generated method
        val query = Query()
                .selectFields(OrganizationRM.selectFields())
                .from("organization")
                .innerJoin("campaing_organization", "organization.idOrganizationPk", "campaing_organization.idOrganizationPk")
                .whereEq("campaing_organization.idCampaingPk", idCampaingPk)

        return con.getList(query) {
            OrganizationRM.build(it)
        }
    }

}
