SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

USE `daonators`;

TRUNCATE TABLE `daonators`.`campaing`;
TRUNCATE TABLE `daonators`.`campaing_organization`;
TRUNCATE TABLE `daonators`.`campaing_type`;
TRUNCATE TABLE `daonators`.`organization`;
TRUNCATE TABLE `daonators`.`organization_type`;
TRUNCATE TABLE `daonators`.`organization_type_list`;
TRUNCATE TABLE `daonators`.`user`;
TRUNCATE TABLE `daonators`.`user_wallet`;
TRUNCATE TABLE `daonators`.`vote`;

LOCK TABLES `daonators`.`campaing` WRITE;

INSERT INTO `daonators`.`campaing`
(`idCampaingPk`,`idCampaingTypePk`,`beginDate`,`endDate`)
VALUES
(1,1,'2022-06-19 05:40:02.423','2022-02-16 10:17:25.023'),
(2,36,'2022-03-21 20:59:27.350','2022-08-31 17:27:15.918'),
(3,20,'2021-11-04 14:25:17.544','2022-08-27 18:22:04.000'),
(4,5,'2021-11-05 12:33:10.699','2022-04-19 14:43:12.853'),
(5,49,'2021-11-09 03:08:53.875','2022-03-06 06:14:31.336'),
(6,26,'2022-08-12 18:27:34.715','2021-12-17 07:53:50.245'),
(7,16,'2022-03-24 00:39:09.967','2022-08-08 14:56:43.010'),
(8,3,'2022-02-23 06:55:44.230','2022-03-26 18:25:22.266'),
(9,49,'2022-03-30 08:41:55.350','2022-01-08 22:22:56.805'),
(10,42,'2022-03-13 13:48:30.648','2022-08-05 20:43:29.351'),
(11,5,'2022-06-15 06:24:34.027','2022-08-10 17:42:23.973'),
(12,32,'2022-05-31 02:01:14.774','2021-11-12 00:21:37.758'),
(13,31,'2022-06-01 14:23:04.206','2022-04-26 01:47:04.207'),
(14,24,'2021-10-22 10:43:14.976','2022-07-18 12:30:14.254'),
(15,40,'2022-03-17 04:42:40.427','2022-09-06 07:41:53.907'),
(16,6,'2021-10-11 20:14:28.103','2021-12-19 20:31:41.646'),
(17,46,'2022-07-22 17:29:44.534','2022-05-19 15:03:29.228'),
(18,23,'2021-09-24 15:23:12.364','2022-03-26 09:56:24.217'),
(19,7,'2022-03-22 11:28:16.305','2022-05-27 21:58:24.710'),
(20,31,'2021-10-08 22:02:13.400','2022-07-19 16:38:55.947'),
(21,37,'2022-01-19 12:07:25.948','2021-11-23 20:37:33.439'),
(22,1,'2021-12-07 12:39:06.534','2022-05-25 02:34:29.313'),
(23,8,'2022-03-14 09:48:51.899','2021-12-10 03:44:59.920'),
(24,12,'2021-09-29 19:35:07.215','2022-05-08 01:05:43.089'),
(25,22,'2022-03-29 23:27:51.330','2021-10-15 10:25:06.674'),
(26,24,'2021-10-02 16:26:20.131','2022-04-03 04:25:19.305'),
(27,47,'2022-04-04 11:45:41.783','2022-07-04 14:07:22.055'),
(28,46,'2022-08-15 09:47:28.765','2021-09-24 07:41:39.214'),
(29,35,'2022-07-06 17:59:25.249','2022-04-23 02:16:04.201'),
(30,28,'2022-07-25 08:23:29.334','2022-08-21 13:48:01.684'),
(31,9,'2021-12-24 08:11:55.176','2022-04-05 18:58:36.204'),
(32,29,'2021-10-28 03:59:43.901','2022-01-13 23:44:06.799'),
(33,34,'2021-12-23 00:49:17.192','2022-07-04 11:26:12.148'),
(34,44,'2022-07-30 10:39:38.782','2022-03-07 01:19:50.968'),
(35,28,'2022-02-11 15:49:11.558','2022-06-07 15:40:06.139'),
(36,48,'2022-05-30 08:20:41.545','2022-03-16 16:04:25.544'),
(37,47,'2021-12-01 19:01:18.177','2021-10-24 22:57:18.773'),
(38,47,'2022-07-01 19:40:35.503','2021-11-07 15:34:07.579'),
(39,14,'2021-12-17 05:36:56.989','2022-05-31 00:51:38.590'),
(40,26,'2022-06-02 06:06:42.094','2022-03-29 18:43:22.324'),
(41,47,'2022-06-17 10:40:17.181','2022-02-06 00:43:39.327'),
(42,1,'2021-12-17 03:08:26.096','2022-07-23 18:02:20.647'),
(43,17,'2021-12-23 04:07:32.221','2022-07-16 12:10:03.051'),
(44,41,'2022-04-10 04:55:57.714','2022-04-07 23:50:54.537'),
(45,10,'2022-05-20 13:59:13.964','2021-11-24 02:07:35.480'),
(46,50,'2021-10-12 23:55:15.070','2022-02-25 09:51:12.774'),
(47,6,'2022-08-27 13:11:07.272','2022-02-16 13:22:24.354'),
(48,18,'2022-06-01 21:58:32.674','2022-01-15 08:29:58.185'),
(49,22,'2022-01-21 12:44:32.479','2022-08-19 13:28:59.764'),
(50,20,'2021-09-30 22:45:40.052','2022-05-05 00:54:06.679');

