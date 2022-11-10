package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table organization
 * @author Simpli CLI generator
 */
class Organization {
    @Schema(required = true) var idOrganizationPk: Long = 0

    var campaingOrganization: MutableList<Campaing>? = null

    @Schema(required = true, maxLength = 45)
    var name: String? = null

    @Schema(required = true, maxLength = 42)
    var scriptHash: String? = null

    @Schema(required = true) var active: Boolean? = null

    var id
        @Schema(hidden = true)
        get() = idOrganizationPk
        set(value) {
            idOrganizationPk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (name.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["Organization.name"]))
        }
        if (name?.length ?: 0 > 45) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["Organization.name"], 45))
        }
        if (scriptHash.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["Organization.scriptHash"]))
        }
        if (scriptHash?.length ?: 0 > 42) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["Organization.scriptHash"], 42))
        }
    }
}
