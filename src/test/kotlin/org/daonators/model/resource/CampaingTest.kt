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
 * Tests Campaing
 * @author Simpli CLI generator
 */
class CampaingTest: AppTest() {
    private val lang = EnUs()
    private val model = Campaing()

    init {
        model.idCampaingPk = 1
        model.socialCause = "1"
        model.beginDate = Date()
        model.endDate = Date()
    }

    @Test(expected = BadRequestException::class)
    fun testValidateNameLengthFail() {
        model.name = RandomStringUtils.randomAlphabetic(46)

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateSocialCauseNullFail() {
        model.socialCause = ""

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateSocialCauseLengthFail() {
        model.socialCause = RandomStringUtils.randomAlphabetic(256)

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateBeginDateNullFail() {
        model.beginDate = null

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateEndDateNullFail() {
        model.endDate = null

        model.validate(lang)
    }

    @Test
    fun testValidateSuccess() {
        model.validate(lang)
    }
}
