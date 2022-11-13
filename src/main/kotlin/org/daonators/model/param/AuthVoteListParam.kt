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
    @QueryParam("minTokenAmount")
    @Schema
    override var minTokenAmount: Double? = null

    @QueryParam("maxTokenAmount")
    @Schema
    override var maxTokenAmount: Double? = null
}
