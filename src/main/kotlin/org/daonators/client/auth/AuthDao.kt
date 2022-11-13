package org.daonators.client.auth

import org.daonators.model.resource.AuthAdm
import org.daonators.model.rm.AuthAdmRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of Auth
 * @author Simpli CLI generator
 */
class AuthDao(val con: AbstractConnector) {
    fun getIdOfAuthAdm(email: String, password: String): Long? {
        val query = Query()
                .select("idAuthAdmPk")
                .from("auth_adm")
                .whereEq("email", email)
                .where("password = SHA2(?, 256)", password)

        return con.getFirstLong(query)
    }

    fun getAuthAdm(idAuthAdmPk: Long): AuthAdm? {
        val query = Query()
                .selectAll()
                .from("auth_adm")
                .whereEq("idAuthAdmPk", idAuthAdmPk)

        return con.getOne(query) {
            AuthAdmRM.build(it)
        }
    }

    fun getAuthAdmByEmail(email: String): AuthAdm? {
        val query = Query()
                .selectAll()
                .from("auth_adm")
                .whereEq("email", email)

        return con.getOne(query) {
            AuthAdmRM.build(it)
        }
    }

    fun updateAuthAdmPassword(email: String, password: String): Int {
        val query = Query()
                .updateTable("auth_adm")
                .updateSet(
                        "password" to Query("SHA2(?, 256)", password)
                )
                .whereEq("email", email)

        return con.execute(query).affectedRows
    }
}
