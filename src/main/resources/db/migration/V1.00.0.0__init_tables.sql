CREATE TABLE `member`
(
    `member_id` INT NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`member_id`)
);

CREATE TABLE `board`
(
    `board_id` INT NOT NULL AUTO_INCREMENT,
    `writer_id` INT NOT NULL,
    `title` VARCHAR(255) NOT NULL ,
    `content` VARCHAR(1000) NOT NULL ,
    `create_date` TIMESTAMP NOT NULL,
    `updated_date` TIMESTAMP,
    PRIMARY KEY (`board_id`)
);