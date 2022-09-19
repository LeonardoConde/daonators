package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * BadGatewayException
 * @author Simpli CLI generator
 */
open class BadGatewayException(message: String? = null)
    : HttpException(message ?: "Bad Gateway", Response.Status.BAD_GATEWAY)
