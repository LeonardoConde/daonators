package org.daonators.model.param

import org.daonators.model.filter.OrganizationListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated Organization Param
 * @author Simpli CLI generator
 */
open class AuthOrganizationListParam: DefaultParam.AuthPaged(), OrganizationListFilter {
}