UNLOCK TABLES;

LOCK TABLES `daonators`.`campaing_organization` WRITE;

INSERT INTO `daonators`.`campaing_organization`
(`idCampaingFk`,`idOrganizationFk`,`transactionHash`,`gasAmount`)
VALUES
(1,1,'voluptas fugiat maiores',375.251),
(2,2,'nihil sint cupiditate',209.927),
(3,3,'non qui assumenda',457.64),
(4,4,'nisi vero quidem',506.323),
(5,5,'culpa dolorem ipsum',479.406),
(6,6,'nihil quis ullam',904.798),
(7,7,'quos nisi earum',195.854),
(8,8,'maxime veritatis reprehenderit',366.843),
(9,9,'et illum provident',670.29),
(10,10,'fuga nostrum adipisci',61.394),
(11,11,'nesciunt architecto nesciunt',719.661),
(12,12,'mollitia eius molestiae',624.74),
(13,13,'aperiam et recusandae',992.293),
(14,14,'saepe accusantium accusantium',1.807),
(15,15,'eaque magnam fugiat',684.55),
(16,16,'possimus quis cum',274.782),
(17,17,'natus vel est',480.417),
(18,18,'dolores ea ea',149.598),
(19,19,'architecto quo eaque',140.30),
(20,20,'aut commodi itaque',936.836),
(21,21,'eum et consequatur',385.604),
(22,22,'adipisci consequatur quis',190.354),
(23,23,'aut veritatis perferendis',165.566),
(24,24,'delectus sunt voluptatibus',673.241),
(25,25,'vitae aut vel',170.281),
(26,26,'voluptatem explicabo assumenda',73.839),
(27,27,'quam est ducimus',694.518),
(28,28,'rerum laboriosam molestiae',881.611),
(29,29,'sed earum repudiandae',661.103),
(30,30,'sed debitis at',372.767),
(31,31,'reiciendis quo in',590.565),
(32,32,'voluptas iste aspernatur',603.483),
(33,33,'repellat cumque consequuntur',667.706),
(34,34,'molestias sunt voluptatem',772.959),
(35,35,'nihil labore saepe',381.799),
(36,36,'illo quo recusandae',158.717),
(37,37,'at deserunt ut',137.398),
(38,38,'eaque temporibus quibusdam',601.514),
(39,39,'nesciunt repellendus illo',929.955),
(40,40,'quia et exercitationem',119.87),
(41,41,'suscipit unde non',376.532),
(42,42,'possimus omnis hic',264.606),
(43,43,'ipsam quas et',35.509),
(44,44,'perferendis ullam illum',433.24),
(45,45,'in vel eos',635.679),
(46,46,'laudantium hic aut',248.897),
(47,47,'quae itaque error',151.656),
(48,48,'quisquam aut tempore',416.766),
(49,49,'fuga veniam non',320.948),
(50,50,'temporibus ut perspiciatis',719.36);

