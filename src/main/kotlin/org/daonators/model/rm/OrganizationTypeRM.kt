package org.daonators.model.rm

import org.daonators.model.resource.OrganizationType
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table organization_type
 * @author Simpli CLI generator
 */
object OrganizationTypeRM {
    fun build(rs: ResultSet, alias: String = "organization_type", allowedColumns: Array<String> = selectFields(alias)) = OrganizationType().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idOrganizationTypePk = getLong("idOrganizationTypePk")
            name = getString("name")
            active = getBoolean("active")
        }
    }

    fun selectFields(alias: String = "organization_type") = arrayOf(
            "$alias.idOrganizationTypePk",
            "$alias.name",
            "$alias.active"
    )

    fun fieldsToSearch(alias: String = "organization_type") = arrayOf(
            "$alias.idOrganizationTypePk",
            "$alias.name"
    )

    fun orderMap(alias: String = "organization_type") = mapOf(
            "idOrganizationTypePk" to "$alias.idOrganizationTypePk",
            "name" to "$alias.name",
            "active" to "$alias.active"
    )

    fun updateSet(organizationType: OrganizationType) = mapOf(
            "name" to organizationType.name,
            "active" to organizationType.active
    )

    fun insertValues(organizationType: OrganizationType) = mapOf(
            "name" to organizationType.name,
            "active" to organizationType.active
    )
}
