CREATE DATABASE IF NOT EXISTS `neordinary`;
USE neordinary;

CREATE USER IF NOT EXISTS `neordinary`@`localhost` IDENTIFIED BY 'backend';
CREATE USER `neordinary`@`%` IDENTIFIED BY 'backend';

GRANT all privileges ON `stock`.* TO `neordinary`@`localhost`;
GRANT all privileges ON `stock`.* TO `neordinary`@`%`;