package org.daonators.model.filter

import java.util.Date

/**
 * Donation List Filter
 * @author Simpli CLI generator
 */
interface DonationListFilter : ListFilter {
    var minGasAmount: Double?
    var maxGasAmount: Double?
}
