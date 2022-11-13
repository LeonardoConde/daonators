package org.daonators.client.context

import org.daonators.model.param.DefaultParam
import br.com.simpli.sql.AbstractConPipe
import org.daonators.client.auth.AuthProcess

/**
 * Public Pipe
 * Responsible to control the data which is entering into the server
 * @author Simpli CLI generator
 */
object PublicPipe {
    fun <T> handle(
        conPipe: AbstractConPipe,
        param: DefaultParam.Auth,
        callback: (context: RequestContext) -> T
    ): T {
        return conPipe.handle {
            val context = RequestContext(it, param)
            context.auth = param.authorization?.let {
                AuthProcess(context).authenticate(param)
            }
            callback(context)
        }
    }
}


