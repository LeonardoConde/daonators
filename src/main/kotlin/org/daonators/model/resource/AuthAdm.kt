package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table auth_adm
 * @author Simpli CLI generator
 */
class AuthAdm {
    @Schema(required = true) var idAuthAdmPk: Long = 0

    @Schema(required = true, maxLength = 45)
    var name: String? = null

    @Schema(required = true, maxLength = 45)
    var email: String? = null

    @Schema(required = true, maxLength = 255)
    var password: String? = null

    var id
        @Schema(hidden = true)
        get() = idAuthAdmPk
        set(value) {
            idAuthAdmPk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (name.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["AuthAdm.name"]))
        }
        if (name?.length ?: 0 > 45) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["AuthAdm.name"], 45))
        }
        if (email.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["AuthAdm.email"]))
        }
        if (email?.length ?: 0 > 45) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["AuthAdm.email"], 45))
        }
        if (email != null && !Validator.isEmail(email)) {
            throw BadRequestException(lang.isNotAValidEmail(lang["AuthAdm.email"]))
        }
        if (password.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["AuthAdm.password"]))
        }
        if (password?.length ?: 0 > 255) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["AuthAdm.password"], 255))
        }
    }
}
