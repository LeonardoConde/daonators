SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `daonators`;

CREATE SCHEMA IF NOT EXISTS `daonators` DEFAULT CHARACTER SET utf8mb4 ;
USE `daonators`;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: auth_adm
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `auth_adm` (
  `idAuthAdmPk` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`idAuthAdmPk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: campaing
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `campaing` (
  `idCampaingPk` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `socialCause` varchar(255) NOT NULL,
  `beginDate` date NOT NULL,
  `endDate` date NOT NULL,
  PRIMARY KEY (`idCampaingPk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: campaing_organization
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `campaing_organization` (
  `idOrganizationPk` int NOT NULL,
  `idCampaingPk` int NOT NULL,
  PRIMARY KEY (`idOrganizationPk`, `idCampaingPk`),
  KEY `fk_organization_has_campaing_campaing1_idx` (`idCampaingPk`),
  KEY `fk_organization_has_campaing_organization_idx` (`idOrganizationPk`),
  CONSTRAINT `fk_organization_has_campaing_campaing1` FOREIGN KEY (`idCampaingPk`) REFERENCES `campaing` (`idCampaingPk`),
  CONSTRAINT `fk_organization_has_campaing_organization` FOREIGN KEY (`idOrganizationPk`) REFERENCES `organization` (`idOrganizationPk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: donation
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `donation` (
  `idDonationPk` int NOT NULL AUTO_INCREMENT,
  `idCampaingFk` int NOT NULL,
  `idOrganizationFk` int NOT NULL,
  `gasAmount` double NOT NULL,
  `transactionHash` varchar(66) NOT NULL,
  PRIMARY KEY (`idDonationPk`, `idCampaingFk`, `idOrganizationFk`),
  KEY `fk_donation_campaing1_idx` (`idCampaingFk`),
  KEY `fk_donation_organization1_idx` (`idOrganizationFk`),
  CONSTRAINT `fk_donation_campaing1` FOREIGN KEY (`idCampaingFk`) REFERENCES `campaing` (`idCampaingPk`),
  CONSTRAINT `fk_donation_organization1` FOREIGN KEY (`idOrganizationFk`) REFERENCES `organization` (`idOrganizationPk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: organization
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `organization` (
  `idOrganizationPk` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `scriptHash` varchar(42) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idOrganizationPk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: user_wallet
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `user_wallet` (
  `idUserWalletPk` int NOT NULL AUTO_INCREMENT,
  `walletAdress` varchar(34) NOT NULL,
  PRIMARY KEY (`idUserWalletPk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: vote
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `vote` (
  `idVotingFk` int NOT NULL,
  `idUserWalletFk` int NOT NULL,
  `tokenAmount` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`idVotingFk`, `idUserWalletFk`),
  KEY `fk_voting_has_user_wallet_user_wallet1_idx` (`idUserWalletFk`),
  KEY `fk_voting_has_user_wallet_voting1_idx` (`idVotingFk`),
  CONSTRAINT `fk_voting_has_user_wallet_user_wallet1` FOREIGN KEY (`idUserWalletFk`) REFERENCES `user_wallet` (`idUserWalletPk`),
  CONSTRAINT `fk_voting_has_user_wallet_voting1` FOREIGN KEY (`idVotingFk`) REFERENCES `voting` (`idVotingPk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: voting
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `voting` (
  `idVotingPk` int NOT NULL AUTO_INCREMENT,
  `idOrganizationfk` int NOT NULL,
  `idCampaingFk` int DEFAULT NULL,
  `idVotingTypeFk` int NOT NULL,
  PRIMARY KEY (`idVotingPk`, `idOrganizationfk`),
  UNIQUE KEY `idCampaingFk_UNIQUE` (`idCampaingFk`),
  KEY `fk_voting_organization1_idx` (`idOrganizationfk`),
  KEY `fk_voting_campaing1_idx` (`idCampaingFk`),
  KEY `fk_voting_voting_type1_idx` (`idVotingTypeFk`),
  CONSTRAINT `fk_voting_campaing1` FOREIGN KEY (`idCampaingFk`) REFERENCES `campaing` (`idCampaingPk`),
  CONSTRAINT `fk_voting_organization1` FOREIGN KEY (`idOrganizationfk`) REFERENCES `organization` (`idOrganizationPk`),
  CONSTRAINT `fk_voting_voting_type1` FOREIGN KEY (`idVotingTypeFk`) REFERENCES `voting_type` (`idVotingTypePk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: voting_type
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `voting_type` (
  `idVotingTypePk` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idVotingTypePk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: wallet
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `wallet` (
  `idWalletPk` int NOT NULL AUTO_INCREMENT,
  `wallet` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idWalletPk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
