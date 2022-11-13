package org.daonators.model.rm

import org.daonators.model.resource.AuthAdm
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table auth_adm
 * @author Simpli CLI generator
 */
object AuthAdmRM {
    fun build(rs: ResultSet, alias: String = "auth_adm", allowedColumns: Array<String> = selectFields(alias)) = AuthAdm().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idAuthAdmPk = getLong("idAuthAdmPk")
            name = getString("name")
            email = getString("email")
            password = getString("password")
        }
    }

    fun selectFields(alias: String = "auth_adm") = arrayOf(
            "$alias.idAuthAdmPk",
            "$alias.name",
            "$alias.email"
    )

    fun fieldsToSearch(alias: String = "auth_adm") = arrayOf(
            "$alias.idAuthAdmPk",
            "$alias.name",
            "$alias.email"
    )

    fun orderMap(alias: String = "auth_adm") = mapOf(
            "idAuthAdmPk" to "$alias.idAuthAdmPk",
            "name" to "$alias.name",
            "email" to "$alias.email"
    )

    fun updateSet(authAdm: AuthAdm) = mapOf(
            "name" to authAdm.name,
            "email" to authAdm.email,
            "password" to Query("IF(? IS NOT NULL, SHA2(?, 256), password)", authAdm.password, authAdm.password)
    )

    fun insertValues(authAdm: AuthAdm) = mapOf(
            "name" to authAdm.name,
            "email" to authAdm.email,
            "password" to Query("SHA2(?, 256)", authAdm.password)
    )
}
