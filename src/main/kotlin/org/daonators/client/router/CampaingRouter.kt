package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.CampaingProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthCampaingListParam
import org.daonators.model.resource.Campaing
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
 * Routing the API address into Campaing Process
 * @author Simpli CLI generator
 */
@Path("/client/campaing")
@Produces(MediaType.APPLICATION_JSON)
class CampaingRouter : RouterWrapper() {
    @GET
    @Path("/{id}")
    @Operation(tags = ["Campaing"], summary = "Gets a instance of a given ID of Campaing")
    fun getCampaing(@BeanParam param: DefaultParam.RequiredPathId): Campaing {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            CampaingProcess(context).get(param.id)
		}
    }

    @GET
    @Operation(tags = ["Campaing"], summary = "Lists the instances of Campaing")
    fun listCampaing(@BeanParam param: AuthCampaingListParam): PageCollection<Campaing> {
        // TODO: review generated method
            return PublicPipe.handle(readPipe, param) { context ->
            CampaingProcess(context).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["Campaing"], summary = "Lists the instances of Campaing to export as a file")
    fun listExportCampaing(@BeanParam param: AuthCampaingListParam): PageCollection<Campaing> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            CampaingProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["Campaing"], summary = "Persists a new instance of Campaing. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistCampaing(@BeanParam param: DefaultParam.Auth, model: Campaing): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            CampaingProcess(context).persist(model)
		}
    }
}
