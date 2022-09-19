package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.OrganizationTypeProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthOrganizationTypeListParam
import org.daonators.model.resource.OrganizationType
import br.com.simpli.model.PageCollection
import io.swagger.v3.oas.annotations.Operation
import javax.ws.rs.BeanParam
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.core.MediaType

/**
 * Routing the API address into OrganizationType Process
 * @author Simpli CLI generator
 */
@Path("/client/organization-type")
@Produces(MediaType.APPLICATION_JSON)
class OrganizationTypeRouter : RouterWrapper() {
    @GET
    @Path("/{id}")
    @Operation(tags = ["OrganizationType"], summary = "Gets a instance of a given ID of OrganizationType")
    fun getOrganizationType(@BeanParam param: DefaultParam.RequiredPathId): OrganizationType {
        // TODO: review generated method
        return AuthPipe.handle(connectionPipe, param) { context, _ ->
            OrganizationTypeProcess(context).get(param.id)
		}
    }

    @GET
    @Operation(tags = ["OrganizationType"], summary = "Lists the instances of OrganizationType")
    fun listOrganizationType(@BeanParam param: AuthOrganizationTypeListParam): PageCollection<OrganizationType> {
        // TODO: review generated method
        return AuthPipe.handle(connectionPipe, param) { context, _ ->
            OrganizationTypeProcess(context).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["OrganizationType"], summary = "Lists the instances of OrganizationType to export as a file")
    fun listExportOrganizationType(@BeanParam param: AuthOrganizationTypeListParam): PageCollection<OrganizationType> {
        // TODO: review generated method
        return AuthPipe.handle(connectionPipe, param) { context, _ ->
            OrganizationTypeProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["OrganizationType"], summary = "Persists a new instance of OrganizationType. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistOrganizationType(@BeanParam param: DefaultParam.Auth, model: OrganizationType): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            OrganizationTypeProcess(context).persist(model)
		}
    }

    @DELETE
    @Path("/{id}")
    @Operation(tags = ["OrganizationType"], summary = "Deletes a instance of a given ID of OrganizationType")
    fun removeOrganizationType(@BeanParam param: DefaultParam.RequiredPathId): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            OrganizationTypeProcess(context).remove(param.id)
		}
    }
}
