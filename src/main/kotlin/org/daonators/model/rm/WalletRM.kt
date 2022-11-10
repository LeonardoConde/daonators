package org.daonators.model.rm

import org.daonators.model.resource.Wallet
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table wallet
 * @author Simpli CLI generator
 */
object WalletRM {
    fun build(rs: ResultSet, alias: String = "wallet", allowedColumns: Array<String> = selectFields(alias)) = Wallet().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idWalletPk = getLong("idWalletPk")
            wallet = getString("wallet")
        }
    }

    fun selectFields(alias: String = "wallet") = arrayOf(
            "$alias.idWalletPk",
            "$alias.wallet"
    )

    fun fieldsToSearch(alias: String = "wallet") = arrayOf(
            "$alias.idWalletPk",
            "$alias.wallet"
    )

    fun orderMap(alias: String = "wallet") = mapOf(
            "idWalletPk" to "$alias.idWalletPk",
            "wallet" to "$alias.wallet"
    )

    fun updateSet(wallet: Wallet) = mapOf(
            "wallet" to wallet.wallet
    )

    fun insertValues(wallet: Wallet) = mapOf(
            "wallet" to wallet.wallet
    )
}
