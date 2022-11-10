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
 * Tests AuthAdm
 * @author Simpli CLI generator
 */
class AuthAdmTest: AppTest() {
    private val lang = EnUs()
    private val model = AuthAdm()

    init {
        model.idAuthAdmPk = 1
        model.name = "1"
        model.email = "any@email.com"
        model.password = "1"
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

    @Test(expected = BadRequestException::class)
    fun testValidateEmailNullFail() {
        model.email = ""

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
    fun testValidatePasswordNullFail() {
        model.password = ""

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
