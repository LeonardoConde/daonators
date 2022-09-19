package org.daonators.model.filter

import java.util.Date

/**
 * CampaingOrganization List Filter
 * @author Simpli CLI generator
 */
interface CampaingOrganizationListFilter : ListFilter {
    var minGasAmount: Double?
    var maxGasAmount: Double?
}
