-- MySQL Workbench Forward Engineering

SET
@OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET
@OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET
@OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema daonators
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema daonators
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `daonators` DEFAULT CHARACTER SET utf8;
USE
`daonators` ;

-- -----------------------------------------------------
-- Table `daonators`.`user_wallet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`user_wallet`
(
    `idUserWalletPk`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `walletAddress`
    VARCHAR
(
    34
) NOT NULL,
    PRIMARY KEY
(
    `idUserWalletPk`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`organization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`organization`
(
    `idOrganizationPk`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `name`
    VARCHAR
(
    45
) NOT NULL,
    `scriptHash` VARCHAR
(
    42
) NOT NULL,
    `active` TINYINT
(
    1
) NOT NULL DEFAULT 1,
    PRIMARY KEY
(
    `idOrganizationPk`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`campaing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`campaing`
(
    `idCampaingPk`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `name`
    VARCHAR
(
    45
) NULL,
    `socialCause` VARCHAR
(
    255
) NOT NULL,
    `beginDate` DATE NOT NULL,
    `endDate` DATE NOT NULL,
    PRIMARY KEY
(
    `idCampaingPk`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`voting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`voting`
(
    `idVotingPk`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `idOrganizationfk`
    INT
    NOT
    NULL,
    `idCampaingFk`
    INT
    NULL,
    `idVotingTypeFk`
    INT
    NOT
    NULL,
    PRIMARY
    KEY
(
    `idVotingPk`,
    `idOrganizationfk`
),
    INDEX `fk_voting_organization1_idx`
(
    `idOrganizationfk` ASC
) VISIBLE,
    INDEX `fk_voting_campaing1_idx`
(
    `idCampaingFk` ASC
) VISIBLE,
    INDEX `fk_voting_voting_type1_idx`
(
    `idVotingTypeFk` ASC
) VISIBLE,
    UNIQUE INDEX `idCampaingFk_UNIQUE`
(
    `idCampaingFk` ASC
) VISIBLE,
    CONSTRAINT `fk_voting_organization1`
    FOREIGN KEY
(
    `idOrganizationfk`
)
    REFERENCES `daonators`.`organization`
(
    `idOrganizationPk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_voting_campaing1`
    FOREIGN KEY
(
    `idCampaingFk`
)
    REFERENCES `daonators`.`campaing`
(
    `idCampaingPk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_voting_voting_type1`
    FOREIGN KEY
(
    `idVotingTypeFk`
)
    REFERENCES `daonators`.`voting_type`
(
    `idVotingTypePk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`donation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`donation`
(
    `idDonationPk`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `idCampaingFk`
    INT
    NOT
    NULL,
    `idOrganizationFk`
    INT
    NOT
    NULL,
    `gasAmount`
    DOUBLE
    NOT
    NULL,
    `transactionHash`
    VARCHAR
(
    66
) NOT NULL,
    PRIMARY KEY
(
    `idDonationPk`,
    `idCampaingFk`,
    `idOrganizationFk`
),
    INDEX `fk_donation_campaing1_idx`
(
    `idCampaingFk` ASC
) VISIBLE,
    INDEX `fk_donation_organization1_idx`
(
    `idOrganizationFk` ASC
) VISIBLE,
    CONSTRAINT `fk_donation_campaing1`
    FOREIGN KEY
(
    `idCampaingFk`
)
    REFERENCES `daonators`.`campaing`
(
    `idCampaingPk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_donation_organization1`
    FOREIGN KEY
(
    `idOrganizationFk`
)
    REFERENCES `daonators`.`organization`
(
    `idOrganizationPk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`wallet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`wallet`
(
    `idWalletPk`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `wallet`
    VARCHAR
(
    45
) NULL,
    PRIMARY KEY
(
    `idWalletPk`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`campaing_organization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`campaing_organization`
(
    `idOrganizationPk`
    INT
    NOT
    NULL,
    `idCampaingPk`
    INT
    NOT
    NULL,
    PRIMARY
    KEY
(
    `idOrganizationPk`,
    `idCampaingPk`
),
    INDEX `fk_organization_has_campaing_campaing1_idx`
(
    `idCampaingPk` ASC
) VISIBLE,
    INDEX `fk_organization_has_campaing_organization_idx`
(
    `idOrganizationPk` ASC
) VISIBLE,
    CONSTRAINT `fk_organization_has_campaing_organization`
    FOREIGN KEY
(
    `idOrganizationPk`
)
    REFERENCES `daonators`.`organization`
(
    `idOrganizationPk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_organization_has_campaing_campaing1`
    FOREIGN KEY
(
    `idCampaingPk`
)
    REFERENCES `daonators`.`campaing`
(
    `idCampaingPk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`voting_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`voting_type`
(
    `idVotingTypePk`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `name`
    VARCHAR
(
    45
) NOT NULL,
    `active` TINYINT
(
    1
) NOT NULL DEFAULT 0,
    PRIMARY KEY
(
    `idVotingTypePk`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`voting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`voting`
(
    `idVotingPk`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `idOrganizationfk`
    INT
    NOT
    NULL,
    `idCampaingFk`
    INT
    NULL,
    `idVotingTypeFk`
    INT
    NOT
    NULL,
    PRIMARY
    KEY
(
    `idVotingPk`,
    `idOrganizationfk`
),
    INDEX `fk_voting_organization1_idx`
(
    `idOrganizationfk` ASC
) VISIBLE,
    INDEX `fk_voting_campaing1_idx`
(
    `idCampaingFk` ASC
) VISIBLE,
    INDEX `fk_voting_voting_type1_idx`
(
    `idVotingTypeFk` ASC
) VISIBLE,
    UNIQUE INDEX `idCampaingFk_UNIQUE`
(
    `idCampaingFk` ASC
) VISIBLE,
    CONSTRAINT `fk_voting_organization1`
    FOREIGN KEY
(
    `idOrganizationfk`
)
    REFERENCES `daonators`.`organization`
(
    `idOrganizationPk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_voting_campaing1`
    FOREIGN KEY
(
    `idCampaingFk`
)
    REFERENCES `daonators`.`campaing`
(
    `idCampaingPk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_voting_voting_type1`
    FOREIGN KEY
(
    `idVotingTypeFk`
)
    REFERENCES `daonators`.`voting_type`
(
    `idVotingTypePk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daonators`.`vote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`vote`
(
    `idVotingFk`
    INT
    NOT
    NULL,
    `idUserWalletFk`
    INT
    NOT
    NULL,
    `tokenAmount`
    DOUBLE
    NOT
    NULL
    DEFAULT
    0,
    PRIMARY
    KEY
(
    `idVotingFk`,
    `idUserWalletFk`
),
    INDEX `fk_voting_has_user_wallet_user_wallet1_idx`
(
    `idUserWalletFk` ASC
) VISIBLE,
    INDEX `fk_voting_has_user_wallet_voting1_idx`
(
    `idVotingFk` ASC
) VISIBLE,
    CONSTRAINT `fk_voting_has_user_wallet_voting1`
    FOREIGN KEY
(
    `idVotingFk`
)
    REFERENCES `daonators`.`voting`
(
    `idVotingPk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_voting_has_user_wallet_user_wallet1`
    FOREIGN KEY
(
    `idUserWalletFk`
)
    REFERENCES `daonators`.`user_wallet`
(
    `idUserWalletPk`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `daonators`.`authAdm`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `daonators`.`authAdm`
(
    `idAuthAdmPk`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `name`
    VARCHAR
(
    45
) NOT NULL,
    `email` VARCHAR
(
    45
) NOT NULL,
    `password` VARCHAR
(
    255
) NOT NULL,
    PRIMARY KEY
(
    `idAuthAdmPk`
))
    ENGINE = InnoDB;


SET
SQL_MODE=@OLD_SQL_MODE;
SET
FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET
UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
