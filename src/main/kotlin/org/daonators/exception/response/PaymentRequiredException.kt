package org.daonators.exception.response

import org.daonators.exception.HttpException
import javax.ws.rs.core.Response

/**
 * PaymentRequiredException
 * @author Simpli CLI generator
 */
open class PaymentRequiredException(message: String? = null)
    : HttpException(message ?: "Payment Required", Response.Status.PAYMENT_REQUIRED)
