package org.daonators.client.auth

import org.daonators.client.ProcessTest
import org.daonators.client.request.AuthRequest
import org.daonators.client.request.ChangePasswordRequest
import org.daonators.app.Facade.Env
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import org.daonators.exception.response.UnauthorizedException
import org.daonators.model.param.DefaultParam
import br.com.simpli.tools.SecurityUtils.sha256
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Tests the login service
 * @author Simpli CLI generator
 */
class AuthProcessTest : ProcessTest() {
    private val unauthorizedRequest = AuthRequest(Env.TESTER_LOGIN, "wrongpassword")
    private val subject = AuthProcess(context)

    @Test(expected = UnauthorizedException::class)
    fun testAuthFail() {
        val param = DefaultParam.Auth()
        param.authorization = "invalidtoken"
        subject.authenticate(param)
    }

    @Test
    fun testAuth() {
        val param = DefaultParam.Auth()
        param.authorization = "Bearer $token"
        subject.authenticate(param)
    }

    @Test(expected = UnauthorizedException::class)
    fun testSignInFail() {
        subject.signIn(unauthorizedRequest)
    }

    @Test
    fun testSignIn() {
        val result = subject.signIn(authRequest)
        assertEquals(token, result.token)
    }

    @Test
    fun testChangePassword() {
        val request = ChangePasswordRequest(
                sha256(Env.TESTER_PASSWORD),
                sha256("""${Env.TESTER_PASSWORD}new"""),
                sha256("""${Env.TESTER_PASSWORD}new""")
        )

        val result = subject.changePassword(request, auth)
        assertEquals(1L, result)
    }

    @Test(expected = BadRequestException::class)
    fun testChangePasswordWrongPassword() {
        val request = ChangePasswordRequest(
                sha256("wrongpassword"),
                sha256("""${Env.TESTER_PASSWORD}new"""),
                sha256("""${Env.TESTER_PASSWORD}new""")
        )

        subject.changePassword(request, auth)
    }

    @Test(expected = BadRequestException::class)
    fun testChangePasswordPasswordNoMatch() {
        val request = ChangePasswordRequest(
                sha256(Env.TESTER_PASSWORD),
                sha256("""${Env.TESTER_PASSWORD}new"""),
                sha256("""${Env.TESTER_PASSWORD}different""")
        )

        subject.changePassword(request, auth)
    }

    @Test(expected = NotFoundException::class)
    fun testGetIdNotFound() {
        subject.getId(unauthorizedRequest)
    }

    @Test
    fun testGetId() {
        val result = subject.getId(authRequest)
        assertEquals(user.id, result)
    }

    @Test(expected = NotFoundException::class)
    fun testGetUserNotFound() {
        subject.getUser(0)
    }

    @Test
    fun testGetUser() {
        val result = subject.getUser(user.id)
        assertEquals(user.email, result.email)
    }

    @Test
    fun testRequestToToken() {
        val result = AuthProcess.requestToToken(authRequest)
        assertEquals(token, result)
    }

    @Test
    fun testTokenToRequest() {
        val result = AuthProcess.tokenToRequest(token)
        assertEquals(user.email, result.email)
    }
}
