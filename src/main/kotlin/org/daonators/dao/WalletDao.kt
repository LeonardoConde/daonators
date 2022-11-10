package org.daonators.dao

import org.daonators.model.filter.WalletListFilter
import org.daonators.model.resource.Wallet
import org.daonators.model.rm.WalletRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of Wallet from table wallet
 * @author Simpli CLI generator
 */
class WalletDao(val con: AbstractConnector) {
    fun getOne(idWalletPk: Long): Wallet? {
        // TODO: review generated method
        val query = Query()
                .selectWallet()
                .from("wallet")
                .whereEq("idWalletPk", idWalletPk)

        return con.getOne(query) {
            WalletRM.build(it)
        }
    }

    fun getList(filter: WalletListFilter): MutableList<Wallet> {
        // TODO: review generated method
        val query = Query()
                .selectWallet()
                .from("wallet")
                .whereWalletFilter(filter)
                .orderAndLimitWallet(filter)

        return con.getList(query) {
            WalletRM.build(it)
        }
    }

    fun count(filter: WalletListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idWalletPk")
                .from("wallet")
                .whereWalletFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(wallet: Wallet): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("wallet")
                .updateWalletSet(wallet)
                .whereEq("idWalletPk", wallet.id)

        return con.execute(query).affectedRows
    }

    fun insert(wallet: Wallet): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("wallet")
                .insertWalletValues(wallet)

        return con.execute(query).key
    }

    fun exist(idWalletPk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idWalletPk")
                .from("wallet")
                .whereEq("idWalletPk", idWalletPk)

        return con.exist(query)
    }

    private fun Query.selectWallet() = selectFields(WalletRM.selectFields())

    private fun Query.updateWalletSet(wallet: Wallet) = updateSet(WalletRM.updateSet(wallet))

    private fun Query.insertWalletValues(wallet: Wallet) = insertValues(WalletRM.insertValues(wallet))

    private fun Query.whereWalletFilter(filter: WalletListFilter, alias: String = "wallet"): Query {
        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(WalletRM.fieldsToSearch(alias), "%$it%")
            }
        }

        return this
    }

    private fun Query.orderAndLimitWallet(filter: WalletListFilter, alias: String = "wallet"): Query {
        WalletRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}
