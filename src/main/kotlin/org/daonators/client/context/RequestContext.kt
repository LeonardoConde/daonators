package org.daonators.client.context

import org.daonators.app.Facade.Env
import org.daonators.enums.Lang
import org.daonators.locale.EnUs
import org.daonators.model.filter.ListFilter
import org.daonators.model.param.DefaultParam
import br.com.simpli.model.LanguageHolder
import br.com.simpli.sql.AbstractConnector

/**
 * Request Context
 * Responsible to validate the request
 * @author Simpli CLI generator
 */
 open class RequestContext(val con: AbstractConnector, param: DefaultParam) {
     val lang: LanguageHolder = Env.AVAILABLE_LANGUAGES[Lang.from(param.lang)] ?: EnUs()
     val clientVersion: String = param.clientVersion

     init {
         when (param) {
             is ListFilter -> {
                 param.query = param.query?.replace("[.,:\\-/]".toRegex(), "")
             }
         }
     }
 }
