 DB = maria 사용
 사용된 테이블 user  DDL
 WebFlux & MVC 사용
 (Webclient)
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `sns_id` varchar(255) DEFAULT NULL,
  `sns_type` varchar(10) DEFAULT NULL,
  `sns_profile` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

