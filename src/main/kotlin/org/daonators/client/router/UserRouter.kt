package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.UserProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthUserListParam
import org.daonators.model.resource.User
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
 * Routing the API address into User Process
 * @author Simpli CLI generator
 */
@Path("/client/user")
@Produces(MediaType.APPLICATION_JSON)
class UserRouter : RouterWrapper() {
    @GET
    @Path("/{id}")
    @Operation(tags = ["User"], summary = "Gets a instance of a given ID of User")
    fun getUser(@BeanParam param: DefaultParam.RequiredPathId): User {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) {
            UserProcess(it).get(param.id)
		}
    }

    @GET
    @Operation(tags = ["User"], summary = "Lists the instances of User")
    fun listUser(@BeanParam param: AuthUserListParam): PageCollection<User> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) {
            UserProcess(it).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["User"], summary = "Lists the instances of User to export as a file")
    fun listExportUser(@BeanParam param: AuthUserListParam): PageCollection<User> {
        // TODO: review generated method
        return AuthPipe.handle(readPipe, param) { context, _ ->
            UserProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["User"], summary = "Persists a new instance of User. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistUser(@BeanParam param: DefaultParam.Auth, model: User): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            UserProcess(context).persist(model)
		}
    }
}
