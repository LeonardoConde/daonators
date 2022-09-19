package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * PreconditionFailedException
 * @author Simpli CLI generator
 */
open class PreconditionFailedException(message: String? = null)
    : HttpException(message ?: "Precondition Failed", Response.Status.PRECONDITION_FAILED)
