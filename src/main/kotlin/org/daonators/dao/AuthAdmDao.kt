package org.daonators.dao

import org.daonators.model.filter.AuthAdmListFilter
import org.daonators.model.resource.AuthAdm
import org.daonators.model.rm.AuthAdmRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of AuthAdm from table auth_adm
 * @author Simpli CLI generator
 */
class AuthAdmDao(val con: AbstractConnector) {
    fun getOne(idAuthAdmPk: Long): AuthAdm? {
        // TODO: review generated method
        val query = Query()
                .selectAuthAdm()
                .from("auth_adm")
                .whereEq("idAuthAdmPk", idAuthAdmPk)

        return con.getOne(query) {
            AuthAdmRM.build(it)
        }
    }

    fun getList(filter: AuthAdmListFilter): MutableList<AuthAdm> {
        // TODO: review generated method
        val query = Query()
                .selectAuthAdm()
                .from("auth_adm")
                .whereAuthAdmFilter(filter)
                .orderAndLimitAuthAdm(filter)

        return con.getList(query) {
            AuthAdmRM.build(it)
        }
    }

    fun count(filter: AuthAdmListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idAuthAdmPk")
                .from("auth_adm")
                .whereAuthAdmFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(authAdm: AuthAdm): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("auth_adm")
                .updateAuthAdmSet(authAdm)
                .whereEq("idAuthAdmPk", authAdm.id)

        return con.execute(query).affectedRows
    }

    fun insert(authAdm: AuthAdm): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("auth_adm")
                .insertAuthAdmValues(authAdm)

        return con.execute(query).key
    }

    fun exist(idAuthAdmPk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idAuthAdmPk")
                .from("auth_adm")
                .whereEq("idAuthAdmPk", idAuthAdmPk)

        return con.exist(query)
    }

    private fun Query.selectAuthAdm() = selectFields(AuthAdmRM.selectFields())

    private fun Query.updateAuthAdmSet(authAdm: AuthAdm) = updateSet(AuthAdmRM.updateSet(authAdm))

    private fun Query.insertAuthAdmValues(authAdm: AuthAdm) = insertValues(AuthAdmRM.insertValues(authAdm))

    private fun Query.whereAuthAdmFilter(filter: AuthAdmListFilter, alias: String = "auth_adm"): Query {
        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(AuthAdmRM.fieldsToSearch(alias), "%$it%")
            }
        }

        return this
    }

    private fun Query.orderAndLimitAuthAdm(filter: AuthAdmListFilter, alias: String = "auth_adm"): Query {
        AuthAdmRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}
