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

    var campaingType: CampaingType? = null

    @Schema(required = true) var beginDate: Date? = null

    var endDate: Date? = null

    var id
        @Schema(hidden = true)
        get() = idCampaingPk
        set(value) {
            idCampaingPk = value
        }

    var idCampaingTypePk: Long
        @Schema(required = true)
        get() = campaingType?.idCampaingTypePk ?: 0
        set(value) {
            if (value == 0L) {
                campaingType = null
                return
            }
            if (campaingType == null) {
                campaingType = CampaingType()
            }
            campaingType?.idCampaingTypePk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (idCampaingTypePk == 0L) {
            throw BadRequestException(lang.cannotBeNull(lang["Campaing.idCampaingTypePk"]))
        }
        if (beginDate == null) {
            throw BadRequestException(lang.cannotBeNull(lang["Campaing.beginDate"]))
        }
    }
}
