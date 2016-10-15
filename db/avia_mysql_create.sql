CREATE TABLE `plane` (
	`bort_number` VARCHAR(255) NOT NULL UNIQUE,
	`model` VARCHAR(255) NOT NULL,
	`resource` INT NOT NULL,
	PRIMARY KEY (`bort_number`)
);

CREATE TABLE `flight` (
	`num` INT NOT NULL,
	`plane` VARCHAR(255) NOT NULL,
	`from` INT NOT NULL,
	`d_and_t` DATETIME NOT NULL,
	`to` INT NOT NULL,
	PRIMARY KEY (`num`)
);

CREATE TABLE `ticket` (
	`id` INT NOT NULL,
	`fl_num` INT NOT NULL,
	`passenger` INT NOT NULL,
	`class` INT NOT NULL,
	`price` INT NOT NULL,
	`bag` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `passengers` (
	`id` INT NOT NULL,
	`full_name` VARCHAR(255) NOT NULL,
	`birthday` DATE NOT NULL,
	`passport` VARCHAR(255) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `reservation` (
	`fl_num` INT NOT NULL,
	`ticked_id` INT NOT NULL
);

CREATE TABLE `cities` (
	`id` INT NOT NULL,
	`city` VARCHAR(255) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
);

ALTER TABLE `flight` ADD CONSTRAINT `flight_fk0` FOREIGN KEY (`plane`) REFERENCES `plane`(`bort_number`);

ALTER TABLE `flight` ADD CONSTRAINT `flight_fk1` FOREIGN KEY (`from`) REFERENCES `cities`(`id`);

ALTER TABLE `flight` ADD CONSTRAINT `flight_fk2` FOREIGN KEY (`to`) REFERENCES `cities`(`id`);

ALTER TABLE `ticket` ADD CONSTRAINT `ticket_fk0` FOREIGN KEY (`fl_num`) REFERENCES `flight`(`num`);

ALTER TABLE `ticket` ADD CONSTRAINT `ticket_fk1` FOREIGN KEY (`passenger`) REFERENCES `passengers`(`id`);

ALTER TABLE `reservation` ADD CONSTRAINT `reservation_fk0` FOREIGN KEY (`fl_num`) REFERENCES `flight`(`num`);

ALTER TABLE `reservation` ADD CONSTRAINT `reservation_fk1` FOREIGN KEY (`ticked_id`) REFERENCES `ticket`(`id`);

