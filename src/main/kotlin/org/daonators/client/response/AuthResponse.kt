package org.daonators.client.response

import org.daonators.model.resource.AuthAdm
import org.daonators.client.socket.NotificationSocket
import io.swagger.v3.oas.annotations.media.Schema

/**
 * Authentication Response Model
 * @author Simpli CLI generator
 */
class AuthResponse(var token: String, var authAdm: AuthAdm) {
    val id @Schema(hidden = true) get() = authAdm.id
    val email @Schema(hidden = true) get() = authAdm.email

    @Schema(hidden = true)
    fun sendNotification(content: String) {
        NotificationSocket.socket.send(content, id)
    }
}
