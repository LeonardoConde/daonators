package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * ServiceUnavailableException
 * @author Simpli CLI generator
 */
open class ServiceUnavailableException(message: String? = null)
    : HttpException(message ?: "Service Unavailable", Response.Status.SERVICE_UNAVAILABLE)
