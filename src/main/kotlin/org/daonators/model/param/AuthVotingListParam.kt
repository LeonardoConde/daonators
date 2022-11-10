package org.daonators.model.param

import org.daonators.model.filter.VotingListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated Voting Param
 * @author Simpli CLI generator
 */
open class AuthVotingListParam: DefaultParam.AuthPaged(), VotingListFilter {
    @QueryParam("idCampaingFk")
    @Schema
    override var idCampaingFk: List<Long>? = null

    @QueryParam("idVotingTypeFk")
    @Schema
    override var idVotingTypeFk: List<Long>? = null
}
