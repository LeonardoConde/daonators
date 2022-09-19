package org.daonators.model.param

import org.daonators.model.filter.CampaingListFilter
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.QueryParam

/**
 * Authenticated Campaing Param
 * @author Simpli CLI generator
 */
open class AuthCampaingListParam: DefaultParam.AuthPaged(), CampaingListFilter {
    @QueryParam("idCampaingTypePk")
    @Schema
    override var idCampaingTypePk: List<Long>? = null

    @QueryParam("startBeginDate")
    @Schema
    override var startBeginDate: Date? = null

    @QueryParam("endBeginDate")
    @Schema
    override var endBeginDate: Date? = null

    @QueryParam("startEndDate")
    @Schema
    override var startEndDate: Date? = null

    @QueryParam("endEndDate")
    @Schema
    override var endEndDate: Date? = null
}
