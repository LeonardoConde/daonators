package org.daonators.model.param

import org.daonators.model.filter.UserListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated User Param
 * @author Simpli CLI generator
 */
open class AuthUserListParam: DefaultParam.AuthPaged(), UserListFilter {
}
