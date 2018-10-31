/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.5.19 : Database - spring_boot_demodb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring_boot_demodb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spring_boot_demodb`;

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `times` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`id`,`name`,`age`,`times`,`deleted`) values (1,'陈杰',34,'2018-09-04 10:29:53',0),(2,'李忠涛',33,'2018-09-20 10:30:15',0),(3,'马燕楠',37,'2018-05-22 10:30:32',0),(4,'郭亚彬',28,'2018-09-20 10:30:47',1),(5,'高伟浩',26,'2018-09-20 10:32:57',0),(6,'付鉥军',34,'2018-09-20 10:33:00',0),(7,'刘奕君',29,'2018-09-20 10:33:02',0),(8,'孙林涛',32,'2018-07-18 10:32:49',0),(9,'王志刚',37,'2018-09-12 10:32:46',0),(10,'赵永阳',28,'2018-09-20 17:43:46',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
