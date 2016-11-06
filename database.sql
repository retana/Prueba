/*
SQLyog Ultimate v9.02 
MySQL - 5.6.16 : Database - db_tienda
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_tienda` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_tienda`;

/*Table structure for table `marca` */

DROP TABLE IF EXISTS `marca`;

CREATE TABLE `marca` (
  `id_marca` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `marca` */

insert  into `marca`(`id_marca`,`nombre`) values (1,'Boss'),(2,'Korg'),(3,'Dunlop'),(4,'Maxtone'),(5,'Marshall');

/*Table structure for table `pais` */

DROP TABLE IF EXISTS `pais`;

CREATE TABLE `pais` (
  `id_pais` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `pais` */

insert  into `pais`(`id_pais`,`nombre`) values (1,'Guatemala'),(2,'El Salvador'),(3,'Costa Rica'),(4,'Nicaragua'),(5,'Colombia'),(6,'Venezuela'),(7,'Estados Unidos');

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `id_producto` int(10) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(128) DEFAULT NULL,
  `modelo` varchar(128) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `garantia_meses` int(10) DEFAULT NULL,
  `pais_id_pais` int(10) DEFAULT NULL,
  `marca_id_marca` int(10) DEFAULT NULL,
  `tipo_instrumento_id_tipo_instrumento` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `FK_producto` (`marca_id_marca`),
  KEY `FK_producto_pais` (`pais_id_pais`),
  KEY `FK_producto_tipo` (`tipo_instrumento_id_tipo_instrumento`),
  CONSTRAINT `FK_producto` FOREIGN KEY (`marca_id_marca`) REFERENCES `marca` (`id_marca`),
  CONSTRAINT `FK_producto_pais` FOREIGN KEY (`pais_id_pais`) REFERENCES `pais` (`id_pais`),
  CONSTRAINT `FK_producto_tipo` FOREIGN KEY (`tipo_instrumento_id_tipo_instrumento`) REFERENCES `tipo_instrumento` (`id_tipo_instrumento`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `producto` */

insert  into `producto`(`id_producto`,`codigo`,`modelo`,`precio`,`garantia_meses`,`pais_id_pais`,`marca_id_marca`,`tipo_instrumento_id_tipo_instrumento`) values (1,'A-8099','207','99.80',9,1,1,1),(2,'A-8099','207','99.80',9,1,1,1),(3,'A-680999','a121313132132','993.30',2,2,2,2),(4,'A-680999','a121313132132','1000.00',2,1,1,1),(5,'A-680999','a121313132132','1000.00',2,2,2,2),(6,'A-680999','a121313132132','10021.00',2,3,4,1),(7,'A-680999','a121313132132','993.30',1,4,5,2),(8,'A-680999','a121313132132','1000.00',1,7,2,1),(9,'test','test','100.00',1,3,2,2);

/*Table structure for table `rol` */

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `id_rol` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `rol` */

insert  into `rol`(`id_rol`,`nombre`) values (1,'ROL_USUARIO'),(2,'ROL_ADMINISTRADOR');

/*Table structure for table `tipo_instrumento` */

DROP TABLE IF EXISTS `tipo_instrumento`;

CREATE TABLE `tipo_instrumento` (
  `id_tipo_instrumento` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_instrumento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_instrumento` */

insert  into `tipo_instrumento`(`id_tipo_instrumento`,`nombre`) values (1,'Instrumento'),(2,'Accesorio');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id_usuario` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `contrasena` varchar(128) DEFAULT NULL,
  `rol_id_rol` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FK_usuario` (`rol_id_rol`),
  CONSTRAINT `FK_usuario` FOREIGN KEY (`rol_id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`id_usuario`,`nombre`,`email`,`contrasena`,`rol_id_rol`) values (1,'Francisco Retana','inforetana@gmail.com','123',1),(2,'Juan Perez','jp@gmail.com','321',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
