package org.daonators.model.param

import org.daonators.model.filter.AuthAdmListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated AuthAdm Param
 * @author Simpli CLI generator
 */
open class AuthAuthAdmListParam: DefaultParam.AuthPaged(), AuthAdmListFilter {
}
