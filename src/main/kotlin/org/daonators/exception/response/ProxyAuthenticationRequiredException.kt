package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * ProxyAuthenticationRequiredException
 * @author Simpli CLI generator
 */
open class ProxyAuthenticationRequiredException(message: String? = null)
    : HttpException(message ?: "Proxy Authentication Required", Response.Status.PROXY_AUTHENTICATION_REQUIRED)
