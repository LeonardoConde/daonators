package org.daonators.model.param

import org.daonators.model.filter.DonationListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated Donation Param
 * @author Simpli CLI generator
 */
open class AuthDonationListParam: DefaultParam.AuthPaged(), DonationListFilter {
    @QueryParam("minGasAmount")
    @Schema
    override var minGasAmount: Double? = null

    @QueryParam("maxGasAmount")
    @Schema
    override var maxGasAmount: Double? = null
}
