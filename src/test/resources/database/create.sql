SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `daonators`;

CREATE SCHEMA IF NOT EXISTS `daonators` DEFAULT CHARACTER SET utf8mb4 ;
USE `daonators`;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: campaing
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `campaing` (
  `idCampaingPk` int NOT NULL AUTO_INCREMENT,
  `idCampaingTypePk` int NOT NULL,
  `beginDate` date NOT NULL,
  `endDate` date DEFAULT NULL,
  PRIMARY KEY (`idCampaingPk`),
  KEY `fk_campaing_campaing_type1_idx` (`idCampaingTypePk`),
  CONSTRAINT `fk_campaing_campaing_type1` FOREIGN KEY (`idCampaingTypePk`) REFERENCES `campaing_type` (`idCampaingTypePk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: campaing_organization
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `campaing_organization` (
  `idCampaingFk` int NOT NULL,
  `idOrganizationFk` int NOT NULL,
  `transactionHash` varchar(66) DEFAULT NULL,
  `gasAmount` double DEFAULT '0',
  PRIMARY KEY (`idCampaingFk`, `idOrganizationFk`),
  KEY `fk_campaing_has_organization_organization1_idx` (`idOrganizationFk`),
  KEY `fk_campaing_has_organization_campaing1_idx` (`idCampaingFk`),
  CONSTRAINT `fk_campaing_has_organization_campaing1` FOREIGN KEY (`idCampaingFk`) REFERENCES `campaing` (`idCampaingPk`),
  CONSTRAINT `fk_campaing_has_organization_organization1` FOREIGN KEY (`idOrganizationFk`) REFERENCES `organization` (`idOrganizationPk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: campaing_type
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `campaing_type` (
  `idCampaingTypePk` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idCampaingTypePk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: organization
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `organization` (
  `idOrganizationPk` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `walletAddress` varchar(34) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idOrganizationPk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: organization_type
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `organization_type` (
  `idOrganizationTypePk` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`idOrganizationTypePk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: organization_type_list
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `organization_type_list` (
  `idOrganizationFk` int NOT NULL,
  `idOrganizationTypeFk` int NOT NULL,
  PRIMARY KEY (`idOrganizationFk`, `idOrganizationTypeFk`),
  KEY `fk_organization_has_organization_type_organization_type1_idx` (`idOrganizationTypeFk`),
  KEY `fk_organization_has_organization_type_organization1_idx` (`idOrganizationFk`),
  CONSTRAINT `fk_organization_has_organization_type_organization1` FOREIGN KEY (`idOrganizationFk`) REFERENCES `organization` (`idOrganizationPk`),
  CONSTRAINT `fk_organization_has_organization_type_organization_type1` FOREIGN KEY (`idOrganizationTypeFk`) REFERENCES `organization_type` (`idOrganizationTypePk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: user
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: user_wallet
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `user_wallet` (
  `idUserWalletPk` int NOT NULL AUTO_INCREMENT,
  `walletAddress` varchar(34) NOT NULL,
  `idUserFk` int DEFAULT '0',
  PRIMARY KEY (`idUserWalletPk`),
  KEY `fk_user_wallet_user1_idx` (`idUserFk`),
  CONSTRAINT `fk_user_wallet_user1` FOREIGN KEY (`idUserFk`) REFERENCES `user` (`idUser`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------------------------
# SCHEMA DUMP FOR TABLE: vote
# ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `vote` (
  `idVotePk` int NOT NULL AUTO_INCREMENT,
  `lastUpdate` datetime NOT NULL,
  `tokensAmount` double unsigned NOT NULL DEFAULT '0',
  `idCampaingFk` int NOT NULL,
  `idOrganizationFk` int NOT NULL,
  `idUserWalletFk` int NOT NULL,
  PRIMARY KEY (`idVotePk`),
  KEY `fk_vote_campaing_organization1_idx` (`idCampaingFk`, `idOrganizationFk`),
  KEY `fk_vote_user_wallet1_idx` (`idUserWalletFk`),
  CONSTRAINT `fk_vote_campaing_organization1` FOREIGN KEY (`idCampaingFk`, `idOrganizationFk`) REFERENCES `campaing_organization` (`idCampaingFk`, `idOrganizationFk`),
  CONSTRAINT `fk_vote_user_wallet1` FOREIGN KEY (`idUserWalletFk`) REFERENCES `user_wallet` (`idUserWalletPk`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
