package org.daonators.model.filter

import java.util.Date

/**
 * Vote List Filter
 * @author Simpli CLI generator
 */
interface VoteListFilter : ListFilter {
    var idCampaingFk: List<Long>?

    var idUserWalletFk: List<Long>?

    var startLastUpdate: Date?
    var endLastUpdate: Date?

    var minIdOrganizationFk: Long?
    var maxIdOrganizationFk: Long?
}
