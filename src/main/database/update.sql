-- -----------------------------------------------------
-- CU-34gr0a7 - Adicionar tipos de campanhas no bd
-- -----------------------------------------------------

-- trocado de campanha para votação na reestruturação

INSERT INTO `daonators`.`voting_type` (`idVotingTypePk`, `name`, `active`) VALUES ('1', 'Doação', '1');
INSERT INTO `daonators`.`voting_type` (`idVotingTypePk`, `name`, `active`) VALUES ('2', 'Adição', '1');
INSERT INTO `daonators`.`voting_type` (`idVotingTypePk`, `name`, `active`) VALUES ('3', 'Remoção', '1');
