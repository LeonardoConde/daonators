package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.VoteProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthVoteListParam
import org.daonators.model.resource.Vote
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
 * Routing the API address into Vote Process
 * @author Simpli CLI generator
 */
@Path("/client/vote")
@Produces(MediaType.APPLICATION_JSON)
class VoteRouter : RouterWrapper() {
    @GET
    @Path("/{id}")
    @Operation(tags = ["Vote"], summary = "Gets a instance of a given ID of Vote")
    fun getVote(@BeanParam param: DefaultParam.RequiredPathId): Vote {
        // TODO: review generated method
        return AuthPipe.handle(connectionPipe, param) { context, _ ->
            VoteProcess(context).get(param.id)
		}
    }

    @GET
    @Operation(tags = ["Vote"], summary = "Lists the instances of Vote")
    fun listVote(@BeanParam param: AuthVoteListParam): PageCollection<Vote> {
        // TODO: review generated method
        return AuthPipe.handle(connectionPipe, param) { context, _ ->
            VoteProcess(context).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["Vote"], summary = "Lists the instances of Vote to export as a file")
    fun listExportVote(@BeanParam param: AuthVoteListParam): PageCollection<Vote> {
        // TODO: review generated method
        return AuthPipe.handle(connectionPipe, param) { context, _ ->
            VoteProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["Vote"], summary = "Persists a new instance of Vote. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistVote(@BeanParam param: DefaultParam.Auth, model: Vote): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            VoteProcess(context).persist(model)
		}
    }
}
