package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * HttpVersionNotSupportedException
 * @author Simpli CLI generator
 */
open class HttpVersionNotSupportedException(message: String? = null)
    : HttpException(message ?: "HTTP Version Not Supported", Response.Status.HTTP_VERSION_NOT_SUPPORTED)
