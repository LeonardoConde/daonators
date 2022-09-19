package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * ExpectationFailedException
 * @author Simpli CLI generator
 */
open class ExpectationFailedException(message: String? = null)
    : HttpException(message ?: "Expectation Failed", Response.Status.EXPECTATION_FAILED)
