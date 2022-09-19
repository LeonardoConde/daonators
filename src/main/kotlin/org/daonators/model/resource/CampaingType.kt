package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table campaing_type
 * @author Simpli CLI generator
 */
class CampaingType {
    @Schema(required = true) var idCampaingTypePk: Long = 0

    @Schema(required = true) var active: Boolean? = null

    @Schema(maxLength = 45) var name: String? = null

    var id
        @Schema(hidden = true)
        get() = idCampaingTypePk
        set(value) {
            idCampaingTypePk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (name?.length ?: 0 > 45) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["CampaingType.name"], 45))
        }
    }
}
