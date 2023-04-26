CREATE TABLE `account` (
	`uid` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`user_name` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci',
	`address_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`uid`) USING BTREE,
	UNIQUE INDEX `username` (`user_name`) USING HASH,
	INDEX `FK_address_id` (`address_id`) USING BTREE,
	CONSTRAINT `FK_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=24
;
