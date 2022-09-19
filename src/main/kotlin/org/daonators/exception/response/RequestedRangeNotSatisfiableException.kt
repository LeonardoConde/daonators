package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * RequestedRangeNotSatisfiableException
 * @author Simpli CLI generator
 */
open class RequestedRangeNotSatisfiableException(message: String? = null)
    : HttpException(message ?: "Requested Range Not Satisfiable", Response.Status.REQUESTED_RANGE_NOT_SATISFIABLE)
