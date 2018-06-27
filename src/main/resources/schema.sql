# Create the schema
CREATE SCHEMA `graphql_tutorial` DEFAULT COLLATE=`utf8_bin` DEFAULT CHARACTER SET=`utf8`;
# Create a user with access to that schema
GRANT ALL PRIVILEGES ON `graphql_tutorial`.* TO `graphql_tutorial_user`@`localhost` IDENTIFIED BY 'CHANGE_ME_TO_SOMETHING_SECURE';
# Create the table
CREATE TABLE `pets` (`id` INT(11) NOT NULL AUTO_INCREMENT, `name` VARCHAR(255) DEFAULT NULL, `age` TINYINT(3) DEFAULT NULL, `type` ENUM('DOG','CAT','BADGER','MAMMOTH'), PRIMARY KEY(`id`));
# create entries in the table
INSERT INTO `pets` (`name`,`age`,`type`) VALUES ('Steve', 5, 'BADGER'), ('Jeff', 88, 'MAMMOTH'), ('Oscar', 2, 'CAT');