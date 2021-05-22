-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------user_name
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`roles` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`accounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`accounts` (
  `account_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`account_id`, `password`, `user_name`),
  INDEX `fk_accounts_role_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_accounts_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `mydb`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`album` (
  `albom_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`albom_id`),
  INDEX `fk_album_accounts1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_album_accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `mydb`.`accounts` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`beats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`beats` (
  `beat_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `timing` VARCHAR(45) NOT NULL,
  `image_path` VARCHAR(255) NOT NULL,
  `albom_id` INT NULL,
  `account_id` INT NULL,
  PRIMARY KEY (`beat_id`, `name`, `timing`, `image_path`),
  INDEX `fk_beats_album1_idx` (`albom_id` ASC) VISIBLE,
  INDEX `fk_beats_accounts1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_beats_album1`
    FOREIGN KEY (`albom_id`)
    REFERENCES `mydb`.`album` (`albom_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beats_accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `mydb`.`accounts` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`comments` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(45) NULL,
  `date` DATE NOT NULL,
  `account_id` INT NOT NULL,
  `beat_id` INT NOT NULL,
  PRIMARY KEY (`comment_id`, `date`),
  INDEX `fk_comments_accounts1_idx` (`account_id` ASC) VISIBLE,
  INDEX `fk_comments_beats1_idx` (`beat_id` ASC) VISIBLE,
  CONSTRAINT `fk_comments_accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `mydb`.`accounts` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_beats1`
    FOREIGN KEY (`beat_id`)
    REFERENCES `mydb`.`beats` (`beat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;