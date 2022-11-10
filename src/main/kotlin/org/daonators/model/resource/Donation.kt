package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table donation
 * @author Simpli CLI generator
 */
class Donation {
    @Schema(required = true) var idDonationPk: Long = 0
    @Schema(required = true) var idCampaingFk: Long = 0
    @Schema(required = true) var idOrganizationFk: Long = 0

    var campaing: Campaing? = null
    var organization: Organization? = null

    @Schema(required = true, maxLength = 66)
    var transactionHash: String? = null

    @Schema(required = true) var gasAmount: Double? = null

    open class RequiredPathId : DefaultParam.Auth() {
        @PathParam("id1")
        @Schema(required = true)
        var id1: Long? = null

        //@PathParam("id2")
        //@Schema(required = true)
        //var id2: Long? = null

        //@PathParam("id3")
        //@Schema(required = true)
        //var id3: Long? = null
    }

    var id1
        @Schema(hidden = true)
        get() = idDonationPk
        set(value) {
            idDonationPk = value
        }

    var id2
        @Schema(hidden = true)
        get() = idCampaingFk
        set(value) {
            idCampaingFk = value
        }

    var id3
        @Schema(hidden = true)
        get() = idOrganizationFk
        set(value) {
            idOrganizationFk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (transactionHash.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["Donation.transactionHash"]))
        }
        if (transactionHash?.length ?: 0 > 66) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["Donation.transactionHash"], 66))
        }
    }
}
