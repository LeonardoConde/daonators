package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * GoneException
 * @author Simpli CLI generator
 */
open class GoneException(message: String? = null)
    : HttpException(message ?: "Gone", Response.Status.GONE)
