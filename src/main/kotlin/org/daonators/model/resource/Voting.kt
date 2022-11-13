package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table voting
 * @author Simpli CLI generator
 */
class Voting {
    @Schema(required = true) var idVotingPk: Long = 0
    @Schema(required = true) var idOrganizationfk: Long = 0

    var campaing: Campaing? = null
    var organization: Organization? = null
    var votingType: VotingType? = null

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
        get() = idVotingPk
        set(value) {
            idVotingPk = value
        }

    var id2
        @Schema(hidden = true)
        get() = idOrganizationfk
        set(value) {
            idOrganizationfk = value
        }

    var idCampaingFk: Long?
        get() = campaing?.idCampaingPk
        set(value) {
            if (value == null || value == 0L) {
                campaing = null
                return
            }
            if (campaing == null) {
                campaing = Campaing()
            }
            campaing?.idCampaingPk = value
        }

    var idVotingTypeFk: Long
        @Schema(required = true)
        get() = votingType?.idVotingTypePk ?: 0
        set(value) {
            if (value == 0L) {
                votingType = null
                return
            }
            if (votingType == null) {
                votingType = VotingType()
            }
            votingType?.idVotingTypePk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (idVotingTypeFk == 0L) {
            throw BadRequestException(lang.cannotBeNull(lang["Voting.idVotingTypeFk"]))
        }
    }
}
