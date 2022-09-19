package org.daonators.model.param

import org.daonators.model.filter.OrganizationTypeListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated OrganizationType Param
 * @author Simpli CLI generator
 */
open class AuthOrganizationTypeListParam: DefaultParam.AuthPaged(), OrganizationTypeListFilter {
}
