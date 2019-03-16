DROP TABLE IF EXISTS location ;

CREATE TABLE IF NOT EXISTS location (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `location` VARCHAR(45) NOT NULL,
                                               PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `phuc`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS users ;

CREATE TABLE IF NOT EXISTS users (
                                           `id`  INT NOT NULL AUTO_INCREMENT,
                                           `username` VARCHAR(40) NOT NULL UNIQUE,
                                           `password` VARCHAR(100) NOT NULL,
                                           `lastName` VARCHAR(50) NULL,
                                           `firstName` VARCHAR(50) NULL,
                                           PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `phuc`.`post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS post ;

CREATE TABLE IF NOT EXISTS post (
                                           `id` INT NOT NULL AUTO_INCREMENT,
                                           `title` TEXT NOT NULL,
                                           `dateOn` DATE NULL,
                                           `price` DECIMAL(10,3) NOT NULL,
                                           `supercifies` DECIMAL(10,3) NOT NULL,
                                           `description` TEXT NULL,
                                           `status` VARCHAR(45) NULL,
                                           `tag_name` VARCHAR(100) NOT NULL,
                                           `tag_phonenumber` VARCHAR(20) NOT NULL,
                                           `tag_zalo` VARCHAR(20) NULL,
                                           `tag_skype` VARCHAR(320) NULL,
                                           `tag_email` VARCHAR(320) NULL,
                                           `tag_direction` VARCHAR(45) NULL,
                                           `locationId` INT NULL,
                                           `userId` INT NULL,
                                           PRIMARY KEY (`id`),
                                           CONSTRAINT `fk_post_location1`
                                             FOREIGN KEY (`locationId`)
                                               REFERENCES location (`id`)
                                               ON DELETE NO ACTION
                                               ON UPDATE NO ACTION,
                                           CONSTRAINT `fk_post_user1`
                                             FOREIGN KEY (`userId`)
                                               REFERENCES `users` (`id`)
                                               ON DELETE NO ACTION
                                               ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `phuc`.`new`
-- -----------------------------------------------------
DROP TABLE IF EXISTS new ;

CREATE TABLE IF NOT EXISTS new (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `title` TEXT NOT NULL,
                                          `content` TEXT NOT NULL,
                                          `create_time` DATE NULL,
                                          `user_id` INT NOT NULL,
                                          PRIMARY KEY (`id`),
                                          CONSTRAINT `fk_new_user1`
                                            FOREIGN KEY (`user_id`)
                                              REFERENCES `users` (`id`)
                                              ON DELETE NO ACTION
                                              ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `phuc`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS category ;

CREATE TABLE IF NOT EXISTS category (
                                               `category_id` INT NOT NULL AUTO_INCREMENT,
                                               `name` NVARCHAR(255) NOT NULL,
                                               PRIMARY KEY (`category_id`));


-- -----------------------------------------------------
-- Table `phuc`.`category_post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS category_post ;

CREATE TABLE IF NOT EXISTS category_post (
                                                    `postedBy` VARCHAR(45) NOT NULL,
                                                    `create_time` DATE NULL,
                                                    `category_id` INT NOT NULL,
                                                    `post_id` INT NOT NULL,
                                                    PRIMARY KEY (`category_id`, `post_id`),
                                                    CONSTRAINT `fk_category_post_post1`
                                                      FOREIGN KEY (`post_id`)
                                                        REFERENCES `post` (`id`)
                                                        ON DELETE NO ACTION
                                                        ON UPDATE NO ACTION,
                                                    CONSTRAINT `fk_category_post_category1`
                                                      FOREIGN KEY (`category_id`)
                                                        REFERENCES `category` (`category_id`)
                                                        ON DELETE NO ACTION
                                                        ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `phuc`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS roles ;

CREATE TABLE IF NOT EXISTS roles (
                                           `role` VARCHAR(10) NOT NULL,
                                           PRIMARY KEY (`role`));


-- -----------------------------------------------------
-- Table `phuc`.`role_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS role_user ;

CREATE TABLE IF NOT EXISTS role_user (
                                                `user_id` INT NOT NULL,
                                                `role` VARCHAR(10) NOT NULL,
                                                PRIMARY KEY (`user_id`, `role`),
                                                CONSTRAINT `fk_role_user_user1`
                                                  FOREIGN KEY (`user_id`)
                                                    REFERENCES `users` (`id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION,
                                                CONSTRAINT `fk_role_user_role1`
                                                  FOREIGN KEY (`role`)
                                                    REFERENCES roles (`role`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION);

