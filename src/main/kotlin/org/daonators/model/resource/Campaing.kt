package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table campaing
 * @author Simpli CLI generator
 */
class Campaing {
    @Schema(required = true) var idCampaingPk: Long = 0

    var campaingOrganization: MutableList<Organization>? = null

    @Schema(required = true, maxLength = 255)
    var socialCause: String? = null

    @Schema(required = true) var beginDate: Date? = null
    @Schema(required = true) var endDate: Date? = null

    @Schema(maxLength = 45) var name: String? = null

    var id
        @Schema(hidden = true)
        get() = idCampaingPk
        set(value) {
            idCampaingPk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (name?.length ?: 0 > 45) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["Campaing.name"], 45))
        }
        if (socialCause.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["Campaing.socialCause"]))
        }
        if (socialCause?.length ?: 0 > 255) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["Campaing.socialCause"], 255))
        }
        if (beginDate == null) {
            throw BadRequestException(lang.cannotBeNull(lang["Campaing.beginDate"]))
        }
        if (endDate == null) {
            throw BadRequestException(lang.cannotBeNull(lang["Campaing.endDate"]))
        }
    }
}
