package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * ConflictException
 * @author Simpli CLI generator
 */
open class ConflictException(message: String? = null)
    : HttpException(message ?: "Conflict", Response.Status.CONFLICT)
