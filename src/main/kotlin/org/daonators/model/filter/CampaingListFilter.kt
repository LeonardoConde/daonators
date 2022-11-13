package org.daonators.model.filter

import java.util.Date

/**
 * Campaing List Filter
 * @author Simpli CLI generator
 */
interface CampaingListFilter : ListFilter {
    var startBeginDate: Date?
    var endBeginDate: Date?

    var startEndDate: Date?
    var endEndDate: Date?
}
