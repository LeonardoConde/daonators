package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.CampaingOrganizationProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthCampaingOrganizationListParam
import org.daonators.model.resource.CampaingOrganization
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
 * Routing the API address into CampaingOrganization Process
 * @author Simpli CLI generator
 */
@Path("/client/campaing-organization")
@Produces(MediaType.APPLICATION_JSON)
class CampaingOrganizationRouter : RouterWrapper() {
    @GET
    @Path("/{id1}/{id2}")
    @Operation(tags = ["CampaingOrganization"], summary = "Gets a instance of a given ID of CampaingOrganization")
    fun getCampaingOrganization(@BeanParam param: CampaingOrganization.RequiredPathId): CampaingOrganization {
        // TODO: review generated method
        return AuthPipe.handle(connectionPipe, param) { context, _ ->
            CampaingOrganizationProcess(context).get(param.id1, param.id2)
		}
    }

    @GET
    @Operation(tags = ["CampaingOrganization"], summary = "Lists the instances of CampaingOrganization")
    fun listCampaingOrganization(@BeanParam param: AuthCampaingOrganizationListParam): PageCollection<CampaingOrganization> {
        // TODO: review generated method
        return AuthPipe.handle(connectionPipe, param) { context, _ ->
            CampaingOrganizationProcess(context).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["CampaingOrganization"], summary = "Lists the instances of CampaingOrganization to export as a file")
    fun listExportCampaingOrganization(@BeanParam param: AuthCampaingOrganizationListParam): PageCollection<CampaingOrganization> {
        // TODO: review generated method
        return AuthPipe.handle(connectionPipe, param) { context, _ ->
            CampaingOrganizationProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["CampaingOrganization"], summary = "Persists a new instance of CampaingOrganization. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistCampaingOrganization(@BeanParam param: DefaultParam.Auth, model: CampaingOrganization): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            CampaingOrganizationProcess(context).persist(model)
		}
    }
}
