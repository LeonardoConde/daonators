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
 * Tests CampaingOrganization
 * @author Simpli CLI generator
 */
class CampaingOrganizationTest: AppTest() {
    private val lang = EnUs()
    private val model = CampaingOrganization()

    init {
        model.idCampaingFk = 1
        model.idOrganizationFk = 1
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
