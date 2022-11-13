package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table voting_type
 * @author Simpli CLI generator
 */
class VotingType {
    @Schema(required = true) var idVotingTypePk: Long = 0

    @Schema(required = true, maxLength = 45)
    var name: String? = null

    @Schema(required = true) var active: Boolean? = null

    var id
        @Schema(hidden = true)
        get() = idVotingTypePk
        set(value) {
            idVotingTypePk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (name.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["VotingType.name"]))
        }
        if (name?.length ?: 0 > 45) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["VotingType.name"], 45))
        }
    }
}
