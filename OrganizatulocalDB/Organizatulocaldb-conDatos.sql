-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: organizatulocal_db
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Abarrotes','productos envasados no perecibles'),(2,'Aseo y Limpieza','productos destinados al aseo y ornato del hogar'),(3,'Aseo Personal','productos relacionados al aseo personal de las personas'),(4,'Lácteos','productos derivados de la leche'),(5,'Cecinas y Quesos','productos derivados de la carne y la leche'),(6,'Vinos y Licores','productos líquidos con alcohol'),(7,'Bebidas y Jugos','productos líquidos sin alcohol'),(8,'Frutas y Verduras','productos de frutas y verduras'),(9,'Carnes','productos de carne'),(10,'Panadería y Pastelería','productos elaborados'),(11,'Galletas y Snacks','productos de golosinas'),(12,'Cigarros','productos con tabaco y nicotina'),(13,'Conservas y Enlatados','productos envasados en latas'),(14,'Detergentes','productos para el lavado de ropa');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `local` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `rut` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `permiso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  `rol_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_permiso_rol1_idx` (`rol_id`),
  CONSTRAINT `fk_permiso_rol1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_barra`
--

DROP TABLE IF EXISTS `producto_barra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `producto_barra` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `precio_compra` int(11) NOT NULL,
  `precio_venta` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `local_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_producto_local1_idx` (`local_id`),
  KEY `fk_producto_barra_categoria1_idx` (`categoria_id`),
  CONSTRAINT `fk_producto_barra_categoria1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  CONSTRAINT `fk_producto_local1` FOREIGN KEY (`local_id`) REFERENCES `local` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_barra`
--

LOCK TABLES `producto_barra` WRITE;
/*!40000 ALTER TABLE `producto_barra` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_barra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_especial`
--

DROP TABLE IF EXISTS `producto_especial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `producto_especial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  `preco_venta` int(11) NOT NULL,
  `unidad_medida` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_producto_especial_categoria1_idx` (`categoria_id`),
  CONSTRAINT `fk_producto_especial_categoria1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_especial`
--

LOCK TABLES `producto_especial` WRITE;
/*!40000 ALTER TABLE `producto_especial` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_especial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'superadmin','este rol es el principal y sirve para administrar la aplicacion organiza tu local'),(2,'local','este rol es el que se asigna a una cuenta de local (minimercado) y sirve para ver todas las funcionalidades relacionadas a la administración del local'),(3,'vendedor','este rol sirve para realizar diversas acciones como agregar ventas, consultar producto, etc. Esta cuenta puede ser creada por los dueños del local (rol local)');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_de_pago`
--

DROP TABLE IF EXISTS `tipo_de_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_de_pago` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_de_pago`
--

LOCK TABLES `tipo_de_pago` WRITE;
/*!40000 ALTER TABLE `tipo_de_pago` DISABLE KEYS */;
INSERT INTO `tipo_de_pago` VALUES (1,'Efectivo','pago con dinero en efectivo'),(2,'Crédito o Débito','pago a partir de dinero que una persona tenga en una cuenta bancaria o con cargo a una tarjeta comercial (visa o mastercard)');
/*!40000 ALTER TABLE `tipo_de_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `correo` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `clave` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `clave_recuperacion` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `rol_id` int(11) NOT NULL,
  `local_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuario_rol1_idx` (`rol_id`),
  KEY `fk_usuario_local1_idx` (`local_id`),
  CONSTRAINT `fk_usuario_local1` FOREIGN KEY (`local_id`) REFERENCES `local` (`id`),
  CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `venta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `sub_total` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `tipo_de_pago_id` int(11) NOT NULL,
  `local_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_venta_tipo_de_pago1_idx` (`tipo_de_pago_id`),
  KEY `fk_venta_local1_idx` (`local_id`),
  CONSTRAINT `fk_venta_local1` FOREIGN KEY (`local_id`) REFERENCES `local` (`id`),
  CONSTRAINT `fk_venta_tipo_de_pago1` FOREIGN KEY (`tipo_de_pago_id`) REFERENCES `tipo_de_pago` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_has_producto_barra`
--

DROP TABLE IF EXISTS `venta_has_producto_barra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `venta_has_producto_barra` (
  `venta_id` int(11) NOT NULL,
  `producto_barra_codigo` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL,
  PRIMARY KEY (`venta_id`,`producto_barra_codigo`),
  KEY `fk_venta_has_producto_barra_producto_barra1_idx` (`producto_barra_codigo`),
  KEY `fk_venta_has_producto_barra_venta1_idx` (`venta_id`),
  CONSTRAINT `fk_venta_has_producto_barra_producto_barra1` FOREIGN KEY (`producto_barra_codigo`) REFERENCES `producto_barra` (`codigo`),
  CONSTRAINT `fk_venta_has_producto_barra_venta1` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_has_producto_barra`
--

LOCK TABLES `venta_has_producto_barra` WRITE;
/*!40000 ALTER TABLE `venta_has_producto_barra` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta_has_producto_barra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_has_producto_especial`
--

DROP TABLE IF EXISTS `venta_has_producto_especial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `venta_has_producto_especial` (
  `venta_id` int(11) NOT NULL,
  `producto_especial_id` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL,
  PRIMARY KEY (`venta_id`,`producto_especial_id`),
  KEY `fk_venta_has_producto_especial_producto_especial1_idx` (`producto_especial_id`),
  KEY `fk_venta_has_producto_especial_venta1_idx` (`venta_id`),
  CONSTRAINT `fk_venta_has_producto_especial_producto_especial1` FOREIGN KEY (`producto_especial_id`) REFERENCES `producto_especial` (`id`),
  CONSTRAINT `fk_venta_has_producto_especial_venta1` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_has_producto_especial`
--

LOCK TABLES `venta_has_producto_especial` WRITE;
/*!40000 ALTER TABLE `venta_has_producto_especial` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta_has_producto_especial` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-29  0:01:11
