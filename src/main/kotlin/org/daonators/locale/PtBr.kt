package org.daonators.locale

import br.com.simpli.model.PortugueseLanguage

/**
 * Brazilian Portuguese language
 * @author Simpli CLI generator
 */
class PtBr : PortugueseLanguage() {
    init {
        dictionary = hashMapOf(
                "email_sender_name" to "Equipe Usecase",
                "email_contact" to "contact@usecase.org",

                "email_reset_password_subject" to "Esqueci minha senha",
                "email_reset_password_title" to "Esqueci minha senha",
                "email_reset_password_subtitle" to "As vezes isso pode acontecer. Não tem problema!",
                "email_reset_password_body" to "",
                "email_reset_password_text_button" to "Se você solicitou o esqueci senha, clique no botão abaixo para criar uma nova.",
                "email_reset_password_label_button" to "Criar nova senha",

                "access_denied" to "Acesso Negado",
                "already_exists" to "Não é possível criar um item já existente",
                "does_not_exist" to "Não é possível editar um item não existente",
                "invalid_token" to "Token Inválido",
                "user_id_not_found" to "ID do Usuário Não Encontrado",
                "user_not_found" to "Usuário Não Encontrado",
                "wrong_password" to "Senha inválida",
                "password_no_match" to "Os campos senha precisam ser iguais",
                "something_went_wrong" to "Algo saiu errado. Contate o admin!",

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
                "UserWallet.walletAddress" to "Wallet Address",

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
