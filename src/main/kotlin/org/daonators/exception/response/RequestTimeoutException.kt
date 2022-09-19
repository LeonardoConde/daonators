package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * RequestTimeoutException
 * @author Simpli CLI generator
 */
open class RequestTimeoutException(message: String? = null)
    : HttpException(message ?: "Request Timeout", Response.Status.REQUEST_TIMEOUT)
