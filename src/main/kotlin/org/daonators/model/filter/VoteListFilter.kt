package org.daonators.model.filter

import java.util.Date

/**
 * Vote List Filter
 * @author Simpli CLI generator
 */
interface VoteListFilter : ListFilter {
    var minTokenAmount: Double?
    var maxTokenAmount: Double?
}
