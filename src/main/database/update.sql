-- -----------------------------------------------------
-- CU-34gr0a7 - Adicionar tipos de campanhas no bd
-- -----------------------------------------------------
INSERT INTO `daonators`.`campaing_type` (`idCampaingTypePk`, `name`, `active`) VALUES ('1', 'Donate', '1');
INSERT INTO `daonators`.`campaing_type` (`idCampaingTypePk`, `name`, `active`) VALUES ('2', 'Add', '1');
INSERT INTO `daonators`.`campaing_type` (`idCampaingTypePk`, `name`, `active`) VALUES ('3', 'Remove', '1');

-- -----------------------------------------------------
-- CU-36v6nqu - criar nome para as votações
-- -----------------------------------------------------

ALTER TABLE `daonators`.`campaing` ADD COLUMN `name` VARCHAR(45) NOT NULL AFTER `idCampaingTypePk`;