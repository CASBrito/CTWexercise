-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CTWExercise
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CTWExercise
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CTWExercise` DEFAULT CHARACTER SET utf8 ;
USE `CTWExercise` ;

-- -----------------------------------------------------
-- Table `CTWExercise`.`Car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CTWExercise`.`Car` (
  `idCar` INT NOT NULL AUTO_INCREMENT,
  `Brand` VARCHAR(45) NOT NULL,
  `Model` VARCHAR(45) NOT NULL,
  `Seats` INT NOT NULL,
  `LicensePlate` VARCHAR(45) NOT NULL,
  `EngineType` ENUM("COMBUSTION", "ELECTRIC", "HYBRID") NOT NULL,
  `CurrentAutonomy` INT NOT NULL,
  `Image` BLOB NOT NULL,
  PRIMARY KEY (`idCar`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CTWExercise`.`Driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CTWExercise`.`Driver` (
  `idDriver` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Contact` VARCHAR(45) NOT NULL,
  `LicenseNumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDriver`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CTWExercise`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CTWExercise`.`Reservation` (
  `idReservation` INT NOT NULL AUTO_INCREMENT,
  `Car_idCar` INT NOT NULL,
  `Driver_idDriver` INT NOT NULL,
  `pickupDate` TIMESTAMP NOT NULL,
  `DropOffDate` TIMESTAMP NOT NULL,
  INDEX `fk_Reservation_Car_idx` (`Car_idCar` ASC) VISIBLE,
  INDEX `fk_Reservation_Driver1_idx` (`Driver_idDriver` ASC) VISIBLE,
  PRIMARY KEY (`idReservation`),
  CONSTRAINT `fk_Reservation_Car`
    FOREIGN KEY (`Car_idCar`)
    REFERENCES `CTWExercise`.`Car` (`idCar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservation_Driver1`
    FOREIGN KEY (`Driver_idDriver`)
    REFERENCES `CTWExercise`.`Driver` (`idDriver`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
