package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * RequestEntityToLargeException
 * @author Simpli CLI generator
 */
open class RequestEntityToLargeException(message: String? = null)
    : HttpException(message ?: "Request Entity To Large", Response.Status.REQUEST_ENTITY_TOO_LARGE)
