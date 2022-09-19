package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * GatewayTimeoutException
 * @author Simpli CLI generator
 */
open class GatewayTimeoutException(message: String? = null)
    : HttpException(message ?: "Gateway Timeout", Response.Status.GATEWAY_TIMEOUT)
