package org.daonators.app.env

import org.daonators.enums.Lang
import org.daonators.enums.Mode
import org.daonators.locale.EnUs
import org.daonators.locale.PtBr
import com.amazonaws.regions.Regions

/**
 * Environment Variables - Base
 * @author Simpli CLI generator
 */
abstract class Props(val MODE: Mode) {
    /**
     * Database DS name
     * Do not change it unless you know what you are doing
     */
    val DS_NAME = "jdbc/daonatorsDS"

    /**
     * Default Web Application Origin
     */
    abstract val APP_DEFAULT_ORIGIN: String

    /**
     * Available Languages
     */
    val AVAILABLE_LANGUAGES = hashMapOf(
        Lang.EN_US to EnUs(),
        Lang.PT_BR to PtBr()
    )

    /**
     * E-Mail server information
     * Go to AwsCredentials.properties to set your AWS credentials
     */
    val EMAIL_SENDER_PROVIDER = "no-reply@daonators.org"
    val EMAIL_AWS_REGION = Regions.US_EAST_1

    /**
     * Forgotten password token expiration time in days
     * @default 15 days
     */
    val FORGOTTEN_PASSWORD_TOKEN_LIFE = 15

    /**
     * Set the DATE_FORMAT if you know what you are doing
     * @default yyyy-MM-dd'T'HH:mm:ssXXX
     */
    val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX"

    /**
     * Hash to transform data into token
     * @warning DO NOT SHARE this hash in order to keep your project safe
     * Your are able to change it whenever you want, but all clients must login again
     */
    val ENCRYPT_HASH = "5f336f65-0f0a-477d-b037-474b032c10d5"

    /**
     * Credentials used in Unit Test
     * The Unit Test always happens in localhost
     * Not recommended to change these values
     */
    val TESTER_DATABASE = "daonators"
    val TESTER_ID = 1L
    val TESTER_LOGIN = "test@test.com"
    val TESTER_PASSWORD = "tester"
}
