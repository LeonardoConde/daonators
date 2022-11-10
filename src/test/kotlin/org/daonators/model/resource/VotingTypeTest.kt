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
 * Tests VotingType
 * @author Simpli CLI generator
 */
class VotingTypeTest: AppTest() {
    private val lang = EnUs()
    private val model = VotingType()

    init {
        model.idVotingTypePk = 1
        model.name = "1"
        model.active = true
    }

    @Test(expected = BadRequestException::class)
    fun testValidateNameNullFail() {
        model.name = ""

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateNameLengthFail() {
        model.name = RandomStringUtils.randomAlphabetic(46)

        model.validate(lang)
    }

    @Test
    fun testValidateSuccess() {
        model.validate(lang)
    }
}
