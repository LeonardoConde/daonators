-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema daonators
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema daonators
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `daonators` DEFAULT CHARACTER SET utf8 ;
USE `daonators` ;

-- -----------------------------------------------------
-- Table `daonators`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(255) NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`user_wallet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`user_wallet` (
  `idUserWalletPk` INT NOT NULL AUTO_INCREMENT,
  `walletAddress` VARCHAR(34) NOT NULL,
  `idUserFk` INT NULL DEFAULT 0,
  PRIMARY KEY (`idUserWalletPk`),
  INDEX `fk_user_wallet_user1_idx` (`idUserFk` ASC) VISIBLE,
  CONSTRAINT `fk_user_wallet_user1`
    FOREIGN KEY (`idUserFk`)
    REFERENCES `daonators`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`campaing_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`campaing_type` (
  `idCampaingTypePk` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `active` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`idCampaingTypePk`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`campaing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`campaing` (
  `idCampaingPk` INT NOT NULL AUTO_INCREMENT,
  `idCampaingTypePk` INT NOT NULL,
  `beginDate` DATE NOT NULL,
  `endDate` DATE NULL,
  PRIMARY KEY (`idCampaingPk`),
  INDEX `fk_campaing_campaing_type1_idx` (`idCampaingTypePk` ASC) VISIBLE,
  CONSTRAINT `fk_campaing_campaing_type1`
    FOREIGN KEY (`idCampaingTypePk`)
    REFERENCES `daonators`.`campaing_type` (`idCampaingTypePk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`organization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`organization` (
  `idOrganizationPk` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `walletAddress` VARCHAR(34) NOT NULL,
  `active` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idOrganizationPk`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`campaing_organization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`campaing_organization` (
  `idCampaingFk` INT NOT NULL,
  `idOrganizationFk` INT NOT NULL,
  `transactionHash` VARCHAR(66) NULL,
  `gasAmount` DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (`idCampaingFk`, `idOrganizationFk`),
  INDEX `fk_campaing_has_organization_organization1_idx` (`idOrganizationFk` ASC) VISIBLE,
  INDEX `fk_campaing_has_organization_campaing1_idx` (`idCampaingFk` ASC) VISIBLE,
  CONSTRAINT `fk_campaing_has_organization_campaing1`
    FOREIGN KEY (`idCampaingFk`)
    REFERENCES `daonators`.`campaing` (`idCampaingPk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_campaing_has_organization_organization1`
    FOREIGN KEY (`idOrganizationFk`)
    REFERENCES `daonators`.`organization` (`idOrganizationPk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`vote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`vote` (
  `idVotePk` INT NOT NULL AUTO_INCREMENT,
  `lastUpdate` DATETIME NOT NULL,
  `tokensAmount` DOUBLE UNSIGNED NOT NULL DEFAULT 0,
  `idCampaingFk` INT NOT NULL,
  `idOrganizationFk` INT NOT NULL,
  `idUserWalletFk` INT NOT NULL,
  PRIMARY KEY (`idVotePk`),
  INDEX `fk_vote_campaing_organization1_idx` (`idCampaingFk` ASC, `idOrganizationFk` ASC) VISIBLE,
  INDEX `fk_vote_user_wallet1_idx` (`idUserWalletFk` ASC) VISIBLE,
  CONSTRAINT `fk_vote_campaing_organization1`
    FOREIGN KEY (`idCampaingFk` , `idOrganizationFk`)
    REFERENCES `daonators`.`campaing_organization` (`idCampaingFk` , `idOrganizationFk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vote_user_wallet1`
    FOREIGN KEY (`idUserWalletFk`)
    REFERENCES `daonators`.`user_wallet` (`idUserWalletPk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`organization_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`organization_type` (
  `idOrganizationTypePk` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `active` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idOrganizationTypePk`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`organization_type_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`organization_type_list` (
  `idOrganizationFk` INT NOT NULL,
  `idOrganizationTypeFk` INT NOT NULL,
  PRIMARY KEY (`idOrganizationFk`, `idOrganizationTypeFk`),
  INDEX `fk_organization_has_organization_type_organization_type1_idx` (`idOrganizationTypeFk` ASC) VISIBLE,
  INDEX `fk_organization_has_organization_type_organization1_idx` (`idOrganizationFk` ASC) VISIBLE,
  CONSTRAINT `fk_organization_has_organization_type_organization1`
    FOREIGN KEY (`idOrganizationFk`)
    REFERENCES `daonators`.`organization` (`idOrganizationPk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_organization_has_organization_type_organization_type1`
    FOREIGN KEY (`idOrganizationTypeFk`)
    REFERENCES `daonators`.`organization_type` (`idOrganizationTypePk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
