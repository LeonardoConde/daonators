package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table user
 * @author Simpli CLI generator
 */
class User {
    @Schema(required = true) var idUser: Long = 0

    @Schema(maxLength = 45) var name: String? = null
    @Schema(maxLength = 45) var email: String? = null
    @Schema(maxLength = 255) var password: String? = null

    var id
        @Schema(hidden = true)
        get() = idUser
        set(value) {
            idUser = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (name?.length ?: 0 > 45) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["User.name"], 45))
        }
        if (email?.length ?: 0 > 45) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["User.email"], 45))
        }
        if (email != null && !Validator.isEmail(email)) {
            throw BadRequestException(lang.isNotAValidEmail(lang["User.email"]))
        }
        if (password?.length ?: 0 > 255) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["User.password"], 255))
        }
    }
}
