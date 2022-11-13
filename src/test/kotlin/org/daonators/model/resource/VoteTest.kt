package org.daonators.model.resource

import org.daonators.AppTest
import org.daonators.exception.response.BadRequestException
import org.daonators.locale.EnUs
import java.util.Date
import org.apache.commons.lang3.RandomStringUtils
import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull

/**
 * Tests Vote
 * @author Simpli CLI generator
 */
class VoteTest: AppTest() {
    private val lang = EnUs()
    private val model = Vote()

    init {
        model.idVotingFk = 1
        model.idUserWalletFk = 1
        model.tokenAmount = 1.0
    }

    @Test
    fun testValidateSuccess() {
        model.validate(lang)
    }
}