UNLOCK TABLES;

LOCK TABLES `daonators`.`campaing_type` WRITE;

INSERT INTO `daonators`.`campaing_type`
(`idCampaingTypePk`,`name`,`active`)
VALUES
(1,'Chief Creative Assistant',1),
(2,'Dynamic Accounts Orchestrator',1),
(3,'Direct Branding Manager',1),
(4,'Lead Optimization Producer',1),
(5,'Principal Security Supervisor',1),
(6,'Central Solutions Agent',1),
(7,'Central Division Architect',1),
(8,'Human Solutions Manager',1),
(9,'Principal Metrics Supervisor',1),
(10,'Central Accountability Agent',1),
(11,'Global Implementation Director',1),
(12,'International Infrastructure Representative',1),
(13,'Central Configuration Manager',1),
(14,'Dynamic Tactics Facilitator',1),
(15,'Legacy Security Facilitator',1),
(16,'Global Factors Technician',1),
(17,'Corporate Usability Liaison',1),
(18,'Central Tactics Assistant',1),
(19,'Chief Division Specialist',1),
(20,'Forward Applications Producer',1),
(21,'Product Paradigm Coordinator',1),
(22,'Regional Usability Liaison',1),
(23,'Investor Identity Analyst',1),
(24,'Lead Research Coordinator',1),
(25,'Global Mobility Strategist',1),
(26,'Senior Research Director',1),
(27,'Legacy Mobility Administrator',1),
(28,'Principal Identity Supervisor',1),
(29,'Future Brand Facilitator',1),
(30,'Investor Assurance Agent',1),
(31,'Forward Interactions Analyst',1),
(32,'Regional Optimization Director',1),
(33,'Customer Intranet Manager',1),
(34,'International Web Executive',1),
(35,'Chief Solutions Orchestrator',1),
(36,'Product Infrastructure Planner',1),
(37,'Legacy Assurance Coordinator',1),
(38,'Human Integration Technician',1),
(39,'Internal Usability Liaison',1),
(40,'Corporate Implementation Officer',1),
(41,'Legacy Tactics Associate',1),
(42,'Dynamic Directives Producer',1),
(43,'Future Operations Liaison',1),
(44,'Global Web Coordinator',1),
(45,'Regional Identity Producer',1),
(46,'Chief Program Manager',1),
(47,'International Tactics Developer',1),
(48,'Lead Metrics Executive',1),
(49,'International Quality Representative',1),
(50,'Product Branding Liaison',1);

UNLOCK TABLES;

LOCK TABLES `daonators`.`organization` WRITE;

