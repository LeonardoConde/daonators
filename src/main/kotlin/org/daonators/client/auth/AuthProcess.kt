package org.daonators.client.auth

import org.daonators.app.Cast
import org.daonators.app.Facade.Env
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import org.daonators.exception.response.UnauthorizedException
import org.daonators.model.param.DefaultParam
import org.daonators.model.resource.AuthAdm
import org.daonators.client.context.RequestContext
import org.daonators.client.mail.RecoverPasswordMail
import org.daonators.client.request.AuthRequest
import org.daonators.client.request.ChangePasswordRequest
import org.daonators.client.request.ResetPasswordRequest
import org.daonators.client.request.RecoverPasswordByMailRequest
import org.daonators.client.response.AuthResponse
import br.com.simpli.tools.SecurityUtils
import java.util.regex.Pattern
import java.util.Date
import java.util.Calendar

/**
 * Responsible for Authentication operations
 * @author Simpli CLI generator
 */
class AuthProcess(val context: RequestContext) {
    val dao = AuthDao(context.con)

    /**
     * Get the authentication information by the token
     */
    fun authenticate(param: DefaultParam.Auth): AuthResponse {
        val token = extractToken(param.authorization ?: "") ?: throw UnauthorizedException(context.lang["invalid_token"])
        try {
            val request = tokenToRequest(token)
            val id = getId(request)
            val authAdm = getAuthAdm(id)

            return AuthResponse(token, authAdm)
        } catch (e: BadRequestException) {
            throw UnauthorizedException(context.lang.pleaseLogin())
        } catch (e: NotFoundException) {
            throw UnauthorizedException(context.lang.pleaseLogin())
        }
    }

    /**
     * Get the authentication information according to a login attempt
     */
    fun signIn(request: AuthRequest): AuthResponse {
        try {
            val token = requestToToken(request)
            val id = getId(request)
            val authAdm = getAuthAdm(id)

            return AuthResponse(token, authAdm)
        } catch (e: NotFoundException) {
            throw UnauthorizedException(context.lang.invalidLogin())
        }
    }

    class TokenForgottenPassword(val email: String, val date: Date = Date())

    /**
     * Send an e-mail in order to reset the password
     */
    fun recoverPasswordByMail(request: RecoverPasswordByMailRequest): Long {
        request.validate(context.lang)

        val authAdm = dao.getAuthAdmByEmail("${request.email}") ?: throw BadRequestException(context.lang.emailNotFound())

        val json = Cast.classToJson(TokenForgottenPassword("${authAdm.email}"))
        val encrypted = SecurityUtils.encrypt(json, Env.ENCRYPT_HASH)
        val hash = encrypted?.replace("/", "%2F") ?: "invalid_hash"

        RecoverPasswordMail(context.lang, authAdm, hash).send()

        return 1L
    }

    /**
     * Reset the password
     */
    fun resetPassword(request: ResetPasswordRequest): String {
        request.validate(context.lang)

        val hashResolved = request.hash?.replace(" ", "+") ?: ""
        val token = SecurityUtils.decrypt(hashResolved, Env.ENCRYPT_HASH) ?: throw BadRequestException(context.lang.invalidToken())

        val tokenForgottenPassword = Cast.jsonToClass(token, TokenForgottenPassword::class.java)

        val calendar = Calendar.getInstance()
        calendar.time = tokenForgottenPassword.date
        calendar.add(Calendar.DAY_OF_MONTH, Env.FORGOTTEN_PASSWORD_TOKEN_LIFE)

        // token expires after x days
        if (calendar.time.before(Date())) throw BadRequestException(context.lang.expiredToken())

        request.newPassword?.also {
            dao.updateAuthAdmPassword(tokenForgottenPassword.email, it)
        }

        return requestToToken(AuthRequest(tokenForgottenPassword.email, request.newPassword))
    }

    /**
     * Change the password
     */
    fun changePassword(request: ChangePasswordRequest, auth: AuthResponse): Long {
        val id = auth.id
        val authAdm = auth.authAdm
        val email = authAdm.email ?: throw BadRequestException()

        request.validate(context.lang)

        request.newPassword?.also { newPassword ->
            request.currentPassword?.also { currentPassword ->
                val idVerify = dao.getIdOfAuthAdm(email, currentPassword)
                if (id != idVerify) throw BadRequestException(context.lang["wrong_password"])

                dao.updateAuthAdmPassword(email, newPassword)
            }
        }

        return 1L
    }

    /**
     * Get the ID by auth request
     */
    fun getId(request: AuthRequest): Long {
        request.validate(context.lang)

        return dao.getIdOfAuthAdm("${request.email}", "${request.password}") ?: throw NotFoundException(context.lang["user_id_not_found"])
    }

    /**
     * Get the user by ID
     */
    fun getAuthAdm(idAuthAdmPk: Long): AuthAdm {
        return dao.getAuthAdm(idAuthAdmPk) ?: throw NotFoundException(context.lang["user_not_found"])
    }

    companion object {
        /**
         * Transforms AuthRequest object into token string
         */
        fun requestToToken(request: AuthRequest): String {
            val empty = "invalid_token"
            return try {
                val json = Cast.classToJson(request)
                val encrypted = SecurityUtils.encrypt(json, Env.ENCRYPT_HASH) ?: empty
                val token = SecurityUtils.encode(encrypted, "UTF-8") ?: empty

                token
            } catch (e: Exception) {
                empty
            }
        }

        /**
         * Transforms token string into AuthRequest object
         */
        fun tokenToRequest(token: String): AuthRequest {
            val empty = AuthRequest(null, null)
            return try {
                val encrypted = SecurityUtils.decode(token, "UTF-8")
                val json = SecurityUtils.decrypt(encrypted ?: return empty, Env.ENCRYPT_HASH)
                val request = Cast.jsonToClass(json ?: return empty, AuthRequest::class.java)

                request
            } catch (e: Exception) {
                empty
            }
        }

        /**
         * Extracts token from the header
         */
        fun extractToken(authorization: String): String? {
            val matcher = Pattern.compile("Bearer (.*)").matcher(authorization)
            return if (matcher.find()) matcher.group(1) else null
        }
    }
}
