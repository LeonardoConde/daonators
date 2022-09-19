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
