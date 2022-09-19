package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * NotImplementedException
 * @author Simpli CLI generator
 */
open class NotImplementedException(message: String? = null)
    : HttpException(message ?: "Not Implemented", Response.Status.NOT_IMPLEMENTED)
