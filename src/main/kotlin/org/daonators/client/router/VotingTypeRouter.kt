package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.VotingTypeProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthVotingTypeListParam
import org.daonators.model.resource.VotingType
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
 * Routing the API address into VotingType Process
 * @author Simpli CLI generator
 */
@Path("/client/voting-type")
@Produces(MediaType.APPLICATION_JSON)
class VotingTypeRouter : RouterWrapper() {
    @GET
    @Path("/{id}")
    @Operation(tags = ["VotingType"], summary = "Gets a instance of a given ID of VotingType")
    fun getVotingType(@BeanParam param: DefaultParam.RequiredPathId): VotingType {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            VotingTypeProcess(context).get(param.id)
		}
    }

    @GET
    @Operation(tags = ["VotingType"], summary = "Lists the instances of VotingType")
    fun listVotingType(@BeanParam param: AuthVotingTypeListParam): PageCollection<VotingType> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            VotingTypeProcess(context).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["VotingType"], summary = "Lists the instances of VotingType to export as a file")
    fun listExportVotingType(@BeanParam param: AuthVotingTypeListParam): PageCollection<VotingType> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            VotingTypeProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["VotingType"], summary = "Persists a new instance of VotingType. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistVotingType(@BeanParam param: DefaultParam.Auth, model: VotingType): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            VotingTypeProcess(context).persist(model)
		}
    }

    @DELETE
    @Path("/{id}")
    @Operation(tags = ["VotingType"], summary = "Deletes a instance of a given ID of VotingType")
    fun removeVotingType(@BeanParam param: DefaultParam.RequiredPathId): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            VotingTypeProcess(context).remove(param.id)
		}
    }
}
