package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.AuthAdmProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthAuthAdmListParam
import org.daonators.model.resource.AuthAdm
import br.com.simpli.model.PageCollection
import io.swagger.v3.oas.annotations.Operation
import org.daonators.client.context.PublicPipe
import javax.ws.rs.BeanParam
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.core.MediaType

/**
 * Routing the API address into AuthAdm Process
 * @author Simpli CLI generator
 */
@Path("/client/auth-adm")
@Produces(MediaType.APPLICATION_JSON)
class AuthAdmRouter : RouterWrapper() {
    @GET
    @Path("/{id}")
    @Operation(tags = ["AuthAdm"], summary = "Gets a instance of a given ID of AuthAdm")
    fun getAuthAdm(@BeanParam param: DefaultParam.RequiredPathId): AuthAdm {
        // TODO: review generated method
        return AuthPipe.handle(readPipe, param) { context, _ ->
            AuthAdmProcess(context).get(param.id)
		}
    }

    @GET
    @Operation(tags = ["AuthAdm"], summary = "Lists the instances of AuthAdm")
    fun listAuthAdm(@BeanParam param: AuthAuthAdmListParam): PageCollection<AuthAdm> {
        // TODO: review generated method
        return AuthPipe.handle(readPipe, param) { context, _ ->
            AuthAdmProcess(context).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["AuthAdm"], summary = "Lists the instances of AuthAdm to export as a file")
    fun listExportAuthAdm(@BeanParam param: AuthAuthAdmListParam): PageCollection<AuthAdm> {
        // TODO: review generated method
        return AuthPipe.handle(readPipe, param) { context, _ ->
            AuthAdmProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["AuthAdm"], summary = "Persists a new instance of AuthAdm. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistAuthAdm(@BeanParam param: DefaultParam.Auth, model: AuthAdm): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            AuthAdmProcess(context).persist(model)
		}
    }
}
