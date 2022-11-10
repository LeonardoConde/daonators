package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.OrganizationProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthOrganizationListParam
import org.daonators.model.resource.Organization
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
 * Routing the API address into Organization Process
 * @author Simpli CLI generator
 */
@Path("/client/organization")
@Produces(MediaType.APPLICATION_JSON)
class OrganizationRouter : RouterWrapper() {
    @GET
    @Path("/{id}")
    @Operation(tags = ["Organization"], summary = "Gets a instance of a given ID of Organization")
    fun getOrganization(@BeanParam param: DefaultParam.RequiredPathId): Organization {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            OrganizationProcess(context).get(param.id)
		}
    }

    @GET
    @Operation(tags = ["Organization"], summary = "Lists the instances of Organization")
    fun listOrganization(@BeanParam param: AuthOrganizationListParam): PageCollection<Organization> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            OrganizationProcess(context).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["Organization"], summary = "Lists the instances of Organization to export as a file")
    fun listExportOrganization(@BeanParam param: AuthOrganizationListParam): PageCollection<Organization> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            OrganizationProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["Organization"], summary = "Persists a new instance of Organization. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistOrganization(@BeanParam param: DefaultParam.Auth, model: Organization): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            OrganizationProcess(context).persist(model)
		}
    }

    @DELETE
    @Path("/{id}")
    @Operation(tags = ["Organization"], summary = "Deletes a instance of a given ID of Organization")
    fun removeOrganization(@BeanParam param: DefaultParam.RequiredPathId): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            OrganizationProcess(context).remove(param.id)
		}
    }
}
