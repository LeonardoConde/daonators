package org.daonators.client.auth

import org.daonators.client.context.AuthPipe
import org.daonators.client.context.PublicPipe
import org.daonators.client.request.AuthRequest
import org.daonators.client.request.ChangePasswordRequest
import org.daonators.client.request.ResetPasswordRequest
import org.daonators.client.request.RecoverPasswordByMailRequest
import org.daonators.client.response.AuthResponse
import org.daonators.model.param.DefaultParam
import org.daonators.wrapper.RouterWrapper
import io.swagger.v3.oas.annotations.Operation
import javax.ws.rs.BeanParam
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.core.MediaType

/**
 * Routing the API address into Auth Process
 * @author Simpli CLI generator
 */
@Path("client/auth")
@Produces(MediaType.APPLICATION_JSON)
class AuthRouter : RouterWrapper() {
    @GET
    @Operation(tags = ["AuthRequest"], summary = "Gets the user authentication")
    fun authenticate(@BeanParam param: DefaultParam.Auth): AuthResponse {
        return PublicPipe.handle(readPipe, param) { context ->
            AuthProcess(context).authenticate(param)
        }
    }

    @POST
    @Operation(tags = ["AuthRequest"], summary = "Submits the user authentication")
    fun signIn(@BeanParam param: DefaultParam.Auth, request: AuthRequest): AuthResponse {
        return PublicPipe.handle(readPipe, param) { context ->
            AuthProcess(context).signIn(request)
        }
    }

    @PUT
    @Path("/password")
    @Operation(tags = ["RecoverPasswordByMailRequest"], summary = "Sends an email requesting to change the password")
    fun recoverPasswordByMail(@BeanParam param: DefaultParam.Auth, request: RecoverPasswordByMailRequest): Long {
        return PublicPipe.handle(readPipe, param) { context ->
            AuthProcess(context).recoverPasswordByMail(request)
        }
    }

    @POST
    @Path("/password")
    @Operation(tags = ["ResetPasswordRequest"], summary = "Recovers the password with a given hash")
    fun resetPassword(@BeanParam param: DefaultParam.Auth, request: ResetPasswordRequest): String {
        return PublicPipe.handle(transactionPipe, param) { context ->
            AuthProcess(context).resetPassword(request)
        }
    }

    @POST
    @Path("/me/password")
    @Operation(tags = ["ChangePasswordRequest"], summary = "Changes the password with a given new password")
    fun changePassword(@BeanParam param: DefaultParam.Auth, request: ChangePasswordRequest): Long {
        return AuthPipe.handle(transactionPipe, param) { context, auth ->
            AuthProcess(context).changePassword(request, auth)
        }
    }
}
