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
        model.idVotePk = 1
        model.lastUpdate = Date()
        model.tokensAmount = "1"
        model.idCampaingFk = 1
        model.idOrganizationFk = 1
        model.idUserWalletFk = 1
    }

    @Test(expected = BadRequestException::class)
    fun testValidateLastUpdateNullFail() {
        model.lastUpdate = null

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateTokensAmountNullFail() {
        model.tokensAmount = ""

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateIdCampaingFkNullFail() {
        model.idCampaingFk = 0L

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateIdOrganizationFkNullFail() {
        model.idOrganizationFk = 0L

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateIdUserWalletFkNullFail() {
        model.idUserWalletFk = 0L

        model.validate(lang)
    }

    @Test
    fun testValidateSuccess() {
        model.validate(lang)
    }
}
