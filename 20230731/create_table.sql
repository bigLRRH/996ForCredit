-- Active: 1690767170004@@127.0.0.1@3306@20230731_jdbc
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id` bigint NOT NULL AUTO_INCREMENT,
`username` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jim', '11111');
INSERT INTO `user` VALUES ('2', 'tom', '22222');
INSERT INTO `user` VALUES ('3', 'lucy', '3333');
INSERT INTO `user` VALUES ('4', 'laowang', '4444');
INSERT INTO `user` VALUES ('5', 'laoli', '5555');

