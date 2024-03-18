/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : cloud2024

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 18/03/2024 23:38:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_pay
-- ----------------------------
DROP TABLE IF EXISTS `t_pay`;
CREATE TABLE `t_pay`  (
  `id` bigint NOT NULL COMMENT '主键id',
  `pay_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '支付流水号',
  `order_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单流水号',
  `user_id` int NULL DEFAULT 1 COMMENT '用户id',
  `amount` decimal(8, 2) NOT NULL DEFAULT 9.90 COMMENT '交易金额',
  `is_deleted` tinyint(1) NOT NULL COMMENT '删除标志，0:不删除，1:删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '支付交易表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_pay
-- ----------------------------
INSERT INTO `t_pay` VALUES (1769059751398322178, '11111', '1111', 0, 0.00, 0, NULL, NULL);
INSERT INTO `t_pay` VALUES (1769060604343570433, '11111', '1111', 0, 0.00, 0, '2024-03-17 01:58:10', '2024-03-17 01:58:10');
INSERT INTO `t_pay` VALUES (1769061647878033410, '222', '1111', 0, 0.00, 0, '2024-03-17 02:02:19', '2024-03-17 02:02:19');
INSERT INTO `t_pay` VALUES (1769733394243620866, 'abc123', 'def456', 111, 98.00, 0, '2024-03-18 22:31:36', '2024-03-18 22:31:36');

SET FOREIGN_KEY_CHECKS = 1;
