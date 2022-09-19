package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * MethodNotAllowedException
 * @author Simpli CLI generator
 */
open class MethodNotAllowedException(message: String? = null)
    : HttpException(message ?: "Method Not Allowed", Response.Status.METHOD_NOT_ALLOWED)
