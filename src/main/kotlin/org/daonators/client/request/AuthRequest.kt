package org.daonators.client.request

import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import org.daonators.client.auth.AuthProcess
import org.daonators.exception.response.BadRequestException

/**
 * Authentication Request Model
 * @author Simpli CLI generator
 */
class AuthRequest(var email: String?, var password: String?) {
    fun validate(lang: LanguageHolder) {
        if (email.isNullOrEmpty()) {
            throw BadRequestException(lang.cannotBeNull("Email"))
        }

        if (!Validator.isEmail(email)) {
            throw BadRequestException(lang.isNotAValidEmail("Email"))
        }

        if (password.isNullOrEmpty()) {
            throw BadRequestException(lang.cannotBeNull("Password"))
        }
    }

    @Schema(hidden = true)
    fun toToken() = AuthProcess.requestToToken(this)
}
