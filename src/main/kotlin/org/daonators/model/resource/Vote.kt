package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table vote
 * @author Simpli CLI generator
 */
class Vote {
    @Schema(required = true) var idVotingFk: Long = 0
    @Schema(required = true) var idUserWalletFk: Long = 0

    var userWallet: UserWallet? = null
    var voting: Voting? = null

    @Schema(required = true) var tokenAmount: Double? = null

    open class RequiredPathId : DefaultParam.Auth() {
        @PathParam("id1")
        @Schema(required = true)
        var id1: Long? = null

        @PathParam("id2")
        @Schema(required = true)
        var id2: Long? = null
    }

    var id1
        @Schema(hidden = true)
        get() = idVotingFk
        set(value) {
            idVotingFk = value
        }

    var id2
        @Schema(hidden = true)
        get() = idUserWalletFk
        set(value) {
            idUserWalletFk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
    }
}
