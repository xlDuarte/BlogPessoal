CREATE TABLE `Tb_tema` (
	`id` bigint(5) NOT NULL AUTO_INCREMENT,
	`descrição` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Tb_placasdevideo` (
	`id` bigint(5) NOT NULL AUTO_INCREMENT,
	`marca` varchar(255) NOT NULL,
	`modelo` varchar(255) NOT NULL,
	`preço` int(100) NOT NULL,
	`memoria de video` varchar(255) NOT NULL,
	`ghz` varchar(255) NOT NULL,
	`id_tema` bigint(255) NOT NULL AUTO_INCREMENT,
	`id_usuários` bigint(255) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Tb_usuários` (
	`id` bigint(5) NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`senha` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Tb_placasdevideo` ADD CONSTRAINT `Tb_placasdevideo_fk0` FOREIGN KEY (`id_tema`) REFERENCES `Tb_tema`(`id`);

ALTER TABLE `Tb_placasdevideo` ADD CONSTRAINT `Tb_placasdevideo_fk1` FOREIGN KEY (`id_usuários`) REFERENCES `Tb_usuários`(`id`);




