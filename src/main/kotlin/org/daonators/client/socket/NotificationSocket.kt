package org.daonators.client.socket

import org.daonators.client.context.AuthPipe
import org.daonators.enums.ConnectionStatus
import org.daonators.extension.jsonProperties
import org.daonators.model.param.DefaultParam
import org.daonators.wrapper.RouterWrapper
import org.daonators.wrapper.SocketWrapper
import javax.websocket.OnClose
import javax.websocket.OnError
import javax.websocket.OnOpen
import javax.websocket.Session
import javax.websocket.server.PathParam
import javax.websocket.server.ServerEndpoint
import org.apache.logging.log4j.LogManager

/**
 * Notification Web Socket
 * The generic two-way (bi-directional) ongoing conversation between the client and the server
 * @author Simpli CLI generator
 */
@ServerEndpoint("/ws/client/notification/{token}")
class NotificationSocket: RouterWrapper() {
    companion object {
        val socket = SocketWrapper<String>()

        private val logger = LogManager.getLogger(NotificationSocket::class.java)
    }

    @OnOpen
    fun onConnect(session: Session, @PathParam("token") token: String) {
        val param = DefaultParam.Auth()

        param.lang = "en-US"
        param.clientVersion = "ws.auth"
        param.authorization = """Bearer $token"""

        AuthPipe.handle(connectionPipe, param) { _, auth ->
            session.userProperties["token"] = auth.token
            session.userProperties["email"] = auth.email

            socket.attachSession(session, auth.id)
        }

        logger.debug(session.jsonProperties(ConnectionStatus.ESTABLISHED))
    }

    @OnClose
    fun onDisconnect(session: Session) {
        socket.detachSession(session)

        logger.debug(session.jsonProperties(ConnectionStatus.LOST))
    }

    @OnError
    fun onError(e: Throwable) {
        toResponse(e)
    }
}
