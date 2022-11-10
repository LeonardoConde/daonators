package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.VotingProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthVotingListParam
import org.daonators.model.resource.Voting
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
 * Routing the API address into Voting Process
 * @author Simpli CLI generator
 */
@Path("/client/voting")
@Produces(MediaType.APPLICATION_JSON)
class VotingRouter : RouterWrapper() {
    @GET
    @Path("/{id1}/{id2}")
    @Operation(tags = ["Voting"], summary = "Gets a instance of a given ID of Voting")
    fun getVoting(@BeanParam param: Voting.RequiredPathId): Voting {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            VotingProcess(context).get(param.id1, param.id2)
		}
    }

    @GET
    @Operation(tags = ["Voting"], summary = "Lists the instances of Voting")
    fun listVoting(@BeanParam param: AuthVotingListParam): PageCollection<Voting> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            VotingProcess(context).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["Voting"], summary = "Lists the instances of Voting to export as a file")
    fun listExportVoting(@BeanParam param: AuthVotingListParam): PageCollection<Voting> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            VotingProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["Voting"], summary = "Persists a new instance of Voting. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistVoting(@BeanParam param: DefaultParam.Auth, model: Voting): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            VotingProcess(context).persist(model)
		}
    }
}
