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
 * Tests User
 * @author Simpli CLI generator
 */
class UserTest: AppTest() {
    private val lang = EnUs()
    private val model = User()

    init {
        model.idUser = 1
    }

    @Test(expected = BadRequestException::class)
    fun testValidateNameLengthFail() {
        model.name = RandomStringUtils.randomAlphabetic(46)

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateEmailLengthFail() {
        model.email = RandomStringUtils.randomAlphabetic(46)

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateEmailInvalidEmailFail() {
        model.email = "notAnEmail"

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidatePasswordLengthFail() {
        model.password = RandomStringUtils.randomAlphabetic(256)

        model.validate(lang)
    }

    @Test
    fun testValidateSuccess() {
        model.validate(lang)
    }
}
