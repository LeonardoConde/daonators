package org.daonators.model.param

import org.daonators.model.filter.CampaingOrganizationListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated CampaingOrganization Param
 * @author Simpli CLI generator
 */
open class AuthCampaingOrganizationListParam: DefaultParam.AuthPaged(), CampaingOrganizationListFilter {
    @QueryParam("minGasAmount")
    @Schema
    override var minGasAmount: Double? = null

    @QueryParam("maxGasAmount")
    @Schema
    override var maxGasAmount: Double? = null
}