INSERT INTO `daonators`.`organization`
(`idOrganizationPk`,`name`,`walletAddress`,`active`)
VALUES
(1,'Internal Accounts Supervisor','culpa',1),
(2,'Global Functionality Architect','perferendis',1),
(3,'International Intranet Producer','sapiente',1),
(4,'Regional Group Assistant','quidem',1),
(5,'Direct Functionality Designer','ad',1),
(6,'International Metrics Liaison','tempore',1),
(7,'Legacy Communications Administrator','libero',1),
(8,'Human Web Developer','consequatur',1),
(9,'Dynamic Branding Coordinator','ut',1),
(10,'Principal Configuration Officer','corporis',1),
(11,'Principal Program Administrator','tempore',1),
(12,'Customer Applications Engineer','qui',1),
(13,'Direct Mobility Officer','quos',1),
(14,'Product Program Strategist','consequatur',1),
(15,'Lead Optimization Planner','et',1),
(16,'Senior Implementation Designer','eum',1),
(17,'Legacy Identity Executive','consequatur',1),
(18,'Principal Research Producer','voluptas',1),
(19,'Dynamic Configuration Associate','assumenda',1),
(20,'Corporate Metrics Assistant','expedita',1),
(21,'International Group Orchestrator','minima',1),
(22,'Human Research Analyst','ab',1),
(23,'Forward Identity Coordinator','non',1),
(24,'Dynamic Identity Liaison','iusto',1),
(25,'District Usability Designer','accusamus',1),
(26,'Dynamic Brand Strategist','voluptates',1),
(27,'Principal Program Architect','aut',1),
(28,'Lead Factors Analyst','voluptatem',1),
(29,'Investor Functionality Architect','dolor',1),
(30,'Forward Solutions Orchestrator','occaecati',1),
(31,'Legacy Research Liaison','sit',1),
(32,'Direct Marketing Director','assumenda',1),
(33,'International Implementation Director','repudiandae',1),
(34,'Product Mobility Facilitator','laboriosam',1),
(35,'Future Integration Engineer','quo',1),
(36,'Internal Functionality Architect','porro',1),
(37,'Dynamic Communications Supervisor','assumenda',1),
(38,'Dynamic Solutions Director','et',1),
(39,'Direct Integration Officer','dolor',1),
(40,'Central Response Designer','assumenda',1),
(41,'Dynamic Quality Developer','tempora',1),
(42,'Legacy Markets Representative','rerum',1),
(43,'Principal Usability Assistant','est',1),
(44,'National Group Administrator','sit',1),
(45,'Customer Branding Consultant','distinctio',1),
(46,'Customer Security Administrator','tempora',1),
(47,'Chief Creative Producer','eaque',1),
(48,'Lead Identity Liaison','maiores',1),
(49,'Lead Response Facilitator','explicabo',1),
(50,'Central Creative Director','explicabo',1);

UNLOCK TABLES;

LOCK TABLES `daonators`.`organization_type` WRITE;

INSERT INTO `daonators`.`organization_type`
(`idOrganizationTypePk`,`name`,`active`)
VALUES
(1,'Dynamic Data Specialist',1),
(2,'Customer Markets Manager',1),
(3,'District Paradigm Technician',1),
(4,'Regional Functionality Architect',1),
(5,'National Factors Representative',1),
(6,'Internal Accountability Strategist',1),
(7,'Chief Communications Analyst',1),
(8,'Lead Functionality Designer',1),
(9,'Direct Branding Designer',1),
(10,'Internal Group Engineer',1),
(11,'International Factors Developer',1),
(12,'District Markets Executive',1),
(13,'Global Operations Assistant',1),
(14,'National Marketing Architect',1),
(15,'Investor Brand Administrator',1),
(16,'Chief Solutions Producer',1),
(17,'National Brand Orchestrator',1),
(18,'Principal Program Planner',1),
(19,'Global Functionality Administrator',1),
(20,'International Assurance Specialist',1),
(21,'Internal Solutions Officer',1),
(22,'Regional Branding Architect',1),
(23,'Senior Applications Executive',1),
(24,'Future Interactions Representative',1),
(25,'Product Functionality Director',1),
(26,'Regional Quality Administrator',1),
(27,'Global Intranet Director',1),
(28,'Lead Security Administrator',1),
(29,'Principal Communications Producer',1),
(30,'Forward Implementation Specialist',1),
(31,'Future Applications Facilitator',1),
(32,'Direct Paradigm Technician',1),
(33,'Forward Accountability Administrator',1),
(34,'Legacy Assurance Administrator',1),
(35,'Central Integration Engineer',1),
(36,'International Branding Technician',1),
(37,'Dynamic Security Coordinator',1),
(38,'Global Accountability Developer',1),
(39,'District Research Architect',1),
(40,'Principal Paradigm Administrator',1),
(41,'Dynamic Directives Facilitator',1),
(42,'International Branding Consultant',1),
(43,'Legacy Interactions Agent',1),
(44,'Dynamic Implementation Specialist',1),
(45,'Global Identity Developer',1),
(46,'Internal Marketing Supervisor',1),
(47,'Investor Implementation Consultant',1),
(48,'Legacy Factors Manager',1),
(49,'Global Infrastructure Supervisor',1),
(50,'National Mobility Architect',1);

