

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for country_full
-- ----------------------------
DROP TABLE country_full;
CREATE TABLE `country_full` (
  `geoname_id` int unsigned NOT NULL,
  `locale_code` varchar(32),
  `continent_code` char(2),
  `continent_name` varchar(32),
  `country_iso_code` char(2),
  `country_name` varchar(64),
   CONSTRAINT pk_country PRIMARY KEY (`geoname_id` , `locale_code`)
);

DROP TABLE city_full;
CREATE TABLE `city_full` (
  `geoname_id` int unsigned NOT NULL,
  `locale_code` varchar(32) ,
  `continent_code` char(2) ,
  `continent_name` varchar(32) ,
  `country_iso_code` char(2) ,
  `country_name` varchar(64) ,
  `subdivision_1_iso_code` varchar(3) ,
  `subdivision_1_name` varchar(128) COLLATE 'utf8_unicode_ci' ,
  `subdivision_2_iso_code` varchar(3) NOT NULL,
  `subdivision_2_name` varchar(128) COLLATE 'utf8_unicode_ci' ,
  `city_name` varchar(128) COLLATE 'utf8_unicode_ci' ,
  `metro_code` smallint unsigned ,
  `time_zone` varchar(64),
  CONSTRAINT pk_country PRIMARY KEY (`geoname_id` , `locale_code`)
);
DROP TABLE currency_full;
CREATE TABLE `currency_full` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `locale_code` varchar(32) ,
  `currency_code` VARCHAR(10),
  `currency_name` varchar(64) ,
  `symbol` VARCHAR(10) ,
  `country_code` VARCHAR(10),
   PRIMARY KEY (`ID`)
);
