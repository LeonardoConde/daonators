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
                 * AuthAdm
                 */
                "AuthAdm.idAuthAdmPk" to "Id Auth Adm Pk",
                "AuthAdm.name" to "Name",
                "AuthAdm.email" to "Email",
                "AuthAdm.password" to "Password",

                /**
                 * Campaing
                 */
                "Campaing.idCampaingPk" to "Id Campaing Pk",
                "Campaing.name" to "Name",
                "Campaing.socialCause" to "Social Cause",
                "Campaing.beginDate" to "Begin Date",
                "Campaing.endDate" to "End Date",

                /**
                 * CampaingOrganization
                 */
                "CampaingOrganization.idOrganizationPk" to "Id Organization Pk",
                "CampaingOrganization.idCampaingPk" to "Id Campaing Pk",

                /**
                 * Donation
                 */
                "Donation.idDonationPk" to "Id Donation Pk",
                "Donation.idCampaingFk" to "Id Campaing Fk",
                "Donation.idOrganizationFk" to "Id Organization Fk",
                "Donation.gasAmount" to "Gas Amount",
                "Donation.transactionHash" to "Transaction Hash",

                /**
                 * Organization
                 */
                "Organization.idOrganizationPk" to "Id Organization Pk",
                "Organization.name" to "Name",
                "Organization.scriptHash" to "Script Hash",
                "Organization.active" to "Active",

                /**
                 * UserWallet
                 */
                "UserWallet.idUserWalletPk" to "Id User Wallet Pk",
                "UserWallet.walletAdress" to "Wallet Adress",

                /**
                 * Vote
                 */
                "Vote.idVotingFk" to "Id Voting Fk",
                "Vote.idUserWalletFk" to "Id User Wallet Fk",
                "Vote.tokenAmount" to "Token Amount",

                /**
                 * Voting
                 */
                "Voting.idVotingPk" to "Id Voting Pk",
                "Voting.idOrganizationfk" to "Id Organizationfk",
                "Voting.idCampaingFk" to "Id Campaing Fk",
                "Voting.idVotingTypeFk" to "Id Voting Type Fk",

                /**
                 * VotingType
                 */
                "VotingType.idVotingTypePk" to "Id Voting Type Pk",
                "VotingType.name" to "Name",
                "VotingType.active" to "Active",

                /**
                 * Wallet
                 */
                "Wallet.idWalletPk" to "Id Wallet Pk",
                "Wallet.wallet" to "Wallet"
        )
    }
}
