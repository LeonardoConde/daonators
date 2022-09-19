package org.daonators.client

import org.daonators.AppTest
import org.daonators.client.context.RequestContext
import org.daonators.client.request.AuthRequest
import org.daonators.client.response.AuthResponse
import org.daonators.app.Facade.Env
import org.daonators.model.resource.User
import br.com.simpli.tools.SecurityUtils.sha256

/**
 * Extended class of handle tests
 * @author Simpli CLI generator
 */
open class ProcessTest: AppTest() {
    protected val context = RequestContext(transacConnector, param)

    protected val user = User().apply {
        idUser = Env.TESTER_ID
        email = Env.TESTER_LOGIN
        password = sha256(Env.TESTER_PASSWORD)
    }

    protected val authRequest: AuthRequest
    protected val token: String
    protected val auth: AuthResponse

    init {
        authRequest = AuthRequest(user.email, user.password)
        token = authRequest.toToken()
        auth = AuthResponse(token, user)
    }
}
