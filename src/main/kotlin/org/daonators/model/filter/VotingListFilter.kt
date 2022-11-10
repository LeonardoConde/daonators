package org.daonators.model.filter

import java.util.Date

/**
 * Voting List Filter
 * @author Simpli CLI generator
 */
interface VotingListFilter : ListFilter {
    var idCampaingFk: List<Long>?

    var idVotingTypeFk: List<Long>?
}
