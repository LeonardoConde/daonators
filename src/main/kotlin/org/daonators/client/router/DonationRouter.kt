package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.DonationProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthDonationListParam
import org.daonators.model.resource.Donation
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
 * Routing the API address into Donation Process
 * @author Simpli CLI generator
 */
@Path("/client/donation")
@Produces(MediaType.APPLICATION_JSON)
class DonationRouter : RouterWrapper() {
    @GET
    @Path("/{id1}")
    @Operation(tags = ["Donation"], summary = "Gets a instance of a given ID of Donation")
    fun getDonation(@BeanParam param: Donation.RequiredPathId): Donation {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            DonationProcess(context).get(param.id1)
		}
    }

    @GET
    @Operation(tags = ["Donation"], summary = "Lists the instances of Donation")
    fun listDonation(@BeanParam param: AuthDonationListParam): PageCollection<Donation> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            DonationProcess(context).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["Donation"], summary = "Lists the instances of Donation to export as a file")
    fun listExportDonation(@BeanParam param: AuthDonationListParam): PageCollection<Donation> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            DonationProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["Donation"], summary = "Persists a new instance of Donation. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistDonation(@BeanParam param: DefaultParam.Auth, model: Donation): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            DonationProcess(context).persist(model)
		}
    }
}
