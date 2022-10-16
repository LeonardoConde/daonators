package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.CampaingTypeProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthCampaingTypeListParam
import org.daonators.model.resource.CampaingType
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
 * Routing the API address into CampaingType Process
 * @author Simpli CLI generator
 */
@Path("/client/campaing-type")
@Produces(MediaType.APPLICATION_JSON)
class CampaingTypeRouter : RouterWrapper() {
    @GET
    @Path("/{id}")
    @Operation(tags = ["CampaingType"], summary = "Gets a instance of a given ID of CampaingType")
    fun getCampaingType(@BeanParam param: DefaultParam.RequiredPathId): CampaingType {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) {
            CampaingTypeProcess(it).get(param.id)
		}
    }

    @GET
    @Operation(tags = ["CampaingType"], summary = "Lists the instances of CampaingType")
    fun listCampaingType(@BeanParam param: AuthCampaingTypeListParam): PageCollection<CampaingType> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) {
            CampaingTypeProcess(it).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["CampaingType"], summary = "Lists the instances of CampaingType to export as a file")
    fun listExportCampaingType(@BeanParam param: AuthCampaingTypeListParam): PageCollection<CampaingType> {
        // TODO: review generated method
        return AuthPipe.handle(readPipe, param) { context, _ ->
            CampaingTypeProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["CampaingType"], summary = "Persists a new instance of CampaingType. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistCampaingType(@BeanParam param: DefaultParam.Auth, model: CampaingType): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            CampaingTypeProcess(context).persist(model)
		}
    }

    @DELETE
    @Path("/{id}")
    @Operation(tags = ["CampaingType"], summary = "Deletes a instance of a given ID of CampaingType")
    fun removeCampaingType(@BeanParam param: DefaultParam.RequiredPathId): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            CampaingTypeProcess(context).remove(param.id)
		}
    }
}
