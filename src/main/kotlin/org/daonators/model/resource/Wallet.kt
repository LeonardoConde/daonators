package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table wallet
 * @author Simpli CLI generator
 */
class Wallet {
    @Schema(required = true) var idWalletPk: Long = 0

    @Schema(maxLength = 45) var wallet: String? = null

    var id
        @Schema(hidden = true)
        get() = idWalletPk
        set(value) {
            idWalletPk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (wallet?.length ?: 0 > 45) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["Wallet.wallet"], 45))
        }
    }
}
