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

    var organizationTypeList: MutableList<OrganizationType>? = null

    @Schema(required = true, maxLength = 45)
    var name: String? = null

    @Schema(required = true, maxLength = 34)
    var walletAddress: String? = null

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
        if (walletAddress.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["Organization.walletAddress"]))
        }
        if (walletAddress?.length ?: 0 > 34) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["Organization.walletAddress"], 34))
        }
    }
}
