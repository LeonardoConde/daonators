package org.daonators.locale

import br.com.simpli.model.EnglishLanguage

/**
 * USA English language
 * @author Simpli CLI generator
 */
class EnUs : EnglishLanguage() {
    init {
        dictionary = hashMapOf(
                "email_sender_name" to "Usecase staff",
                "email_contact" to "contact@usecase.org",

                "email_reset_password_subject" to "Forgot my password",
                "email_reset_password_title" to "Forgot my password",
                "email_reset_password_subtitle" to "It happens. Do not worry!",
                "email_reset_password_body" to "",
                "email_reset_password_text_button" to "If you have solicited to change the password, click in the button below in order to create a new one.",
                "email_reset_password_label_button" to "Create new password",

                "access_denied" to "Access Denied",
                "already_exists" to "It is not possible to create an already existing item",
                "does_not_exist" to "It is not possible to edit a non-existing item",
                "invalid_token" to "Invalid Token",
                "user_id_not_found" to "UserRouter ID Not Found",
                "user_not_found" to "UserRouter Not Found",
                "wrong_password" to "Wrong password",
                "password_no_match" to "The field password must match",
                "something_went_wrong" to "Something wend wrong. Contact the admin!",

                /**
                 * Campaing
                 */
                "Campaing.idCampaingPk" to "Id Campaing Pk",
                "Campaing.idCampaingTypePk" to "Id Campaing Type Pk",
                "Campaing.beginDate" to "Begin Date",
                "Campaing.endDate" to "End Date",

                /**
                 * CampaingOrganization
                 */
                "CampaingOrganization.idCampaingFk" to "Id Campaing Fk",
                "CampaingOrganization.idOrganizationFk" to "Id Organization Fk",
                "CampaingOrganization.transactionHash" to "Transaction Hash",
                "CampaingOrganization.gasAmount" to "Gas Amount",

                /**
                 * CampaingType
                 */
                "CampaingType.idCampaingTypePk" to "Id Campaing Type Pk",
                "CampaingType.name" to "Name",
                "CampaingType.active" to "Active",

                /**
                 * Organization
                 */
                "Organization.idOrganizationPk" to "Id Organization Pk",
                "Organization.name" to "Name",
                "Organization.walletAddress" to "Wallet Address",
                "Organization.active" to "Active",

                /**
                 * OrganizationType
                 */
                "OrganizationType.idOrganizationTypePk" to "Id Organization Type Pk",
                "OrganizationType.name" to "Name",
                "OrganizationType.active" to "Active",

                /**
                 * OrganizationTypeList
                 */
                "OrganizationTypeList.idOrganizationFk" to "Id Organization Fk",
                "OrganizationTypeList.idOrganizationTypeFk" to "Id Organization Type Fk",

                /**
                 * User
                 */
                "User.idUser" to "Id User",
                "User.name" to "Name",
                "User.email" to "Email",
                "User.password" to "Password",

                /**
                 * UserWallet
                 */
                "UserWallet.idUserWalletPk" to "Id User Wallet Pk",
                "UserWallet.walletAddress" to "Wallet Address",
                "UserWallet.idUserFk" to "Id User Fk",

                /**
                 * Vote
                 */
                "Vote.idVotePk" to "Id Vote Pk",
                "Vote.lastUpdate" to "Last Update",
                "Vote.tokensAmount" to "Tokens Amount",
                "Vote.idCampaingFk" to "Id Campaing Fk",
                "Vote.idOrganizationFk" to "Id Organization Fk",
                "Vote.idUserWalletFk" to "Id User Wallet Fk"
        )
    }
}
