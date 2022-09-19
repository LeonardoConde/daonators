package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table user_wallet
 * @author Simpli CLI generator
 */
class UserWallet {
    @Schema(required = true) var idUserWalletPk: Long = 0

    var user: User? = null

    @Schema(required = true, maxLength = 34)
    var walletAddress: String? = null

    var id
        @Schema(hidden = true)
        get() = idUserWalletPk
        set(value) {
            idUserWalletPk = value
        }

    var idUserFk: Long?
        get() = user?.idUser
        set(value) {
            if (value == null || value == 0L) {
                user = null
                return
            }
            if (user == null) {
                user = User()
            }
            user?.idUser = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (walletAddress.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["UserWallet.walletAddress"]))
        }
        if (walletAddress?.length ?: 0 > 34) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["UserWallet.walletAddress"], 34))
        }
    }
}
