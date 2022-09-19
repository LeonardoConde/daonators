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
            walletAddress = getString("walletAddress")
            idUserFk = getLongOrNull("idUserFk")
        }
    }

    fun selectFields(alias: String = "user_wallet") = arrayOf(
            "$alias.idUserWalletPk",
            "$alias.walletAddress",
            "$alias.idUserFk"
    )

    fun fieldsToSearch(alias: String = "user_wallet") = arrayOf(
            "$alias.idUserWalletPk",
            "$alias.walletAddress"
    )

    fun orderMap(alias: String = "user_wallet") = mapOf(
            "user" to "$alias.idUserFk",
            "idUserWalletPk" to "$alias.idUserWalletPk",
            "walletAddress" to "$alias.walletAddress"
    )

    fun updateSet(userWallet: UserWallet) = mapOf(
            "walletAddress" to userWallet.walletAddress,
            "idUserFk" to userWallet.idUserFk
    )

    fun insertValues(userWallet: UserWallet) = mapOf(
            "walletAddress" to userWallet.walletAddress,
            "idUserFk" to userWallet.idUserFk
    )
}
