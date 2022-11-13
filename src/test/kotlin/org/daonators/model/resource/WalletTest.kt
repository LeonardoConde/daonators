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
 * Tests Wallet
 * @author Simpli CLI generator
 */
class WalletTest: AppTest() {
    private val lang = EnUs()
    private val model = Wallet()

    init {
        model.idWalletPk = 1
    }

    @Test(expected = BadRequestException::class)
    fun testValidateWalletLengthFail() {
        model.wallet = RandomStringUtils.randomAlphabetic(46)

        model.validate(lang)
    }

    @Test
    fun testValidateSuccess() {
        model.validate(lang)
    }
}
