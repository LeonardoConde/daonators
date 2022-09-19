package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * NotFoundException
 * @author Simpli CLI generator
 */
open class NotFoundException(message: String? = null)
    : HttpException(message ?: "Not Found", Response.Status.NOT_FOUND)
