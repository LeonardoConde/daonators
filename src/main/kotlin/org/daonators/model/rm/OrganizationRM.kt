package org.daonators.model.rm

import org.daonators.model.resource.Organization
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table organization
 * @author Simpli CLI generator
 */
object OrganizationRM {
    fun build(rs: ResultSet, alias: String = "organization", allowedColumns: Array<String> = selectFields(alias)) = Organization().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idOrganizationPk = getLong("idOrganizationPk")
            name = getString("name")
            scriptHash = getString("scriptHash")
            active = getBoolean("active")
        }
    }

    fun selectFields(alias: String = "organization") = arrayOf(
            "$alias.idOrganizationPk",
            "$alias.name",
            "$alias.scriptHash",
            "$alias.active"
    )

    fun fieldsToSearch(alias: String = "organization") = arrayOf(
            "$alias.idOrganizationPk",
            "$alias.name",
            "$alias.scriptHash"
    )

    fun orderMap(alias: String = "organization") = mapOf(
            "idOrganizationPk" to "$alias.idOrganizationPk",
            "name" to "$alias.name",
            "scriptHash" to "$alias.scriptHash",
            "active" to "$alias.active"
    )

    fun updateSet(organization: Organization) = mapOf(
            "name" to organization.name,
            "scriptHash" to organization.scriptHash,
            "active" to organization.active
    )

    fun insertValues(organization: Organization) = mapOf(
            "name" to organization.name,
            "scriptHash" to organization.scriptHash,
            "active" to organization.active
    )
}
