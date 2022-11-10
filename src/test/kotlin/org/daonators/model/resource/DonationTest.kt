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
 * Tests Donation
 * @author Simpli CLI generator
 */
class DonationTest: AppTest() {
    private val lang = EnUs()
    private val model = Donation()

    init {
        model.idDonationPk = 1
        model.idCampaingFk = 1
        model.idOrganizationFk = 1
        model.gasAmount = 1.0
        model.transactionHash = "1"
    }

    @Test(expected = BadRequestException::class)
    fun testValidateTransactionHashNullFail() {
        model.transactionHash = ""

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateTransactionHashLengthFail() {
        model.transactionHash = RandomStringUtils.randomAlphabetic(67)

        model.validate(lang)
    }

    @Test
    fun testValidateSuccess() {
        model.validate(lang)
    }
}
