/*
 Navicat MySQL Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50739
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50739
 File Encoding         : 65001

 Date: 19/10/2022 16:52:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_customer_wallet
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer_wallet`;
CREATE TABLE `tb_customer_wallet`  (
  `c_pk_id` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键',
  `c_user_id` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '用户id',
  `n_balance` int(10) NULL DEFAULT NULL COMMENT '账户余额',
  `n_versions` int(10) NULL DEFAULT NULL COMMENT '版本号',
  `c_new_flag` varchar(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '最新标识',
  PRIMARY KEY (`c_pk_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_customer_wallet
-- ----------------------------
INSERT INTO `tb_customer_wallet` VALUES ('1', '1', 1000, 1, '0');
INSERT INTO `tb_customer_wallet` VALUES ('1582654351657160706', '1', 900, 2, '0');
INSERT INTO `tb_customer_wallet` VALUES ('1582655505308848129', '1', 800, 3, '0');
INSERT INTO `tb_customer_wallet` VALUES ('1582655556240281601', '1', 900, 4, '1');

SET FOREIGN_KEY_CHECKS = 1;
