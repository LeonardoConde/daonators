package org.daonators.app.env

import org.daonators.enums.Mode

/**
 * Environment Variables - Production
 * @author Simpli CLI generator
 */
class PropsProduction : Props(Mode.PRODUCTION) {
    override val APP_DEFAULT_ORIGIN = "http://localhost:8181"
}
