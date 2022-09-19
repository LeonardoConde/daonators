package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * UnsupportedMediaTypeException
 * @author Simpli CLI generator
 */
open class UnsupportedMediaTypeException(message: String? = null)
    : HttpException(message ?: "Unsupported Media Type", Response.Status.UNSUPPORTED_MEDIA_TYPE)
