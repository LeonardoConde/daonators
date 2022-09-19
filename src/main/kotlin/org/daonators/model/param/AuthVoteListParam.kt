package org.daonators.model.param

import org.daonators.model.filter.VoteListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated Vote Param
 * @author Simpli CLI generator
 */
open class AuthVoteListParam: DefaultParam.AuthPaged(), VoteListFilter {
    @QueryParam("idCampaingFk")
    @Schema
    override var idCampaingFk: List<Long>? = null

    @QueryParam("idUserWalletFk")
    @Schema
    override var idUserWalletFk: List<Long>? = null

    @QueryParam("startLastUpdate")
    @Schema
    override var startLastUpdate: Date? = null

    @QueryParam("endLastUpdate")
    @Schema
    override var endLastUpdate: Date? = null

    @QueryParam("minIdOrganizationFk")
    @Schema
    override var minIdOrganizationFk: Long? = null

    @QueryParam("maxIdOrganizationFk")
    @Schema
    override var maxIdOrganizationFk: Long? = null
}
