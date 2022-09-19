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
    @Schema(required = true) var idVotePk: Long = 0

    var campaingOrganization: CampaingOrganization? = null
    var userWallet: UserWallet? = null

    @Schema(required = true) var lastUpdate: Date? = null
    @Schema(required = true) var tokensAmount: String? = null
    @Schema(required = true) var idOrganizationFk: Long? = null
    var id
        @Schema(hidden = true)
        get() = idVotePk
        set(value) {
            idVotePk = value
        }

    var idCampaingFk: Long
        @Schema(required = true)
        get() = campaingOrganization?.idCampaingFk ?: 0
        set(value) {
            if (value == 0L) {
                campaingOrganization = null
                return
            }
            if (campaingOrganization == null) {
                campaingOrganization = CampaingOrganization()
            }
            campaingOrganization?.idCampaingFk = value
        }

    var idUserWalletFk: Long
        @Schema(required = true)
        get() = userWallet?.idUserWalletPk ?: 0
        set(value) {
            if (value == 0L) {
                userWallet = null
                return
            }
            if (userWallet == null) {
                userWallet = UserWallet()
            }
            userWallet?.idUserWalletPk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (lastUpdate == null) {
            throw BadRequestException(lang.cannotBeNull(lang["Vote.lastUpdate"]))
        }
        if (tokensAmount.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["Vote.tokensAmount"]))
        }
        if (idCampaingFk == 0L) {
            throw BadRequestException(lang.cannotBeNull(lang["Vote.idCampaingFk"]))
        }
        if (idOrganizationFk == 0L) {
            throw BadRequestException(lang.cannotBeNull(lang["Vote.idOrganizationFk"]))
        }
        if (idUserWalletFk == 0L) {
            throw BadRequestException(lang.cannotBeNull(lang["Vote.idUserWalletFk"]))
        }
    }
}
