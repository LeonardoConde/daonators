package org.daonators.app

import org.daonators.app.env.Props
import org.daonators.app.env.PropsBeta
import org.daonators.app.env.PropsProduction
import org.daonators.app.env.PropsStaging
import org.daonators.enums.Mode
import org.apache.logging.log4j.LogManager

/**
 * Facade
 * @author Simpli CLI generator
 */
object Facade {
    private val logger = LogManager.getLogger(Facade::class.java)

    /**
     * Enviroment mode: BETA, STAGING or PRODUCTION
     */
    @JvmStatic val Env: Props

    init {
        val mode = Mode.fromString(System.getProperty("ENVIRONMENT")) ?: Mode.BETA.also {
            logger.warn("System property not found for ENVIRONMENT. Using Mode.BETA as default")
        }

        Env = when (mode) {
            Mode.PRODUCTION -> PropsProduction()
            Mode.STAGING -> PropsStaging()
            Mode.BETA -> PropsBeta()
        }
    }
}
