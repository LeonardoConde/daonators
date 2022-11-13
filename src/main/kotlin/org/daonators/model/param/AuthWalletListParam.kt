package org.daonators.model.param

import org.daonators.model.filter.WalletListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated Wallet Param
 * @author Simpli CLI generator
 */
open class AuthWalletListParam: DefaultParam.AuthPaged(), WalletListFilter {
}
