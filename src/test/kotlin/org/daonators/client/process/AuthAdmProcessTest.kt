package org.daonators.client.process

import org.daonators.client.ProcessTest
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import org.daonators.model.resource.AuthAdm
import org.daonators.model.param.AuthAuthAdmListParam
import java.util.Date
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNotSame
import org.junit.Ignore
import org.junit.Test

/**
 * Tests AuthAdm business logic
 * @author Simpli CLI generator
 */
class AuthAdmProcessTest : ProcessTest() {
    private val id = 1L
    private val model = AuthAdm()

    private val listFilter = AuthAuthAdmListParam()

    private val subject = AuthAdmProcess(context)

    init {
        model.idAuthAdmPk = 1
        model.name = "1"
        model.email = "any@email.com"
        model.password = "1"
    }

    @Test
    fun testList() {
        val result = subject.list(listFilter)
        assertFalse(result.items.isEmpty())
        assertNotEquals(0, result.total)
    }

    @Test
    fun testListPaginated() {
        listFilter.page = 0
        listFilter.limit = 1

        val result = subject.list(listFilter)
        assertFalse(result.items.isEmpty())
        assertNotEquals(0, result.total)
        assertTrue(result.items.size <= listFilter.limit ?: 0)
    }

    @Test
    fun testGetSuccess() {
        val result = subject.get(id)
        assertNotSame(0, result.id)
    }

    @Test(expected = NotFoundException::class)
    fun testGetFail() {
        subject.get(0)
    }

    @Test
    fun testCreateSuccess() {
        model.id = 0

        val result = subject.create(model)
        assertTrue(result > 0)
    }

    @Test(expected = BadRequestException::class)
    fun testCreateFail() {
        model.id = id

        subject.create(model)
    }

    @Test
    fun testUpdateSuccess() {
        model.id = id

        val result = subject.update(model)
        assertTrue(result > 0)
    }

    @Test(expected = BadRequestException::class)
    fun testUpdateFail() {
        model.id = 0

        subject.update(model)
    }
}
