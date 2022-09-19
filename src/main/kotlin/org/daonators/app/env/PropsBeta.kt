package org.daonators.app.env

import org.daonators.enums.Mode

/**
 * Environment Variables - Beta
 * @author Simpli CLI generator
 */
class PropsBeta : Props(Mode.BETA) {
    override val APP_DEFAULT_ORIGIN = "http://localhost:8181"
}
