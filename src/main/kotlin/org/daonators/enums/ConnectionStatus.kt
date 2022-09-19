package org.daonators.enums

/**
 * ConnectionStatus enum
 * Represents the connection status of application
 * @author Simpli CLI generator
 */
enum class ConnectionStatus {
    ESTABLISHED, LOST;

    override fun toString(): String {
        return super.name.toLowerCase()
    }
}
