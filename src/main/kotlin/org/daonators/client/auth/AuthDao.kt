package org.daonators.client.auth

import org.daonators.model.resource.User
import org.daonators.model.rm.UserRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of Auth
 * @author Simpli CLI generator
 */
class AuthDao(val con: AbstractConnector) {
    fun getIdOfUser(email: String, password: String): Long? {
        val query = Query()
                .select("idUser")
                .from("user")
                .whereEq("email", email)
                .where("password = SHA2(?, 256)", password)

        return con.getFirstLong(query)
    }

    fun getUser(idUser: Long): User? {
        val query = Query()
                .selectAll()
                .from("user")
                .whereEq("idUser", idUser)

        return con.getOne(query) {
            UserRM.build(it)
        }
    }

    fun getUserByEmail(email: String): User? {
        val query = Query()
                .selectAll()
                .from("user")
                .whereEq("email", email)

        return con.getOne(query) {
            UserRM.build(it)
        }
    }

    fun updateUserPassword(email: String, password: String): Int {
        val query = Query()
                .updateTable("user")
                .updateSet(
                        "password" to Query("SHA2(?, 256)", password)
                )
                .whereEq("email", email)

        return con.execute(query).affectedRows
    }
}
