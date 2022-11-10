package org.daonators.model.param

import org.daonators.model.filter.VotingTypeListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated VotingType Param
 * @author Simpli CLI generator
 */
open class AuthVotingTypeListParam: DefaultParam.AuthPaged(), VotingTypeListFilter {
}
