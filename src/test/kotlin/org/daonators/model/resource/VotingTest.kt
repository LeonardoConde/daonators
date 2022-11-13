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
 * Tests Voting
 * @author Simpli CLI generator
 */
class VotingTest: AppTest() {
    private val lang = EnUs()
    private val model = Voting()

    init {
        model.idVotingPk = 1
        model.idOrganizationfk = 1
        model.idVotingTypeFk = 1
    }

    @Test
    fun testSetCampaingNull() {
        model.campaing = Campaing()
        model.idCampaingFk = null
        assertNull(model.campaing)
        model.idCampaingFk = 1L
        assertNotNull(model.campaing)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateIdVotingTypeFkNullFail() {
        model.idVotingTypeFk = 0L

        model.validate(lang)
    }

    @Test
    fun testValidateSuccess() {
        model.validate(lang)
    }
}
