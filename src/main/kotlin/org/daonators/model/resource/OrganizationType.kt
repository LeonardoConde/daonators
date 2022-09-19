package org.daonators.model.resource

import org.daonators.exception.response.BadRequestException
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.tools.Validator
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Date
import javax.ws.rs.PathParam

/**
 * Reference model of table organization_type
 * @author Simpli CLI generator
 */
class OrganizationType {
    @Schema(required = true) var idOrganizationTypePk: Long = 0

    var organizationTypeList: MutableList<Organization>? = null

    @Schema(required = true, maxLength = 45)
    var name: String? = null

    @Schema(required = true) var active: Boolean? = null

    var id
        @Schema(hidden = true)
        get() = idOrganizationTypePk
        set(value) {
            idOrganizationTypePk = value
        }

    fun validate(lang: LanguageHolder) {
        // TODO: review generated method
        if (name.isNullOrBlank()) {
            throw BadRequestException(lang.cannotBeNull(lang["OrganizationType.name"]))
        }
        if (name?.length ?: 0 > 45) {
            throw BadRequestException(lang.lengthCannotBeMoreThan(lang["OrganizationType.name"], 45))
        }
    }
}
