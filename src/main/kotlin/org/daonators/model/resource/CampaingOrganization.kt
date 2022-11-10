package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table campaing_organization
 * @author Simpli CLI generator
 */
class CampaingOrganization {
    @Schema(required = true) var idCampaingFk: Long = 0
    @Schema(required = true) var idOrganizationFk: Long = 0

    var campaing: Campaing? = null
    var organization: Organization? = null
    var organizations: List<Organization>? = null

    @Schema(maxLength = 66) var transactionHash: String? = null

    var gasAmount: Double? = null

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
        get() = idCampaingFk
        set(value) {
            idCampaingFk = value
        }

    var id2
        @Schema(hidden = true)
        get() = idOrganizationFk
        set(value) {
            idOrganizationFk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (transactionHash?.length ?: 0 > 66) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["CampaingOrganization.transactionHash"], 66))
        }
    }
}
