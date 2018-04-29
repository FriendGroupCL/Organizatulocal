-- MySQL Script generated by MySQL Workbench
-- Sat Apr 28 22:47:36 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema organizatulocal_DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema organizatulocal_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `organizatulocal_DB` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci ;
USE `organizatulocal_DB` ;

-- -----------------------------------------------------
-- Table `organizatulocal_DB`.`local`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organizatulocal_DB`.`local` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `razon_social` VARCHAR(45) NOT NULL,
  `rut` VARCHAR(15) NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizatulocal_DB`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organizatulocal_DB`.`rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizatulocal_DB`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organizatulocal_DB`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(100) NOT NULL,
  `estado` TINYINT NOT NULL,
  `clave_recuperacion` VARCHAR(100) NULL,
  `rol_id` INT NOT NULL,
  `local_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_rol1_idx` (`rol_id` ASC),
  INDEX `fk_usuario_local1_idx` (`local_id` ASC),
  CONSTRAINT `fk_usuario_rol1`
    FOREIGN KEY (`rol_id`)
    REFERENCES `organizatulocal_DB`.`rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_local1`
    FOREIGN KEY (`local_id`)
    REFERENCES `organizatulocal_DB`.`local` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizatulocal_DB`.`permiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organizatulocal_DB`.`permiso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  `rol_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_permiso_rol1_idx` (`rol_id` ASC),
  CONSTRAINT `fk_permiso_rol1`
    FOREIGN KEY (`rol_id`)
    REFERENCES `organizatulocal_DB`.`rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizatulocal_DB`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organizatulocal_DB`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizatulocal_DB`.`producto_barra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organizatulocal_DB`.`producto_barra` (
  `codigo` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `precio_compra` INT NOT NULL,
  `precio_venta` INT NOT NULL,
  `stock` INT NOT NULL,
  `estado` TINYINT NOT NULL,
  `local_id` INT NOT NULL,
  `categoria_id` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_producto_local1_idx` (`local_id` ASC),
  INDEX `fk_producto_barra_categoria1_idx` (`categoria_id` ASC),
  CONSTRAINT `fk_producto_local1`
    FOREIGN KEY (`local_id`)
    REFERENCES `organizatulocal_DB`.`local` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_barra_categoria1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `organizatulocal_DB`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizatulocal_DB`.`tipo_de_pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organizatulocal_DB`.`tipo_de_pago` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizatulocal_DB`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organizatulocal_DB`.`venta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `sub_total` INT NOT NULL,
  `total` INT NOT NULL,
  `tipo_de_pago_id` INT NOT NULL,
  `local_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_venta_tipo_de_pago1_idx` (`tipo_de_pago_id` ASC),
  INDEX `fk_venta_local1_idx` (`local_id` ASC),
  CONSTRAINT `fk_venta_tipo_de_pago1`
    FOREIGN KEY (`tipo_de_pago_id`)
    REFERENCES `organizatulocal_DB`.`tipo_de_pago` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_local1`
    FOREIGN KEY (`local_id`)
    REFERENCES `organizatulocal_DB`.`local` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizatulocal_DB`.`venta_has_producto_barra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organizatulocal_DB`.`venta_has_producto_barra` (
  `venta_id` INT NOT NULL,
  `producto_barra_codigo` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `subtotal` INT NOT NULL,
  PRIMARY KEY (`venta_id`, `producto_barra_codigo`),
  INDEX `fk_venta_has_producto_barra_producto_barra1_idx` (`producto_barra_codigo` ASC),
  INDEX `fk_venta_has_producto_barra_venta1_idx` (`venta_id` ASC),
  CONSTRAINT `fk_venta_has_producto_barra_venta1`
    FOREIGN KEY (`venta_id`)
    REFERENCES `organizatulocal_DB`.`venta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_has_producto_barra_producto_barra1`
    FOREIGN KEY (`producto_barra_codigo`)
    REFERENCES `organizatulocal_DB`.`producto_barra` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizatulocal_DB`.`producto_especial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organizatulocal_DB`.`producto_especial` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  `preco_venta` INT NOT NULL,
  `unidad_medida` VARCHAR(45) NOT NULL,
  `estado` TINYINT NOT NULL,
  `categoria_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_producto_especial_categoria1_idx` (`categoria_id` ASC),
  CONSTRAINT `fk_producto_especial_categoria1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `organizatulocal_DB`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organizatulocal_DB`.`venta_has_producto_especial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organizatulocal_DB`.`venta_has_producto_especial` (
  `venta_id` INT NOT NULL,
  `producto_especial_id` INT NOT NULL,
  `subtotal` INT NOT NULL,
  PRIMARY KEY (`venta_id`, `producto_especial_id`),
  INDEX `fk_venta_has_producto_especial_producto_especial1_idx` (`producto_especial_id` ASC),
  INDEX `fk_venta_has_producto_especial_venta1_idx` (`venta_id` ASC),
  CONSTRAINT `fk_venta_has_producto_especial_venta1`
    FOREIGN KEY (`venta_id`)
    REFERENCES `organizatulocal_DB`.`venta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_has_producto_especial_producto_especial1`
    FOREIGN KEY (`producto_especial_id`)
    REFERENCES `organizatulocal_DB`.`producto_especial` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
