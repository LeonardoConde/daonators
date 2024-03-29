package org.daonators.app.healthcheck

import org.daonators.wrapper.RouterWrapper
import io.swagger.v3.oas.annotations.Operation
import javax.ws.rs.GET
import javax.ws.rs.Path

/**
 * Routing the API address into HealthCheck
 * @author Simpli CLI generator
 */
@Path(HealthCheckRouter.PATH)
class HealthCheckRouter : RouterWrapper() {
    companion object {
        const val PATH = "/healthcheck"
    }

    @GET
    @Operation(tags = ["HealthCheck"], summary = "Checks status of DB connection and coroutines")
    fun check(): Boolean {
        HealthCheckPipe.apply {
            return handle(readPipe) { con ->
                HealthCheckProcess(con).check()
            } &&
            handle(transactionPipe) { con ->
                HealthCheckProcess(con).check()
            }
        }
    }
}
