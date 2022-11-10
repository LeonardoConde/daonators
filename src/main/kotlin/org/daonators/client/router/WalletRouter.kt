package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.WalletProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthWalletListParam
import org.daonators.model.resource.Wallet
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
 * Routing the API address into Wallet Process
 * @author Simpli CLI generator
 */
@Path("/client/wallet")
@Produces(MediaType.APPLICATION_JSON)
class WalletRouter : RouterWrapper() {
    @GET
    @Path("/{id}")
    @Operation(tags = ["Wallet"], summary = "Gets a instance of a given ID of Wallet")
    fun getWallet(@BeanParam param: DefaultParam.RequiredPathId): Wallet {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            WalletProcess(context).get(param.id)
		}
    }

    @GET
    @Operation(tags = ["Wallet"], summary = "Lists the instances of Wallet")
    fun listWallet(@BeanParam param: AuthWalletListParam): PageCollection<Wallet> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            WalletProcess(context).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["Wallet"], summary = "Lists the instances of Wallet to export as a file")
    fun listExportWallet(@BeanParam param: AuthWalletListParam): PageCollection<Wallet> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) { context ->
            WalletProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["Wallet"], summary = "Persists a new instance of Wallet. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistWallet(@BeanParam param: DefaultParam.Auth, model: Wallet): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            WalletProcess(context).persist(model)
		}
    }
}
