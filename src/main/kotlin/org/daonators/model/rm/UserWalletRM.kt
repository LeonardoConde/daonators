package org.daonators.model.rm

import org.daonators.model.resource.UserWallet
import br.com.simpli.sql.Query
import br.com.simpli.sql.ResultBuilder
import java.sql.ResultSet

/**
 * Relational Mapping of Principal from table user_wallet
 * @author Simpli CLI generator
 */
object UserWalletRM {
    fun build(rs: ResultSet, alias: String = "user_wallet", allowedColumns: Array<String> = selectFields(alias)) = UserWallet().apply {
        ResultBuilder(allowedColumns, rs, alias).run {
            idUserWalletPk = getLong("idUserWalletPk")
            walletAdress = getString("walletAdress")
        }
    }

    fun selectFields(alias: String = "user_wallet") = arrayOf(
            "$alias.idUserWalletPk",
            "$alias.walletAdress"
    )

    fun fieldsToSearch(alias: String = "user_wallet") = arrayOf(
            "$alias.idUserWalletPk",
            "$alias.walletAdress"
    )

    fun orderMap(alias: String = "user_wallet") = mapOf(
            "idUserWalletPk" to "$alias.idUserWalletPk",
            "walletAdress" to "$alias.walletAdress"
    )

    fun updateSet(userWallet: UserWallet) = mapOf(
            "walletAdress" to userWallet.walletAdress
    )

    fun insertValues(userWallet: UserWallet) = mapOf(
            "walletAdress" to userWallet.walletAdress
    )
}
