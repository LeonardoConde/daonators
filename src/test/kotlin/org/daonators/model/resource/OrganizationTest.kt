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
 * Tests Organization
 * @author Simpli CLI generator
 */
class OrganizationTest: AppTest() {
    private val lang = EnUs()
    private val model = Organization()

    init {
        model.idOrganizationPk = 1
        model.name = "1"
        model.scriptHash = "1"
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

    @Test(expected = BadRequestException::class)
    fun testValidateScriptHashNullFail() {
        model.scriptHash = ""

        model.validate(lang)
    }

    @Test(expected = BadRequestException::class)
    fun testValidateScriptHashLengthFail() {
        model.scriptHash = RandomStringUtils.randomAlphabetic(43)

        model.validate(lang)
    }

    @Test
    fun testValidateSuccess() {
        model.validate(lang)
    }
}
