package org.daonators.model.rm

import org.daonators.model.resource.User
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table user
 * @author Simpli CLI generator
 */
object UserRM {
    fun build(rs: ResultSet, alias: String = "user", allowedColumns: Array<String> = selectFields(alias)) = User().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idUser = getLong("idUser")
            name = getString("name")
            email = getString("email")
            password = getString("password")
        }
    }

    fun selectFields(alias: String = "user") = arrayOf(
            "$alias.idUser",
            "$alias.name",
            "$alias.email"
    )

    fun fieldsToSearch(alias: String = "user") = arrayOf(
            "$alias.idUser",
            "$alias.name",
            "$alias.email"
    )

    fun orderMap(alias: String = "user") = mapOf(
            "idUser" to "$alias.idUser",
            "name" to "$alias.name",
            "email" to "$alias.email"
    )

    fun updateSet(user: User) = mapOf(
            "name" to user.name,
            "email" to user.email,
            "password" to Query("IF(? IS NOT NULL, SHA2(?, 256), password)", user.password, user.password)
    )

    fun insertValues(user: User) = mapOf(
            "name" to user.name,
            "email" to user.email,
            "password" to Query("SHA2(?, 256)", user.password)
    )
}