UNLOCK TABLES;

LOCK TABLES `daonators`.`organization_type_list` WRITE;

INSERT INTO `daonators`.`organization_type_list`
(`idOrganizationFk`,`idOrganizationTypeFk`)
VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10),
(11,11),
(12,12),
(13,13),
(14,14),
(15,15),
(16,16),
(17,17),
(18,18),
(19,19),
(20,20),
(21,21),
(22,22),
(23,23),
(24,24),
(25,25),
(26,26),
(27,27),
(28,28),
(29,29),
(30,30),
(31,31),
(32,32),
(33,33),
(34,34),
(35,35),
(36,36),
(37,37),
(38,38),
(39,39),
(40,40),
(41,41),
(42,42),
(43,43),
(44,44),
(45,45),
(46,46),
(47,47),
(48,48),
(49,49),
(50,50);

UNLOCK TABLES;

LOCK TABLES `daonators`.`user` WRITE;

INSERT INTO `daonators`.`user`
(`idUser`,`name`,`email`,`password`)
VALUES
(1,'Human Quality Architect','test@test.com',SHA2(SHA2('tester', 256), 256)),
(2,'Customer Web Facilitator','Kenneth_Murphy@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(3,'Central Web Assistant','Percival_Bashirian@gmail.com',SHA2(SHA2('tester', 256), 256)),
(4,'Global Accounts Technician','Efren.McKenzie8@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(5,'Customer Interactions Technician','Christelle_McDermott@gmail.com',SHA2(SHA2('tester', 256), 256)),
(6,'Senior Marketing Supervisor','Name33@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(7,'Central Group Liaison','Kyra80@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(8,'Lead Markets Supervisor','Savanah_Schaefer80@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(9,'Dynamic Factors Engineer','Kiel.Mraz25@gmail.com',SHA2(SHA2('tester', 256), 256)),
(10,'Investor Applications Designer','Heloise.OKon@gmail.com',SHA2(SHA2('tester', 256), 256)),
(11,'Internal Factors Liaison','Zoila.Boyle@gmail.com',SHA2(SHA2('tester', 256), 256)),
(12,'Lead Directives Manager','Frieda_Beatty53@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(13,'Forward Solutions Facilitator','Laurel_Harber89@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(14,'International Directives Analyst','Krystel.Jones25@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(15,'Global Group Officer','Rahul.Koelpin@gmail.com',SHA2(SHA2('tester', 256), 256)),
(16,'Dynamic Paradigm Planner','Danny.Hintz@gmail.com',SHA2(SHA2('tester', 256), 256)),
(17,'Global Research Strategist','Randy.Abshire@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(18,'Corporate Quality Developer','Marlon39@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(19,'International Infrastructure Specialist','Wilfrid30@gmail.com',SHA2(SHA2('tester', 256), 256)),
(20,'National Research Consultant','Jeanette_Wisoky16@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(21,'Internal Tactics Supervisor','Kris_Gislason35@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(22,'Dynamic Security Orchestrator','Zachery.Swaniawski93@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(23,'Corporate Operations Specialist','Lazaro_Pfannerstill65@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(24,'Future Metrics Engineer','Neva25@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(25,'Direct Metrics Supervisor','Crystel.Pagac85@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(26,'Human Assurance Agent','Elliot_White@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(27,'Dynamic Metrics Director','Dawson25@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(28,'Senior Solutions Engineer','Harvey99@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(29,'Corporate Brand Designer','Orpha.Moen@gmail.com',SHA2(SHA2('tester', 256), 256)),
(30,'Global Communications Planner','Dominique_Sauer22@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(31,'Customer Program Officer','Estelle.Witting@gmail.com',SHA2(SHA2('tester', 256), 256)),
(32,'National Markets Officer','Murray_Romaguera@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(33,'Central Infrastructure Representative','Kamron_Langworth@gmail.com',SHA2(SHA2('tester', 256), 256)),
(34,'Human Interactions Developer','Lillian67@gmail.com',SHA2(SHA2('tester', 256), 256)),
(35,'Global Functionality Architect','Lauriane.Murphy@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(36,'Dynamic Assurance Director','Justine.Koch89@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(37,'Product Solutions Consultant','Sam_Doyle48@gmail.com',SHA2(SHA2('tester', 256), 256)),
(38,'Principal Integration Executive','Rodger8@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(39,'Corporate Intranet Assistant','Jayme56@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(40,'Chief Functionality Orchestrator','Keagan_Runolfsdottir19@gmail.com',SHA2(SHA2('tester', 256), 256)),
(41,'Internal Tactics Manager','Preston30@gmail.com',SHA2(SHA2('tester', 256), 256)),
(42,'Internal Infrastructure Assistant','Oral_Steuber@gmail.com',SHA2(SHA2('tester', 256), 256)),
(43,'Corporate Accountability Assistant','Rollin31@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(44,'Corporate Markets Producer','Korey53@gmail.com',SHA2(SHA2('tester', 256), 256)),
(45,'Forward Communications Planner','Ashley58@gmail.com',SHA2(SHA2('tester', 256), 256)),
(46,'Product Interactions Liaison','Amya30@gmail.com',SHA2(SHA2('tester', 256), 256)),
(47,'Senior Optimization Designer','Mohammad20@gmail.com',SHA2(SHA2('tester', 256), 256)),
(48,'Investor Markets Representative','Norbert_Funk@hotmail.com',SHA2(SHA2('tester', 256), 256)),
(49,'Product Web Producer','Lura70@yahoo.com',SHA2(SHA2('tester', 256), 256)),
(50,'International Research Facilitator','Trycia_Turcotte37@yahoo.com',SHA2(SHA2('tester', 256), 256));

UNLOCK TABLES;

LOCK TABLES `daonators`.`user_wallet` WRITE;

INSERT INTO `daonators`.`user_wallet`
(`idUserWalletPk`,`walletAddress`,`idUserFk`)
VALUES
(1,'aut',1),
(2,'repudiandae',35),
(3,'et',33),
(4,'facere',2),
(5,'iste',41),
(6,'nihil',37),
(7,'a',10),
(8,'similique',33),
(9,'rerum',27),
(10,'saepe',50),
(11,'vero',7),
(12,'quam',46),
(13,'repudiandae',26),
(14,'aut',12),
(15,'non',49),
(16,'perspiciatis',37),
(17,'exercitationem',43),
(18,'accusamus',16),
(19,'dolore',36),
(20,'ea',12),
(21,'repellat',20),
(22,'nisi',9),
(23,'et',37),
(24,'quia',46),
(25,'ut',26),
(26,'nobis',11),
(27,'alias',34),
(28,'quia',41),
(29,'voluptatem',43),
(30,'sint',37),
(31,'adipisci',29),
(32,'laborum',7),
(33,'voluptates',21),
(34,'ab',21),
(35,'error',12),
(36,'maiores',49),
(37,'non',28),
(38,'suscipit',13),
(39,'nihil',42),
(40,'eveniet',19),
(41,'vero',45),
(42,'odio',15),
(43,'hic',43),
(44,'aut',33),
(45,'est',34),
(46,'vero',36),
(47,'possimus',41),
(48,'tempora',39),
(49,'culpa',37),
(50,'esse',15);

UNLOCK TABLES;

LOCK TABLES `daonators`.`vote` WRITE;

INSERT INTO `daonators`.`vote`
(`idVotePk`,`lastUpdate`,`tokensAmount`,`idCampaingFk`,`idOrganizationFk`,`idUserWalletFk`)
VALUES
(1,'2021-12-05 19:10:36.198','',1,76,1),
(2,'2021-11-08 05:35:24.465','',7,158,43),
(3,'2022-02-16 22:03:45.730','',48,636,15),
(4,'2021-10-19 22:10:10.805','',33,569,25),
(5,'2022-04-02 23:48:06.355','',26,530,20),
(6,'2022-04-14 20:57:53.337','',7,801,36),
(7,'2021-11-15 12:29:43.756','',19,750,50),
(8,'2022-02-24 03:55:08.955','',12,783,20),
(9,'2022-04-23 04:20:37.465','',35,915,43),
(10,'2021-10-15 01:53:11.741','',25,111,35),
(11,'2021-10-09 14:17:58.117','',35,890,31),
(12,'2022-06-11 16:57:16.690','',46,682,29),
(13,'2021-09-26 10:20:54.302','',49,635,32),
(14,'2022-03-25 19:19:12.941','',17,920,1),
(15,'2021-12-09 17:16:03.383','',28,73,23),
(16,'2021-12-30 21:27:33.776','',13,672,28),
(17,'2022-02-18 10:38:08.061','',39,194,25),
(18,'2022-07-04 20:54:40.068','',16,522,42),
(19,'2022-08-04 21:23:36.897','',33,997,15),
(20,'2021-10-04 11:26:19.750','',35,824,26),
(21,'2022-08-19 10:00:03.186','',3,41,8),
(22,'2022-08-01 07:41:39.178','',30,193,23),
(23,'2022-01-09 00:59:23.318','',14,482,3),
(24,'2021-12-09 03:16:32.388','',39,440,43),
(25,'2022-08-24 23:59:53.138','',6,76,27),
(26,'2021-09-12 10:00:15.835','',5,849,24),
(27,'2021-11-20 04:40:04.228','',7,333,5),
(28,'2022-03-05 09:53:04.317','',6,120,40),
(29,'2022-03-19 19:05:36.835','',10,574,25),
(30,'2022-09-09 00:51:13.169','',22,406,4),
(31,'2021-11-03 14:04:33.467','',8,920,43),
(32,'2021-10-27 03:55:54.498','',38,364,28),
(33,'2021-10-15 08:41:02.550','',32,643,34),
(34,'2022-07-25 23:19:03.003','',10,648,5),
(35,'2021-09-12 11:26:08.071','',39,120,30),
(36,'2022-03-28 11:36:56.999','',15,1,13),
(37,'2022-03-22 20:53:01.976','',32,494,10),
(38,'2021-11-24 17:33:39.404','',35,526,45),
(39,'2022-02-27 16:24:19.610','',42,782,44),
(40,'2022-06-21 13:27:50.954','',25,387,50),
(41,'2022-04-12 19:54:14.614','',30,260,50),
(42,'2021-12-22 12:18:21.393','',10,342,50),
(43,'2022-07-07 09:29:46.661','',26,176,17),
(44,'2021-10-12 13:22:28.508','',1,479,27),
(45,'2022-04-25 03:41:13.563','',12,549,22),
(46,'2022-07-12 22:42:16.009','',9,662,29),
(47,'2021-12-10 00:33:29.305','',19,501,45),
(48,'2022-04-03 02:48:44.377','',25,217,32),
(49,'2022-05-27 19:17:23.027','',48,48,11),
(50,'2022-08-16 08:02:38.008','',30,7,17);

UNLOCK TABLES;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
