package org.daonators.dao

import org.daonators.model.filter.UserWalletListFilter
import org.daonators.model.resource.UserWallet
import org.daonators.model.rm.UserWalletRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of UserWallet from table user_wallet
 * @author Simpli CLI generator
 */
class UserWalletDao(val con: AbstractConnector) {
    fun getOne(idUserWalletPk: Long): UserWallet? {
        // TODO: review generated method
        val query = Query()
                .selectUserWallet()
                .from("user_wallet")
                .whereEq("idUserWalletPk", idUserWalletPk)

        return con.getOne(query) {
            UserWalletRM.build(it)
        }
    }

    fun getList(filter: UserWalletListFilter): MutableList<UserWallet> {
        // TODO: review generated method
        val query = Query()
                .selectUserWallet()
                .from("user_wallet")
                .whereUserWalletFilter(filter)
                .orderAndLimitUserWallet(filter)

        return con.getList(query) {
            UserWalletRM.build(it)
        }
    }

    fun count(filter: UserWalletListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idUserWalletPk")
                .from("user_wallet")
                .whereUserWalletFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(userWallet: UserWallet): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("user_wallet")
                .updateUserWalletSet(userWallet)
                .whereEq("idUserWalletPk", userWallet.id)

        return con.execute(query).affectedRows
    }

    fun insert(userWallet: UserWallet): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("user_wallet")
                .insertUserWalletValues(userWallet)

        return con.execute(query).key
    }

    fun exist(idUserWalletPk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idUserWalletPk")
                .from("user_wallet")
                .whereEq("idUserWalletPk", idUserWalletPk)

        return con.exist(query)
    }

    private fun Query.selectUserWallet() = selectFields(UserWalletRM.selectFields())

    private fun Query.updateUserWalletSet(userWallet: UserWallet) = updateSet(UserWalletRM.updateSet(userWallet))

    private fun Query.insertUserWalletValues(userWallet: UserWallet) = insertValues(UserWalletRM.insertValues(userWallet))

    private fun Query.whereUserWalletFilter(filter: UserWalletListFilter, alias: String = "user_wallet"): Query {
        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(UserWalletRM.fieldsToSearch(alias), "%$it%")
            }
        }

        return this
    }

    private fun Query.orderAndLimitUserWallet(filter: UserWalletListFilter, alias: String = "user_wallet"): Query {
        UserWalletRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}
