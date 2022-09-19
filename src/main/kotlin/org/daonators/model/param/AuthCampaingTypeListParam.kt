package org.daonators.model.param

import org.daonators.model.filter.CampaingTypeListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated CampaingType Param
 * @author Simpli CLI generator
 */
open class AuthCampaingTypeListParam: DefaultParam.AuthPaged(), CampaingTypeListFilter {
}
