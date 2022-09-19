package org.daonators.model.param

import org.daonators.model.filter.UserWalletListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated UserWallet Param
 * @author Simpli CLI generator
 */
open class AuthUserWalletListParam: DefaultParam.AuthPaged(), UserWalletListFilter {
    @QueryParam("idUserFk")
    @Schema
    override var idUserFk: List<Long>? = null
}
