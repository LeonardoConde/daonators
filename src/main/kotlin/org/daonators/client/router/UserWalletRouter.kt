package org.daonators.client.router

import org.daonators.client.context.AuthPipe
import org.daonators.client.process.UserWalletProcess
import org.daonators.wrapper.RouterWrapper
import org.daonators.model.param.DefaultParam
import org.daonators.model.param.AuthUserWalletListParam
import org.daonators.model.resource.UserWallet
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
 * Routing the API address into UserWallet Process
 * @author Simpli CLI generator
 */
@Path("/client/user-wallet")
@Produces(MediaType.APPLICATION_JSON)
class UserWalletRouter : RouterWrapper() {
    @GET
    @Path("/{id}")
    @Operation(tags = ["UserWallet"], summary = "Gets a instance of a given ID of UserWallet")
    fun getUserWallet(@BeanParam param: DefaultParam.RequiredPathId): UserWallet {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) {
            UserWalletProcess(it).get(param.id)
		}
    }

    @GET
    @Operation(tags = ["UserWallet"], summary = "Lists the instances of UserWallet")
    fun listUserWallet(@BeanParam param: AuthUserWalletListParam): PageCollection<UserWallet> {
        // TODO: review generated method
        return PublicPipe.handle(readPipe, param) {
            UserWalletProcess(it).list(param)
		}
    }

    @GET
    @Path("/export")
    @Operation(tags = ["UserWallet"], summary = "Lists the instances of UserWallet to export as a file")
    fun listExportUserWallet(@BeanParam param: AuthUserWalletListParam): PageCollection<UserWallet> {
        // TODO: review generated method
        return AuthPipe.handle(readPipe, param) { context, _ ->
            UserWalletProcess(context).list(param)
		}
    }

    @POST
    @Operation(tags = ["UserWallet"], summary = "Persists a new instance of UserWallet. Use ID = 0 to create a new one, or ID > 0 to update a current one")
    fun persistUserWallet(@BeanParam param: DefaultParam.Auth, model: UserWallet): Long {
        // TODO: review generated method
        return AuthPipe.handle(transactionPipe, param) { context, _ ->
            UserWalletProcess(context).persist(model)
		}
    }
}
