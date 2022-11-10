package org.daonators.client.process

import org.daonators.client.ProcessTest
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import org.daonators.model.resource.Voting
import org.daonators.model.param.AuthVotingListParam
import java.util.Date
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNotSame
import org.junit.Ignore
import org.junit.Test

/**
 * Tests Voting business logic
 * @author Simpli CLI generator
 */
class VotingProcessTest : ProcessTest() {
    private val id1 = 1L
    private val id2 = 1L
    private val model = Voting()

    private val listFilter = AuthVotingListParam()

    private val subject = VotingProcess(context)

    init {
        model.idVotingPk = 1
        model.idOrganizationfk = 1
        model.idVotingTypeFk = 1
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
        val result = subject.get(id1, id2)
        assertNotSame(0, result.id1)
        assertNotSame(0, result.id2)
    }

    @Test(expected = NotFoundException::class)
    fun testGetFail() {
        subject.get(0, 0)
    }

    @Test
    fun testCreateSuccess() {
        model.id1 = 1
        model.id2 = 2

        val result = subject.create(model)
        assertTrue(result > 0)
    }

    @Test(expected = BadRequestException::class)
    fun testCreateFail() {
        model.id1 = id1
        model.id2 = id2

        subject.create(model)
    }

    @Test
    fun testUpdateSuccess() {
        model.id1 = id1
        model.id2 = id2

        val result = subject.update(model)
        assertTrue(result > 0)
    }

    @Test(expected = BadRequestException::class)
    fun testUpdateFail() {
        model.id1 = 0
        model.id2 = 0

        subject.update(model)
    }
}
